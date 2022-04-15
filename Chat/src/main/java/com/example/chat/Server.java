package com.example.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server class that interacts with the Client(s)
 * This class will send and recieve data to and from the server
 * @author Jackie Jiang, Jaelen Wright, Amanda Showler, Amit Sarvate
 * @version 1.0
 * Date: Apr 10
 */

public class Server {

    private final ServerSocket serverSocket;

    /**
     * Server constructor class
     * @param serverSocket
     */
    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    /**
     * startServer method that will start the server
     * This method will also create a new Thread for any new
     * clients that are connected
     */
    public void startServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected!");
                //Create new thread for client
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    /**
     * main method that will start the server
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2222);
        Server server = new Server(serverSocket);
        server.startServer();
    }

}
