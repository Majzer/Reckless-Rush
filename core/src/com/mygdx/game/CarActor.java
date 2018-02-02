package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.RoadFrame;
import com.mygdx.game.MyBaseClasses.Scene2D.MyRectangle;
import com.mygdx.game.MyBaseClasses.Scene2D.OffsetSprite;

/**
 * Created by tanulo on 2018. 01. 08..
 */



public class CarActor extends Vehicle {

    GameStage gameStage;
    float wantedSpeed=10;
    float currentSpeed=10;
    int life = 200;

    public boolean contains(int[] t, int i){
        for(int ii : t){
            if(ii==i) return true;
        }
        return false;
    }

    public boolean isLastElementOfArray(int[] t, int i){
        int length = t.length;
        return t[length-1]==i;
    }

    public boolean isFirstElementOfArray(int[] t, int i){
        return t[0]==i;
    }



    public CarActor(GameStage gameStage) {
        super(566,1068, gameStage);
        setOrigintoCenter();
        addCollisionShape("Frustum", new MyRectangle(1024,22048,-256,-512,getOriginX(), getOriginY()));

        this.gameStage=gameStage;
        destinations = new int[]{gameStage.getViewport().getScreenX()+200,gameStage.getViewport().getScreenX()+300,gameStage.getViewport().getScreenX()+600,gameStage.getViewport().getScreenX()+800};
        setPosition(destinations[2],gameStage.getViewport().getScreenHeight()/3);
        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.B_SEGG_EP),
                        Assets.manager.get(Assets.B_SEGG_TOROTT)
                }
                ,0, 0), "BAL_SEGG");
        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.B_HATSO_EP),
                        Assets.manager.get(Assets.B_HATSO_TOROTT)
                }
                ,0, 55), "BAL_HATSO");
        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.B_OLDAL_EP),
                        Assets.manager.get(Assets.B_OLDAL_TOROTT)
                }
                ,0,361),"BAL_OLDAL");
        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.B_ELSO_EP),
                        Assets.manager.get(Assets.B_ELSO_TOROTT)
                }
                ,0,745),"BAL_ELSO");
        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.B_ORR_EP),
                        Assets.manager.get(Assets.B_ORR_TOROTT)
                }
                ,0,1013),"BAL_ORR");




        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.J_SEGG_EP),
                        Assets.manager.get(Assets.J_SEGG_TOROTT)
                }
                ,283,0),"JOBB_SEGG");
        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.J_HATSO_EP),
                        Assets.manager.get(Assets.J_HATSO_TOROTT)
                }
                ,283,55),"JOBB_HATSO");
        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.J_OLDAL_EP),
                        Assets.manager.get(Assets.J_OLDAL_TOROTT)
                }
                ,283,361),"JOBB_OLDAL");
        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.J_ELSO_EP),
                        Assets.manager.get(Assets.J_ELSO_TOROTT)
                }
                ,283,745),"JOBB_ELSO");
        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.J_ORR_EP),
                        Assets.manager.get(Assets.J_ORR_TOROTT)
                }
                ,283,1013),"JOBB_ORR");
        addBaseCollisionRectangleShapeForAllSprites();
        setSize(getWidth()/5.5f,getHeight()/5.5f);
        //setOrigintoCenter();
        /*
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        for(OffsetSprite sprite : spriteMap.values()){
            System.out.println("sprite.getOriginX() = " + sprite.getOriginX());
            System.out.println("sprite.getOriginY() = " + sprite.getOriginY());
        }
        for (int i =1; i<11; i++){
            OffsetSprite srite = getSprite(i);
            //srite.setOrigin(getWidth()/2,getHeight()/2);
            addSprite(new OffsetSprite(Assets.manager.get(Assets.TESZT_TEXTURE),srite.getOriginX(),srite.getOriginY(),99));
        }*/
        //setSize(getWidth()/5,getHeight()/5);
        //removeSprite("JOBB_OLDAL_EP");
        //addSprite(new OffsetSprite(Assets.manager.get(Assets.J_OLDAL_EP),283,361,5),"JOBB_OLDAL_");
        /*
        changeSprite("BAL_SEGG_",new OffsetSprite(Assets.manager.get(Assets.B_SEGG_TOROTT),0,0));
        changeSprite("BAL_HATSO_",new OffsetSprite(Assets.manager.get(Assets.B_HATSO_TOROTT),0,11));
        changeSprite("BAL_OLDAL",new OffsetSprite(Assets.manager.get(Assets.B_OLDAL_TOROTT),0,72));
        changeSprite("BAL_ELSO",new OffsetSprite(Assets.manager.get(Assets.B_ELSO_TOROTT),0,149));
        changeSprite("BAL_ORR",new OffsetSprite(Assets.manager.get(Assets.B_ORR_TOROTT),0,203));
        changeSprite("JOBB_ELSO",new OffsetSprite(Assets.manager.get(Assets.J_ELSO_TOROTT),57,149));
        changeSprite("JOBB_ORR",new OffsetSprite(Assets.manager.get(Assets.J_ORR_TOROTT),57,203));
        changeSprite("JOBB_OLDAL",new OffsetSprite(Assets.manager.get(Assets.J_OLDAL_TOROTT),57,72));
        changeSprite("JOBB_SEGG",new OffsetSprite(Assets.manager.get(Assets.J_SEGG_TOROTT),57,0));
        changeSprite("JOBB_HATSO",new OffsetSprite(Assets.manager.get(Assets.J_HATSO_TOROTT),57,11));
        */
        super.originChanged();
    }

    public float getSpeed() {
        return currentSpeed;
    }

    public void setSpeed(float speed) {
        this.currentSpeed = speed;
    }

    public void refreshDestinations(){
        if(gameStage.roadFrame.utminoseg == RoadFrame.Utminoseg.joegysavos){
            destinations = new int[]{gameStage.getViewport().getScreenX()-500, gameStage.getViewport().getScreenX()-700};
        }
    }

    @Override
    public void init() {

    }

    int [] destinations;
    int mostani=2;
    boolean mehetBalra=false;
    boolean mehetJobbra=false;
    boolean mehetJobbraAlap=true;
    boolean mehetBalraAlap=true;
    int cel=0;
    boolean worldRotation=false;

    @Override
    public void setWorldRotation(boolean worldRotation) {
        this.worldRotation = worldRotation;
        if(worldRotation) destinations = new int[]{gameStage.getViewport().getScreenY()-100,gameStage.getViewport().getScreenY()-300,gameStage.getViewport().getScreenY()-600,gameStage.getViewport().getScreenY()-800};
        for(int i : destinations){
            //System.out.println("i = " + i);
        }
    }

    public float getRotationBase() {
        return rotationBase;
    }


    public void rotateByBase(){

    }

    boolean kenyszerithet=true;

    public void intteKenyszerit(){
        //System.out.println("getX() = " + getX());
        setX((int)getX());
       // System.out.println("getX()2 = " + getX());
        //System.out.println("getY() = " + getY());
        setY((int)getY());
        //System.out.println("getY()2 = " + getY());
        kenyszerithet=false;
    }


    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {

        return life;
    }

    public boolean die(int lif) {
        if(lif == 0) return true;
        else return false;
    }

    public int ChangeLife(int num, int lif) {
        return lif-num;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        //System.out.println("getY() = " + getY());
        if(wantedSpeed > currentSpeed)
            currentSpeed *= 1.01;
        if(mehet) {
            if (mehetBalraAlap)
                if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.getAccelerometerY() < -3) {
                    //if(mostani>0&&!mehetJobbra)
                    if(!worldRotation) {
                        if (!(isFirstElementOfArray(destinations, (int) getX()))) {
                            setX(getX() - 1);
                            if (mehetJobbra) {
                                mehetJobbra = false;
                            }
                            mehetBalra = true;
                        }
                    } else {
                        if (!(isFirstElementOfArray(destinations, (int) getY()))) {
                            setY(getY() + 1);
                            if (mehetJobbra) {
                                mehetJobbra = false;
                            }
                            mehetBalra = true;
                        }
                    }
                    mehetBalraAlap = false;

                }
            if (mehetJobbraAlap)
                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.getAccelerometerY() > 3) {
                    //if(mostani<3&&!mehetBalra)
                    if(!worldRotation) {
                        //System.out.println("Mostkénejobbra");
                        if (!(isLastElementOfArray(destinations, (int) getX()))) {
                           // System.out.println("Mostmegyjobbra");
                            setX(getX() + 1);
                            if (mehetBalra) {
                                mehetBalra = false;
                            }
                            mehetJobbra = true;
                        }
                    } else {
                        if (!(isLastElementOfArray(destinations, (int) getY()))) {
                            setY(getY() - 1);
                            if (mehetBalra) {
                                mehetBalra = false;
                            }
                            mehetJobbra = true;
                        }
                    }
                    mehetJobbraAlap = false;
                }

            if (mehetBalra) {
                if (getRotation() < rotationBase+90) rotateBy(1);
                if(!worldRotation) {
                    if (!(contains(destinations, (int) getX()))) {
                        setX(getX() - 1);
                        mehetBalraAlap = false;
                        mehetJobbraAlap = true;
                    } else {
                        setRotation(rotationBase);
                        mehetBalraAlap = true;
                        mehetJobbraAlap = true;
                    }
                } else {
                    if (!(contains(destinations, (int) getY()))) {
                        setY(getY() + 1);
                        mehetBalraAlap = false;
                        mehetJobbraAlap = true;
                    } else {
                        setRotation(rotationBase);
                        mehetBalraAlap = true;
                        mehetJobbraAlap = true;
                    }
                }
            }
            if (mehetJobbra) {
                if (getRotation() > rotationBase - 90) rotateBy(-1);
                if (!worldRotation) {
                    if (!(contains(destinations, (int) getX()))) {
                        setX(getX() + 1);
                        mehetJobbraAlap = false;
                        mehetBalraAlap = true;
                    } else {
                        setRotation(rotationBase);
                        mehetJobbraAlap = true;
                        mehetBalraAlap = true;
                    }
                } else {
                    if (!(contains(destinations, (int) getY()))) {
                        setY(getY() - 1);
                        mehetJobbraAlap = false;
                        mehetBalraAlap = true;
                    } else {
                        setRotation(rotationBase);
                        mehetJobbraAlap = true;
                        mehetBalraAlap = true;
                    }
                }
            }
        }
    }
}
