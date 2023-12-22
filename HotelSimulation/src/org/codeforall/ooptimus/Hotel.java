package org.codeforall.ooptimus;

public class Hotel {
    private String hotelName;
    private Room room;


    public Hotel(String hotelName) {
        this.hotelName = hotelName;
        room = new Room(1);
    }

    public void checkIn() {
        room.setCheckIn(true);
        Room room1 = new Room(3);
    }

    public String getHotelName() {
        return hotelName;
    }

}
