package com.mygdx.game;

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

    public CarActor() {
        super();
        setSize(566,1068);
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_SEGG_EP),0,0,8),"BAL_SEGG_");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_HATSO_EP),0,55,10),"BAL_HATSO_");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_OLDAL_EP),0,361,2),"BAL_OLDAL");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_ELSO_EP),0,745,3),"BAL_ELSO");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_ORR_EP),0,1013,9),"BAL_ORR");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_ELSO_EP),283,745,6),"JOBB_ELSO");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_ORR_EP),283,1013,4),"JOBB_ORR");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_OLDAL_EP),283,361,5),"JOBB_OLDAL");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_SEGG_EP),283,0,1),"JOBB_SEGG");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_HATSO_EP),283,55,7),"JOBB_HATSO");
        //setSize(getWidth()/5,getHeight()/5);
        //removeSprite("JOBB_OLDAL_EP");
        //addSprite(new OffsetSprite(Assets.manager.get(Assets.J_OLDAL_EP),283,361,5),"JOBB_OLDAL_");
        changeSprite("BAL_SEGG_",new OffsetSprite(Assets.manager.get(Assets.B_SEGG_TOROTT),0,0,8));
        changeSprite("BAL_HATSO_",new OffsetSprite(Assets.manager.get(Assets.B_HATSO_TOROTT),0,55,10));
        changeSprite("BAL_OLDAL",new OffsetSprite(Assets.manager.get(Assets.B_OLDAL_TOROTT),0,361,2));
        changeSprite("BAL_ELSO",new OffsetSprite(Assets.manager.get(Assets.B_ELSO_TOROTT),0,745,3));
        changeSprite("BAL_ORR",new OffsetSprite(Assets.manager.get(Assets.B_ORR_TOROTT),0,1013,9));
        changeSprite("JOBB_ELSO",new OffsetSprite(Assets.manager.get(Assets.J_ELSO_TOROTT),283,745,6));
        changeSprite("JOBB_ORR",new OffsetSprite(Assets.manager.get(Assets.J_ORR_TOROTT),283,1013,4));
        changeSprite("JOBB_OLDAL",new OffsetSprite(Assets.manager.get(Assets.J_OLDAL_TOROTT),283,361,5));
        changeSprite("JOBB_SEGG",new OffsetSprite(Assets.manager.get(Assets.J_SEGG_TOROTT),283,0,1));
        changeSprite("JOBB_HATSO",new OffsetSprite(Assets.manager.get(Assets.J_HATSO_TOROTT),283,55,7));
    }

    @Override
    public void init() {

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        rotateBy(delta*5);
    }
}
