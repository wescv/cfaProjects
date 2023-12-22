package org.codeforall.ooptimus;

public class Enemy extends GameObject {
    private int health;
    private boolean isDead = false;

    public Enemy(int health) {

        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean isDead() {
        return isDead;
    }

    public void hit(int hit) {
        if (health >= 1) {
            health -= hit;
            System.out.println("Health left " + getHealth());
            if (health <= 0) {
                setDead(true);
                System.out.println(getMessage());
            }
        }
    }

    @Override
    public String getMessage() {
        return "Enemy dead";
    }
}
