package org.codeforall.ooptimus;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Server {
    public static void main(String[] args) {
        final int serverPort = 8018;
        startServer(serverPort);
    }

    public static void startServer(int serverPort) {
        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {
            System.out.println("Your TCP server is running on port: " + serverPort);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream())) {

                    String request = in.readLine();

                    if (request == null) {
                        continue;
                    }

                    System.out.println("Received request: " + request);

                    String response;
                    String requestedResource = getResourceFromRequest(request);

                    if (requestedResource.isEmpty() || "index.html".equals(requestedResource)) {
                        response = "HTTP/1.0 200 Document Follows\r\n" +
                                "Content-Type: text/html\r\n" +
                                "Content-Length: " + getContentLength("www/index.html") + "\r\n" +
                                "\r\n";
                        byte[] htmlBytes = Files.readAllBytes(Paths.get("www/index.html"));
                        out.write(response.getBytes());
                        out.write(htmlBytes);
                    } else {
                        response = "HTTP/1.0 404 Not Found\r\n" +
                                "Content-Type: text/html\r\n" +
                                "Content-Length: " + getContentLength("www/404.html") + "\r\n" +
                                "\r\n";
                        byte[] notFoundHtmlBytes = Files.readAllBytes(Paths.get("www/404.html"));
                        out.write(response.getBytes());
                        out.write(notFoundHtmlBytes);
                    }

                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getResourceFromRequest(String request) {

        String[] parts = request.split(" ");
        if (parts.length >= 2) {
            String path = parts[1].substring(1);
            if (path.isEmpty()) {
                return "index.html";
            }
            return path;
        }
        return "";
    }


    private static int getContentLength(String filePath) {
        try {
            Path path = Paths.get(filePath);
            return (int) Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}