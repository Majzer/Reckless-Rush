package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MultiSpriteActor;
import com.mygdx.game.MyBaseClasses.Scene2D.OffsetSprite;

import java.util.Random;

/**
 * Created by tanulo on 2018. 01. 15..
 */
public class TruckActor extends Vehicle {

    GameStage gameStage;

    public TruckActor(float y, boolean szembe, GameStage gameStage) {
        super(523,1003);
        rand = new Random();
        this.szembe = szembe;
        this.magas = y;
        this.gameStage = gameStage;
        destinations = new int[]{gameStage.getViewport().getScreenX()+200,gameStage.getViewport().getScreenX()+300,gameStage.getViewport().getScreenX()+600,gameStage.getViewport().getScreenX()+800};
        if (szembe)setPosition(destinations[rand.nextInt(2)],y);
        else setPosition(destinations[rand.nextInt(2)+2],y);
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_B_SEGG_EP),0,0),"BAL_SEGG");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_B_HATSO_EP),0,46),"BAl_HATSO");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_B_OLDAL_EP),0,435),"BAL_OLDAL");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_B_ELSO_EP),0,727),"BAL_ELSO");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_B_ORR_EP),0,966),"BAL_ORR");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_J_SEGG_EP),262,0),"JOBB_SEGG");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_J_HATSO_EP),262,46),"JOBB_HATSO");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_J_OLDAL_EP),262,435),"JOBB_OLDAL");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_J_ELSO_EP),262,727),"JOBB_ELSO");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_J_ORR_EP),262,966),"JOBB_ORR");

        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.KAMION_B_SEGG_EP),
                        Assets.manager.get(Assets.KAMION_B_SEGG_TOROTT)
                }
                ,0, 0), "BAL_SEGG");
        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.KAMION_B_HATSO_EP),
                        Assets.manager.get(Assets.KAMION_B_HATSO_TOROTT)
                }
                ,0,46),"BAl_HATSO");
        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.KAMION_B_OLDAL_EP),
                        Assets.manager.get(Assets.KAMION_B_OLDAL_TOROTT)
                }
                ,0,435),"BAL_OLDAL");
        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.KAMION_B_ELSO_EP),
                        Assets.manager.get(Assets.KAMION_B_ELSO_TOROTT)
                }
                ,0,727),"BAL_ELSO");
        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.KAMION_B_ORR_EP),
                        Assets.manager.get(Assets.KAMION_B_ORR_TOROTT)
                }
                ,0,966),"BAL_ORR");




        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.KAMION_J_SEGG_EP),
                        Assets.manager.get(Assets.KAMION_J_SEGG_TOROTT)
                }
                ,262,0),"JOBB_SEGG");
        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.KAMION_J_HATSO_EP),
                        Assets.manager.get(Assets.KAMION_J_HATSO_TOROTT)
                }
                ,262,46),"JOBB_HATSO");
        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.KAMION_J_OLDAL_EP),
                        Assets.manager.get(Assets.KAMION_J_OLDAL_TOROTT)
                }
                ,262,435),"JOBB_OLDAL");
        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.KAMION_J_ELSO_EP),
                        Assets.manager.get(Assets.KAMION_J_ELSO_TOROTT)
                }
                ,262,727),"JOBB_ELSO");
        addSprite(new ChangingOffsetSprite(
                new Texture[]{
                        Assets.manager.get(Assets.KAMION_J_ORR_EP),
                        Assets.manager.get(Assets.KAMION_J_ORR_TOROTT)
                }
                ,262,966),"JOBB_ORR");
        addBaseCollisionRectangleShapeForAllSprites();
        setSize(getWidth()/4,getHeight()/4);
        setOrigintoCenter();
        if(szembe) setRotation(180);
    }

    @Override
    public void init() {

    }

}
