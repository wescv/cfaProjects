package org.codeforall.ooptimus;

public class SniperRifle {
    private int bulletDamage = 1;
    private final float HIT_PROB = 0.3f;

    public int getBulletDamage() {
        return bulletDamage;
    }

    public void setBulletDamage(int bulletDamage) {
        this.bulletDamage = bulletDamage;
    }

    public static int random() {
        return (int) (Math.random() * 100);
    }

    public void shootBarrel(Destroyable target){
        if (Math.random() < HIT_PROB) {

        }
    }



    public void shoot(Enemy enemy) {
        while (!enemy.isDead()) {
            Game.setShotsFired(Game.getShotsFired() + 1);
            int shoot = random();
            if (random() > 30) {
                setBulletDamage(shoot);
                System.out.println("Hit damage deal " + getBulletDamage());
                enemy.hit(shoot);
            } else {
                System.out.print("");
            }
        }
    }
}
