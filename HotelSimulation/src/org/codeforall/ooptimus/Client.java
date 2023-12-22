package org.codeforall.ooptimus;

public class Client {

    private Hotel hotel;
    private String name;

    public Client(String name, Hotel hotel) {
        this.name = name;
        this.hotel = hotel;

    }

    public void checkIn() {
        hotel.checkIn();
    }


}
