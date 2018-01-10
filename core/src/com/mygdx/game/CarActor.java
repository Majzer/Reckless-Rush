package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Game.Scene2D.MultiSpriteActor;
import com.mygdx.game.MyBaseClasses.Game.Scene2D.OffsetSprite;

import java.util.Vector;

/**
 * Created by tanulo on 2018. 01. 08..
 */



public class CarActor extends MultiSpriteActor {

    public CarActor(GameStage gameStage) {
        super();
        setSize(114,214);
        float x = getWidth()/2, y=getHeight()/2;
        setPosition(300,gameStage.getHeight()/2);
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_SEGG_EP),0,0,8),"BAL_SEGG_");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_HATSO_EP),0,11,10),"BAL_HATSO_");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_OLDAL_EP),0,72,2),"BAL_OLDAL");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_ELSO_EP),0,149,3),"BAL_ELSO");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_ORR_EP),0,203,9),"BAL_ORR");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_ELSO_EP),57,149,6),"JOBB_ELSO");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_ORR_EP),57,203,4),"JOBB_ORR");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_OLDAL_EP),57,72,5),"JOBB_OLDAL");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_SEGG_EP),57,0,1),"JOBB_SEGG");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_HATSO_EP),57,11,7),"JOBB_HATSO");
        setOrigin(x,y);
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

        changeSprite("BAL_SEGG_",new OffsetSprite(Assets.manager.get(Assets.B_SEGG_TOROTT),0,0,8));
        changeSprite("BAL_HATSO_",new OffsetSprite(Assets.manager.get(Assets.B_HATSO_TOROTT),0,11,10));
        changeSprite("BAL_OLDAL",new OffsetSprite(Assets.manager.get(Assets.B_OLDAL_TOROTT),0,72,2));
        changeSprite("BAL_ELSO",new OffsetSprite(Assets.manager.get(Assets.B_ELSO_TOROTT),0,149,3));
        changeSprite("BAL_ORR",new OffsetSprite(Assets.manager.get(Assets.B_ORR_TOROTT),0,203,9));
        changeSprite("JOBB_ELSO",new OffsetSprite(Assets.manager.get(Assets.J_ELSO_TOROTT),57,149,6));
        changeSprite("JOBB_ORR",new OffsetSprite(Assets.manager.get(Assets.J_ORR_TOROTT),57,203,4));
        changeSprite("JOBB_OLDAL",new OffsetSprite(Assets.manager.get(Assets.J_OLDAL_TOROTT),57,72,5));
        changeSprite("JOBB_SEGG",new OffsetSprite(Assets.manager.get(Assets.J_SEGG_TOROTT),57,0,1));
        changeSprite("JOBB_HATSO",new OffsetSprite(Assets.manager.get(Assets.J_HATSO_TOROTT),57,11,7));
        super.originChanged();

    }

    @Override
    public void init() {

    }

    int[] destinations = new int[]{100,200,300,400,500};
    int mostani=2;
    boolean mehetBalra=false;
    boolean mehetJobbra=false;



    @Override
    public void act(float delta) {
        super.act(delta);
        setRotation(0);
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            if(mostani>0&&!mehetJobbra)
            mehetBalra=true;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            if(mostani<4&&!mehetBalra)
           mehetJobbra=true;
        }if(mehetBalra){
            if(getRotation()<10) rotateBy(1);
            if(getX()>destinations[mostani-1]){
                setX(getX()-5);
            }
            else {
                mehetBalra=false;
                mostani--;
            }
        }
        if(mehetJobbra){
            if(getRotation()>-10) rotateBy(-1);
            if(getX()<destinations[mostani+1]){
                setX(getX()+5);
            }
            else {
                mehetJobbra=false;
                mostani++;
            }
        }

    }
}
