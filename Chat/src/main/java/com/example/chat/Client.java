package com.example.chat;

import javafx.scene.control.TextArea;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client class that interacts with the Server
 * This class will send and receive data to and from the server
 * @author Jackie Jiang, Jaelen Wright, Amanda Showler, Amit Sarvate
 * @version 1.0
 * Date: Apr 10
 */

public class Client {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    private String username;
    public TextArea textBox;
    private String msgFromGroupChat;

    /**
     * Client constructor that will initlize all the variables 
     * for a new Client class
     * @param socket
     * @param username
     * @param textBox
     */
    public Client(Socket socket, String username, TextArea textBox) {
        this.textBox = textBox;
        try {
            this.socket = socket;
            this.username = username;

            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out= new PrintWriter(socket.getOutputStream(),true);

        } catch (IOException e) {
            e.printStackTrace();
            closeEverything(socket, in, out);
        }
    }
    /**
     * sendMessage method that will obtain a user input
     * and send the obtained data to the server
     */
    public void sendMessage() {
        out.println(username);
        Scanner scanner = new Scanner(System.in);
        while (socket.isConnected()) {
            String message = scanner.nextLine();
            //out.println(username + ": " + message);
        }
    }

    /**
     * sendMessage method that will obtain a user input
     * and send the obtained data to the server
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException{
        //send message
        out.println(message);
    }

    /**
     * listenForMessage method that will try to receive data
     * coming from the server and append said data to the textBox
     * @throws IOException
     */
    public void listenForMessage() throws IOException{
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()) {
                    try {
                        msgFromGroupChat = in.readLine(); //Recieve message
                        //System.out.println(msgFromGroupChat);
                        //Append message to the client's textBox
                        textBox.appendText(msgFromGroupChat + '\n');
                    } catch (IOException e) {
                        e.printStackTrace();
                        closeEverything(socket, in, out);
                    }
                }
            }
        }).start();
    }

    /**
     * A method that will close all the objects used
     * @param socket
     * @param in
     * @param out
     */
    public void closeEverything(Socket socket, BufferedReader in, PrintWriter out){
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

    /**
     * main method that is used for testing purposes
     * @param args
     * @throws IOException
     */
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

