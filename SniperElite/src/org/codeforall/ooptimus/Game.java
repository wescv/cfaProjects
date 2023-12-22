package org.codeforall.ooptimus;

public class Game {
    private GameObject[] gameObjects;
    private SniperRifle sniperRifle;
    private static int shotsFired;

    public Game(int gameObjects) {
        this.gameObjects = new GameObject[gameObjects];
        sniperRifle = new SniperRifle();
    }

    public static void setShotsFired(int shotsFired) {
        Game.shotsFired = shotsFired;
    }

    public static int getShotsFired() {
        return shotsFired;
    }

    public void start() {
        createObjects();
    }

    public GameObject[] createObjects() {
        for (int i = 0; i < gameObjects.length; i++) {
            if (SniperRifle.random() < 20) {
                gameObjects[i] = new Tree();
                System.out.println(gameObjects[i].getMessage());
                System.out.println("-------------------------------------------------------------");
            } else if (SniperRifle.random() % 2 == 0) {
                gameObjects[i] = new SoldierEnemy(100);
                System.out.println("Soldier Enemy");
                sniperRifle.shoot((Enemy) gameObjects[i]);
                System.out.println("-------------------------------------------------------------");
            } else {
                gameObjects[i] = new ArmouredEnemy(100);
                System.out.println("Armour soldier");
                sniperRifle.shoot((Enemy) gameObjects[i]);
                System.out.println("-------------------------------------------------------------");
            }
        }
        System.out.println("\n\nShoot fired " + getShotsFired());
        return gameObjects;
    }
}
