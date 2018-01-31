package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

import java.util.Random;

/**
 * Created by tanulo on 2018. 01. 29..
 */

public class HouseActor extends OneSpriteStaticActor {

    public HouseActor(float x, float y, boolean flipped) {
        super(Assets.manager.get(Assets.HOUSE_TEXTURE));
        setPosition(x, y);
        setSize(getWidth()/3.4f,getHeight()/3.4f);
        if(flipped){
            setRotation(180);
        }

        Random rand = new Random();
        if (!rand.nextBoolean()){
            setTexture(Assets.manager.get(Assets.HOUSE2_TEXTURE));
        }
    }



}
