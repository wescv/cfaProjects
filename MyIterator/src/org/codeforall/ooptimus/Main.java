package org.codeforall.ooptimus;

public class Main {
    public static void main(String[] args) {

        MyDynamic myDynamic = new MyDynamic(0,10);
        //myDynamic.iterator().remove();
        //myDynamic.iterator().hasNext();

        for(Integer number : myDynamic){
            System.out.println(number);
        }
    }
}