
package org.academiadecodigo.bootcamp93;

public class Character {

    private String gender;
    private int age;
    private String race;
    private String ability;
    private String nation;

    //Constructor
    public Character( int age, String race, String ability, String nation){

        this.age = age;
        this.race = race;
        this.ability = ability;
        this.nation = nation;
    }

    // SETTER
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setRace(String race){
        this.race = race;
    }

    //GETTER
    public String getGender(){
        return gender;
    }
    public int setAge(){

        return age;
    }
    public String getRace(){
        return race;
    }
    public String getAbility(){
        return ability;
    }
    public String getNation(){
        return nation;
    }
}

