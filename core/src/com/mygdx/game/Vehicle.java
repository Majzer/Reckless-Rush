package com.mygdx.game;

import com.mygdx.game.MyBaseClasses.Scene2D.MultiSpriteActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyRectangle;
import com.mygdx.game.MyBaseClasses.Scene2D.OffsetSprite;

import java.util.Collection;
import java.util.Collections;
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

    float rotationBase=0;

    public void setMagas(float magas) {
        this.magas = magas;
    }

    public float getSpeed() {
        return speed;
    }

    public void setRotationBase(float rotationBase) {
        this.rotationBase = rotationBase;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void addBaseCollisionRectangleShapeForAllSprites(){
        for(OffsetSprite offsetSprite : getSprites()){
            addCollisionShape(offsetSprite.getCollision(),new MyRectangle(offsetSprite.getWidth(),offsetSprite.getHeight(),offsetSprite.getxOffset(),offsetSprite.getyOffset(),getOriginX(),getOriginY()));
        }
    }

    boolean goToSide=false, goToLeftSide=false, goToRightSide=false;


    public void setGoToSide(boolean goToSide) {
        this.goToSide = goToSide;
    }

    public void setGoToRightSide(boolean goToRightSide) {
        this.goToRightSide = goToRightSide;
    }

    public void setGoToLeftSide(boolean goToLeftSide) {

        this.goToLeftSide = goToLeftSide;
    }

    public boolean isGoToSide() {
        return goToSide;
    }

    public boolean isGoToLeftSide() {
        return goToLeftSide;
    }

    public boolean isGoToRightSide() {
        return goToRightSide;
    }

    boolean mehet = true;

    @Override
    public void act(float delta) {
        super.act(delta);
        if(!isSzembe())
        setRotation(rotationBase);
        else setRotation(180-rotationBase);
        if(goToSide) {
            if((int)getY()==destinations[0] || (int)getY()==destinations[1]) setX(getX()-2);
            else setX(getX()+2);
        }
        if(goToLeftSide){
            setX(getX()-2);
        }
        if(goToRightSide){
            setX(getX()+2);
        }
    }
}
