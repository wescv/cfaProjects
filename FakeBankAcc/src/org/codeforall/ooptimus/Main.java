package org.codeforall.ooptimus;

public class Main {


    public static void main(String[] args) {
        // stances, dar vida.
        Acc acc = new Acc(1000);
        Wallet wallet = new Wallet(350);
        Npc npc = new Npc("Joe", acc, wallet);

        acc.setAccCashOut(100);
        acc.setAccCashIn(50);
        wallet.setWalletCashIn(300);
        wallet.setWalletCashOut(400);

    }

}