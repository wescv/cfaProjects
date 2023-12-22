package org.codeforall.ooptimus;

import javax.security.auth.Destroyable;

public class Barrel extends GameObject implements Destroyable {
    private BarrelType barrelType;
    private int currentDamage;
    private boolean destroyed;


    public Barrel(BarrelType barrelType){
      barrelType = new barrelType[](BarrelType.valueOf())
    }

    public void hit (int hit){


    }

}
