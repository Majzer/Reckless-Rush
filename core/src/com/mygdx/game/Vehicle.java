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

    static int[] destinations;
    Random rand;
    float speed=10, magas;
    boolean szembe;
    GameStage gameStage;

    public Vehicle(float width, float height, GameStage gameStage) {
        super(width, height);
        this.gameStage = gameStage;
        setZIndex(Integer.MAX_VALUE);
    }

    public boolean isSzembe() {
        return szembe;
    }

    public void setSzembe(boolean szembe) {
        this.szembe = szembe;
        if (destinations.length == 4) {
            if (szembe) {
                if (!worldRotation) {
                    setPosition(destinations[rand.nextInt(2)], magas);
                    setRotation(180);
                } else {
                    setPosition(magas, destinations[rand.nextInt(2)]);
                    setRotation(0);
                }
            } else {
                if (!worldRotation) {
                    setPosition(destinations[rand.nextInt(2) + 2], magas);
                } else setPosition(magas, destinations[rand.nextInt(2) + 2]);
                setRotation(0);
            }
        }else{
            if (szembe){
                if (!worldRotation) {
                    setPosition(destinations[0], magas);
                    setRotation(180);
                } else {
                    setPosition(magas, destinations[0]);
                    setRotation(0);
                }
            }else{
                if (!worldRotation) {
                    setPosition(destinations[1], magas);
                } else setPosition(magas, destinations[1]);
                setRotation(0);
            }
        }
    }


    boolean worldRotation=false;

    public void setWorldRotation(boolean worldRotation) {
        this.worldRotation = worldRotation;
        if(worldRotation) destinations = new int[]{gameStage.getViewport().getScreenY()-100,gameStage.getViewport().getScreenY()-300,gameStage.getViewport().getScreenY()-600,gameStage.getViewport().getScreenY()-800};
        for(int i : destinations){
            System.out.println("i = " + i);
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
        if(!isSzembe()) setRotation(rotationBase);
        else if(isSzembe() && !worldRotation)setRotation(180-rotationBase);
        else if(isSzembe() && worldRotation) setRotation(0-rotationBase);
        //else if (!isSzembe() && worldRotation)
        if(goToSide) {
            if((int)getY()==destinations[0] || (int)getY()==destinations[1]) setX(getX()-2);
            else setX(getX()+2);
        }
        if(goToLeftSide){
            if(!worldRotation)
            setX(getX()-2);
            else setY(getY()+2);
        }
        if(goToRightSide){
            if(!worldRotation)
            setX(getX()+2);
            else setY(getY()-2);
        }
    }
}
