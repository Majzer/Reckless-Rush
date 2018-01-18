package com.mygdx.game;

import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MultiSpriteActor;
import com.mygdx.game.MyBaseClasses.Scene2D.OffsetSprite;

import java.util.Random;

/**
 * Created by tanulo on 2018. 01. 15..
 */
public class BlueCarActor extends Vehicle {


    public BlueCarActor(float y, boolean szembe) {
        super(450,926);
        rand = new Random();
        this.magas=y;
        this.szembe=szembe;
        destinations = new int[]{171-57,377-57,642-57,850-57};
        if (szembe)setPosition(destinations[rand.nextInt(2)],y);
        else setPosition(destinations[rand.nextInt(2)+2],y);
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KEK_B_SEGG_EP),0,0),"BAL_SEGG_");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KEK_B_HATSO_EP),0,53),"BAL_HATSO_");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KEK_B_OLDAL_EP),0,278),"BAL_OLDAL");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KEK_B_ELSO_EP),0,572),"BAL_ELSO");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KEK_B_ORR_EP),0,855),"BAL_ORR");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KEK_J_ELSO_EP),225,572),"JOBB_ELSO");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KEK_J_ORR_EP),225,855),"JOBB_ORR");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KEK_J_OLDAL_EP),225,278),"JOBB_OLDAL");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KEK_J_SEGG_EP),225,0),"JOBB_SEGG");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.KEK_J_HATSO_EP),225,53),"JOBB_HATSO");
        setSize(getWidth()/5.5f,getHeight()/5.5f);
        if(szembe) setRotation(180);
    }
}
