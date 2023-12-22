package org.codeforall.ooptimus;

public class Wallet {
    private Acc acc;
    private double walletBalance;


    public Wallet(double walletBalance){
        this.walletBalance = walletBalance;

    }
    public void setWalletCashIn(double amount) {
            this.walletBalance += amount;
            acc.setAccBalance(acc.getAccBalance() - amount);
        System.out.println("You RECEIVED " +amount+" € in your WALLET from your ACCOUNT -->>  BALANCE UPDATE -->> ACCOUNT: "+acc.getAccBalance()+" €    WALLET: "+walletBalance+" €");
    }

    public void setWalletCashOut(double amount) {
            if (amount > this.walletBalance) {
                System.out.println("Not enough funds for this operation.");
            } else {
                this.walletBalance -= amount;
                System.out.println("You withdraw " + amount + " from you account, your current balance now is " + walletBalance);
            }
    }

    public double getWalletBalance() {
            return this.walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public void setAcc(Acc y) {
        this.acc = y;
    }
}
