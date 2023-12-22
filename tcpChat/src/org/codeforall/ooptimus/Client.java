package org.codeforall.ooptimus;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        final String serverHostname = "localhost";
        final int serverPort = 8018;

        while (true) {
            try (Socket clientSocket = new Socket(serverHostname, serverPort);
                 BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
                 PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                System.out.print("Send data to the server: ");
                String clientMessage;

                while ((clientMessage = inFromUser.readLine()) != null) {
                    System.out.println("Received data from client: " + clientMessage);


                    outToServer.println(clientMessage);

                    String serverResponse = inFromServer.readLine();
                    System.out.println(serverResponse);

                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
