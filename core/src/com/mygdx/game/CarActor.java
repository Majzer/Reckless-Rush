package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Game.Scene2D.MultiSpriteActor;
import com.mygdx.game.MyBaseClasses.Game.Scene2D.OffsetSprite;

/**
 * Created by tanulo on 2018. 01. 08..
 */



public class CarActor extends MultiSpriteActor {

    public CarActor() {
        super();
        setSize(566,1068);
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_ELSO_EP),0,745),"BAL_ELSO_EP");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_ORR_EP),0,1013),"BAL_ORR_EP");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_OLDAL_EP),0,361),"BAL_OLDAL_EP");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_SEGG_EP),0,0),"BAL_SEGG_EP");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.B_HATSO_EP),0,55),"BAL_HATSO_EP");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_ELSO_EP),283,745),"JOBB_ELSO_EP");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_ORR_EP),283,1013),"JOBB_ORR_EP");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_OLDAL_EP),283,361),"JOBB_OLDAL_EP");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_SEGG_EP),283,0),"JOBB_SEGG_EP");
        addSprite(new OffsetSprite(Assets.manager.get(Assets.J_HATSO_EP),283,55),"JOBB_HATSO_EP");
        setSize(getWidth()/3,getHeight()/3);
    }

    @Override
    public void init() {

    }
}
