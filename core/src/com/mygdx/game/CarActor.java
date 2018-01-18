package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MultiSpriteActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyRectangle;
import com.mygdx.game.MyBaseClasses.Scene2D.OffsetSprite;

/**
 * Created by tanulo on 2018. 01. 08..
 */



public class CarActor extends Vehicle {

    GameStage gameStage;
    float speed=10;

    public CarActor(GameStage gameStage) {
        super(566,1068);
        setOrigintoCenter();
        addCollisionShape("Frustum", new MyRectangle(1024,22048,-256,-256,getOriginX(), getOriginY()));

        this.gameStage=gameStage;
        setPosition(destinations[2],gameStage.getViewport().getScreenHeight()/3);
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_SEGG_EP),0,0),"BAL_SEGG");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_HATSO_EP),0,55),"BAL_HATSO");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_OLDAL_EP),0,361),"BAL_OLDAL");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_ELSO_EP),0,745),"BAL_ELSO");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_ORR_EP),0,1013),"BAL_ORR");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_ELSO_EP),283,745),"JOBB_ELSO");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_ORR_EP),283,1013),"JOBB_ORR");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_OLDAL_EP),283,361),"JOBB_OLDAL");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_SEGG_EP),283,0),"JOBB_SEGG");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_HATSO_EP),283,55),"JOBB_HATSO");
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
        super.originChanged();
        addBaseCollisionRectangleShapeForAllSprites();
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public void init() {

    }

    int[] destinations = new int[]{171-57,377-57,642-57,850-57};
    int mostani=2;
    boolean mehetBalra=false;
    boolean mehetJobbra=false;



    @Override
    public void act(float delta) {
        super.act(delta);
        setRotation(0);
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            //if(mostani>0&&!mehetJobbra)
            if(mehetJobbra){
                mehetJobbra=false;
                mostani--;
            }

            mehetBalra=true;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            //if(mostani<3&&!mehetBalra)
            if(mehetBalra) {
                mehetBalra = false;
                mostani++;
            }
           mehetJobbra=true;
        }
        if(mehetBalra){
            if(getRotation()<20) rotateBy(1);

                if (getX() > destinations[mostani - 1]) {
                    System.out.println(getX());
                    for (int aaa = 0; aaa < 5; aaa++) {
                        setX(getX() - 1);
                        if (getX() == destinations[mostani - 1]) {
                            break;
                        }
                    }
                } else {
                    mehetBalra = false;
                    mostani--;
                }

        }
        if(mehetJobbra) {
            if (getRotation() > -20) rotateBy(-1);

                if (getX() < destinations[mostani + 1]) {
                    System.out.println(getX());
                    for (int aaa = 0; aaa < 5; aaa++) {
                        setX(getX() + 1);
                        if (getX() == destinations[mostani + 1]) {
                            break;
                        }
                    }
                } else {
                    mehetJobbra = false;
                    mostani++;
                }
            }


    }
}
