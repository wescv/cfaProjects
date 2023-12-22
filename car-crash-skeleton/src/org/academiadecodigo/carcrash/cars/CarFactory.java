package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.Game;
import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

import java.io.File;

public class CarFactory {
    String brand;
    double speed;


    public CarFactory(String brand, double speed) {
        this.brand = brand;
        this.speed = speed;

    }

    public static Car getNewCar() {
        int min = 0;
        int max = 10;
        int maxCol = 100;
        int minCol = 0;
        int maxRow = 25;
        int minRow = 0;
        int num = (int) Math.floor(Math.random() * (max - min + 1) + min);
        int colRando = (int)Math.floor(Math.random() * (maxCol - minCol + 1) + min);
        int rowRando = (int)Math.floor(Math.random() * (maxRow - minRow + 1) + min);
        if (num % 2 == 0)
            return new Fiat("A", 15, new Position(colRando, rowRando));



        else
            return new Mustang("M", 40, new Position(colRando,rowRando));


    }



}
