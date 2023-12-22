package org.academiadecodigo.bootcamp93;

public class Guess {


    public int ra = ((int) (Math.random() * 10) + 1);
    public static String result;
    public int win_counter;
    public Player player1;
    public Player player2;

    //PLAYERS


    //CONSTRUCTOR
    public Guess(Player player1, Player player2) {


        this.player1 = player1;
        this.player2 = player2;
        this.result = result;
        this.ra = ra;

    }




    public void result() {
        if (ra == player1.player1_guess) {
            System.out.println("Ganhou o Player1");
        } else if (ra == player2.player2_guess) {
            System.out.println("Ganhou o Player2");
            } else {  System.out.println("try again");
        }
    }


    public void playersGuess() {


    }


}

