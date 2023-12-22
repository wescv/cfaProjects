package org.codeforall.ooptimus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleCurl {
    public static void main(String[] args) {
        String url = "https://www.g<entoo.org";

        try {
            URL reachable = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) reachable.openConnection();

            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            System.out.println("Response Code: " + statusCode + "\n");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            in.close();

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}