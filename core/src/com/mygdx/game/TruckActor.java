package com.mygdx.game;

import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MultiSpriteActor;
import com.mygdx.game.MyBaseClasses.Scene2D.OffsetSprite;

import java.util.Random;

/**
 * Created by tanulo on 2018. 01. 15..
 */
public class TruckActor extends Vehicle {



    public TruckActor(float y, boolean szembe) {
        super(523,1003);
        rand = new Random();
        this.szembe = szembe;
        this.magas = y;
        destinations = new int[]{171-57,377-57,642-57,850-57};
        if (szembe)setPosition(destinations[rand.nextInt(2)],y);
        else setPosition(destinations[rand.nextInt(2)+2],y);
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_B_SEGG_EP),0,0),"BAL_SEGG");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_B_HATSO_EP),0,46),"BAl HÁTSÓ");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_B_OLDAL_EP),0,435),"BAL OLDAL");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_B_ELSO_EP),0,727),"BAL ELSO");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_B_ORR_EP),0,966),"BAL ORR");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_J_SEGG_EP),262,0),"JOBB SEGG");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_J_HATSO_EP),262,46),"JOBB HATSO");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_J_OLDAL_EP),262,435),"JOBB OLDAL");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_J_ELSO_EP),262,727),"JOBB ELSO");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KAMION_J_ORR_EP),262,966),"JOBB ORR");
        addBaseCollisionRectangleShapeForAllSprites();
        setSize(getWidth()/4,getHeight()/4);
        setOrigintoCenter();
        if(szembe) setRotation(180);
    }

    @Override
    public void init() {

    }

}
