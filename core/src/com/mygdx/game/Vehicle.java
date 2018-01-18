package com.mygdx.game;

import com.mygdx.game.MyBaseClasses.Scene2D.MultiSpriteActor;

import java.util.Random;

/**
 * Created by tanulo on 2018. 01. 18..
 */

public class Vehicle extends MultiSpriteActor {

    int[] destinations;
    Random rand;
    float speed=10, magas;
    boolean szembe;

    public Vehicle(float width, float height) {
        super(width, height);
    }

    public boolean isSzembe() {
        return szembe;
    }

    public void setSzembe(boolean szembe) {
        this.szembe = szembe;
        if(szembe){
            setPosition(destinations[rand.nextInt(2)],magas);
            setRotation(180);
        }
        else {
            setPosition(destinations[rand.nextInt(2)+2],magas);
            setRotation(0);
        }
    }

    public void setMagas(float magas) {
        this.magas = magas;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
