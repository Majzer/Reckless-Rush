package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by tanulo on 2018. 01. 29..
 */

public class HouseActor extends OneSpriteStaticActor {

    public HouseActor(Texture texture, float x, float y, boolean flipped) {
        super(texture);
        setPosition(x, y);
        setSize(getWidth()/3.4f,getHeight()/3.4f);
        if(flipped){
            setRotation(180);
        }
    }


}
