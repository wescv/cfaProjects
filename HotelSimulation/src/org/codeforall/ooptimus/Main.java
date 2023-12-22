package org.codeforall.ooptimus;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Venus");
        Client client = new Client("Joe", hotel);
        client.checkIn();

    }


}