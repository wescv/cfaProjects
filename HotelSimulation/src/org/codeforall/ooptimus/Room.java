package org.codeforall.ooptimus;

public class Room {
    private int roomNumber;
    private boolean checkIn;


    public Room(int roomNumber) {
        this.roomNumber = roomNumber;

    }
    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;

        if (checkIn == true) {
            System.out.println("Welcome!");
        } else {
            System.out.println("There is no room available.");
        }

    }


}
