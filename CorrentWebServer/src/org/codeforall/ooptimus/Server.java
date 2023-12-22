package org.codeforall.ooptimus;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {

        final int serverPort = 7777;
        startServer(serverPort);
    }

    public static void startServer(int serverPort) throws IOException {
        List<Socket> connectedSockets = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(serverPort);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            connectedSockets.add(clientSocket);
            executorService.submit(new ClientHandler(clientSocket, connectedSockets));

        }
    }

}