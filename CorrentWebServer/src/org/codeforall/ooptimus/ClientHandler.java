package org.codeforall.ooptimus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable {

    Socket socket;
    List<Socket> socketList;

    public ClientHandler(Socket socket, List<Socket> socketList) {
        this.socket = socket;
        this.socketList = socketList;
    }

    @Override
    public void run() {

        try {
            BufferedReader sendMessage = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String clientAddress = socket.getRemoteSocketAddress().toString();

            for (Socket socketList : socketList) {
                PrintWriter connectedOut = new PrintWriter(socketList.getOutputStream(), true);
                connectedOut.println("Client " + clientAddress + " has connected: ");
            }
            String message;

            while ((message = sendMessage.readLine()) != null) {
                System.out.println("Message sent from " + clientAddress + ": " + message);

                for (Socket connectedSocket : socketList) {
                    if (connectedSocket != socket) {
                        PrintWriter connectedOut = new PrintWriter(connectedSocket.getOutputStream(), true);
                        connectedOut.println("Message sent from " + clientAddress + ": " + message);
                    }
                }
            }
            for (Socket connectedSocket : socketList) {
                PrintWriter connectedOut = new PrintWriter(connectedSocket.getOutputStream(), true);
                connectedOut.println("Client disconnected: " + clientAddress);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
