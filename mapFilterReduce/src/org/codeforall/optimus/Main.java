package org.codeforall.optimus;

import java.util.Arrays;
import java.util.stream.Collectors;



public class Main {
    public static void main(String[] args) {

        String message = "I'll send an SOS to the garbage world, " +
                "I hope that someone garbage gets my message in a garbage bottle.";

        String newMessage = Arrays.stream(message.split(" "))
                .filter(w -> !w.equalsIgnoreCase("garbage"))
                .collect(Collectors.joining(" "));


        //newMessage = newMessage.toUpperCase();
        System.out.println(newMessage.toUpperCase());


    }
}