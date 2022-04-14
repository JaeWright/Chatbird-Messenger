package com.example.chat;

import javafx.scene.control.TextArea;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
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
        out.println(username);
        Scanner scanner = new Scanner(System.in);
        while (socket.isConnected()) {
            String message = scanner.nextLine();
            out.println(username + ": " + message);
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public void listenForMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msgFromGroupChat;
                while (socket.isConnected()) {
                    try {
                        msgFromGroupChat = in.readLine();
                        textBox.appendText(msgFromGroupChat + "\n");
                        System.out.println(msgFromGroupChat);
                    } catch (IOException e) {
                        closeEverything(socket, in, out);
                    }
                }
            }
        }).start();
    }

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

    public static void main(String[] args) throws IOException {
        // Get a username for the user and a socket connection.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username for the group chat: ");
        String username = scanner.nextLine();
        // Create a socket to connect to the server.
        Socket socket = new Socket("localhost", 2222);

        // Pass the socket and give the client a username.
        Client client = new Client(socket, username,null);
        client.listenForMessage();
        client.sendMessage();
    }
}

