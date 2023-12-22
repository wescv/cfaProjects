package org.codeforall.ooptimus;

public class ArmouredEnemy extends Enemy {
    private int armour = 100;

    public ArmouredEnemy(int health) {
        super(health);
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    @Override
    public void hit(int hit) {
        if (getArmour() >= 0) {
            setArmour(getArmour() - hit);
            System.out.println("Armour left " + getArmour());
        } else {
            super.hit(hit);
        }
    }

}
