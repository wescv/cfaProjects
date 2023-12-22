package org.academiadecodigo.bootcamp93;

public class Player {
    public String player;
    public int guessed_number;
    public int player1_guess = ((int) (Math.random() * 10) + 1);
    public  int player2_guess = ((int) (Math.random() * 10) + 1);
    //CONSTRUCTOR
    public Player(String player){
        this.player = player;


    }

    public String getPlayer(){
        return player;
        }
    }
