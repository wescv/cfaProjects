package org.codeforall.ooptimus;

public class Main {
    public static void main(String[] args) {

        Machine.Add mc = (i1, i2) -> i1 + i2;
        int result = mc.add(3, 7);
        System.out.println(result);

        Machine.Sub su = ((i1, i2) -> i1 - i2);
        System.out.println(su.sub(20, 30));

    }
}