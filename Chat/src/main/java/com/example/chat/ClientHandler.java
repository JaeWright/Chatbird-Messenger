package com.example.chat;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * ClientHandler class that interacts with the Client(s) on the server side
 * @author Jackie Jiang, Jaelen Wright, Amanda Showler, Amit Sarvate
 * @version 1.0
 * Date: Apr 10
 */
public class ClientHandler implements Runnable {

    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    /**
     * ClientHandler constructor
     * @param socket
     */
    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out= new PrintWriter(socket.getOutputStream(),true);

            clientHandlers.add(this);//add to clientHandlers arraylist
        } catch (IOException e) {
            closeEverything(socket, in, out);
        }
    }

    /**
     * run object that will implement runnable
     * This is used to recieve any message coming from any client
     * and send it back to the the connected client(s)
     */
    @Override
    public void run() {
        String messageFromClient;
        while (socket.isConnected()) {
            try {
                // Read what the client sent and then send it to every other client.
                messageFromClient = in.readLine();
                //System.out.println(messageFromClient);
                sendMessage(messageFromClient);
            } catch (IOException e) {
                closeEverything(socket, in, out);
                break;
            }
        }
    }

    /**
     * sendMessage client that will send a message to all
     * of the connected clients
     * @param messageToSend
     */
    public void sendMessage(String messageToSend) {
        for (ClientHandler clientHandler : clientHandlers) {
            clientHandler.out.println(messageToSend);
        }
    }

    /**
     * removeClientHandler method that will remove clientHandler
     */
    public void removeClientHandler() {
        clientHandlers.remove(this);
    }

    /**
     * A method that will close all the objects used
     * @param socket
     * @param in
     * @param out
     */
    public void closeEverything(Socket socket, BufferedReader in, PrintWriter out) {
        removeClientHandler();
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
}

