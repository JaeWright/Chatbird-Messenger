package com.example.chat;

import javafx.scene.control.TextArea;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    // A client has a socket to connect to the server and a reader and writer to receive and send messages respectively.
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    private String username;
    public TextArea textBox;

    public Client(Socket socket, String username, TextArea textBox) {
        this.textBox = textBox;
        try {
            this.socket = socket;
            this.username = username;

            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out= new PrintWriter(socket.getOutputStream(),true);

        } catch (IOException e) {
            closeEverything(socket, in, out);
        }
    }
    public void sendMessage() {
        // Initially send the username of the client.
        out.println(username);
        // Create a scanner for user input.
        Scanner scanner = new Scanner(System.in);
        // While there is still a connection with the server, continue to scan the terminal and then send the message.
        while (socket.isConnected()) {
            String message = scanner.nextLine();
            //textBox.appendText(username + ": " + message);
            out.println(username + ": " + message);
        }
    }

    public void sendMessage(String message) {
        //textBox.appendText(message+'\n');
        out.println(message);
    }

    // Listening for a message is blocking so need a separate thread for that.
    public void listenForMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msgFromGroupChat;
                // While there is still a connection with the server, continue to listen for messages on a separate thread.
                while (socket.isConnected()) {
                    try {
                        // Get the messages sent from other users and print it to the console.
                        msgFromGroupChat = in.readLine();
                        textBox.appendText(msgFromGroupChat + "\n");
                        System.out.println(msgFromGroupChat);
                    } catch (IOException e) {
                        // Close everything gracefully.
                        closeEverything(socket, in, out);
                    }
                }
            }
        }).start();
    }

    // Helper method to close everything so you don't have to repeat yourself.
    public void closeEverything(Socket socket, BufferedReader in, PrintWriter out) {
        try {
            if (null != in) {
                in.close();
            }
            if (null != out) {
                out.close();
            }
            if (null != socket) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Run the program.
    public static void main(String[] args) throws IOException {

        // Get a username for the user and a socket connection.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username for the group chat: ");
        String username = scanner.nextLine();
        // Create a socket to connect to the server.
        Socket socket = new Socket("localhost", 1234);

        // Pass the socket and give the client a username.
        Client client = new Client(socket, username,null);
        // Infinite loop to read and send messages.
        client.listenForMessage();
        client.sendMessage();
    }
}

