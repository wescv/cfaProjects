package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

public class Fiat extends Car {
    String nome;
    int speed;


    public Fiat(String nome, int speed, Position position) {
        super(position);
        this.nome = nome;
        this.speed = speed;

    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
