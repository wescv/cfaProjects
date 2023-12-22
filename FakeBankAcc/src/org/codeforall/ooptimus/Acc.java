package org.codeforall.ooptimus;

public class Acc {

    private Wallet wallet;
    private double accBalance;

    //CONSTRUCTOR
    public Acc (double accBalance){
        this.accBalance = accBalance;

    }

    public void accBalance(double accBalance) {
        this.accBalance = accBalance;
    }

    public void setAccCashIn(double amount) {
        accBalance += amount;
        wallet.setWalletBalance(wallet.getWalletBalance() - amount);
        System.out.println("You RECEIVED " +amount+" € in your ACCOUNT from your WALLET -->>  BALANCE UPDATE -->> ACCOUNT: "+accBalance+" €    WALLET: "+wallet.getWalletBalance()+" €");
    }


    public void setAccCashOut(double amount) {
        if (amount > this.accBalance) {
            System.out.println("Not enough funds for this.");
        } else {
            this.accBalance -= amount;
            System.out.println("You withdraw " + amount + " from you account, your current balance now is " + accBalance);
        }
    }
    public double getAccBalance() {
        return this.accBalance;
    }

    public void setWallet(Wallet x) {
        this.wallet = x;
    }

    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }
}