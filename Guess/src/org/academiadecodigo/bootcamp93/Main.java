package org.academiadecodigo.bootcamp93;

import javax.annotation.processing.Generated;

public class Main {
    public static void main(String[] args) {


        Player player1 = new Player("A");



        Player player2 = new Player("B");



        Guess guess = new Guess(player1, player2);
        System.out.println();

        System.out.println(guess.ra+ "  random alvo");
        System.out.println(player1.player1_guess+ "   player 1");
        System.out.println(player2.player2_guess+ "   player 2");
        guess.result();
    }


}