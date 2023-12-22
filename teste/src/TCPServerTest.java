import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServerTest {

    public static void main(String[] args) {
        final int PORT = 12345;
        ServerSocket serverSocket = null;
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Socket> connectedSockets = new ArrayList<>();

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());
                connectedSockets.add(clientSocket);
                executorService.submit(new ClientHandler(clientSocket, connectedSockets));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private List<Socket> connectedSockets;

    public ClientHandler(Socket socket, List<Socket> connectedSockets) {
        this.socket = socket;
        this.connectedSockets = connectedSockets;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String clientAddress = socket.getRemoteSocketAddress().toString();

            // Notify all clients when a new client connects
            for (Socket connectedSocket : connectedSockets) {
                PrintWriter connectedOut = new PrintWriter(connectedSocket.getOutputStream(), true);
                connectedOut.println("New client connected: " + clientAddress);
            }

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received from " + clientAddress + ": " + message);

                // Broadcast the message to all connected clients
                for (Socket connectedSocket : connectedSockets) {
                    if (connectedSocket != socket) {
                        PrintWriter connectedOut = new PrintWriter(connectedSocket.getOutputStream(), true);
                        connectedOut.println("From " + clientAddress + ": " + message);
                    }
                }
            }

            in.close();
            out.close();
            socket.close();
            connectedSockets.remove(socket);

            // Notify all clients when a client disconnects
            for (Socket connectedSocket : connectedSockets) {
                PrintWriter connectedOut = new PrintWriter(connectedSocket.getOutputStream(), true);
                connectedOut.println("Client disconnected: " + clientAddress);
            }
            System.out.println("Connection with " + clientAddress + " closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
