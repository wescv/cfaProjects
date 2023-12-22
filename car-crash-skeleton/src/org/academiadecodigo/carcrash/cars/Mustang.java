package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;


public class Mustang extends Car {
    String brand;
    int speed;

    public Mustang(String brand, int speed, Position position) {
        super(position);
        this.brand = brand;
        this.speed = speed;

    }

    @Override
    public String toString() {
        return brand;
    }
}