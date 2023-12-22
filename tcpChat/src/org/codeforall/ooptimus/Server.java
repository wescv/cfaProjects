package org.codeforall.ooptimus;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        final int serverPort = 8018;
        startServer(serverPort);
    }


    public static void startServer(int serverPort) {
        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {
            System.out.println("Your TCP server is running on port: " + serverPort);

            while (true) {

                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


                System.out.println("Received connection from client: " + clientSocket);
                String clientMessage;
                String serverMessage;

                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Received data from client: " + clientMessage);

                    String responseMessage = "Server Response: " + clientMessage;
                    out.println(responseMessage);
                }

                while ((serverMessage = in.readLine()) != null) {
                    System.out.println("Received data from client: " + serverMessage);

                }

                clientSocket.close();
                System.out.println("Connection with client closed: " + clientSocket);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
