package org.academiadecodigo.bootcamp93;

public class Main {
    public static void main(String[] args) {



        Character character1 = new Character( 1200, "", "Mage", "Dark");
        character1.setGender("Male");
        System.out.println(character1.getNation()+" Nation");
        System.out.println(character1.getRace()+" Race");
        System.out.println(character1.getAbility()+" Power");
        System.out.println(character1.getGender());




    }

}