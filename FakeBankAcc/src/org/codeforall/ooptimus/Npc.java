package org.codeforall.ooptimus;

public class Npc {

    private String name;
    private Acc acc;
    private Wallet wallet;
    //CONSTRUCTOR
    public Npc (String name, Acc acc, Wallet wallet){
        this.name = name;
        this.acc = acc;
        this.wallet = wallet;

        acc.setWallet(wallet);
        wallet.setAcc(acc);
    }
    //GETTER
    public String getName() {
        return name;
    }
}
