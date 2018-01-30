package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by tanulo on 2018. 01. 11..
 */

public class BokorActor extends OneSpriteStaticActor {
    public BokorActor(Texture texture, float x, float y, boolean flipped) {
        super(texture);
        setPosition(x,y);
        if(texture == Assets.manager.get(Assets.BUSH_LINE_TEXTURE)){
            setHeight(getHeight()*1.3f);
        }else if (texture == Assets.manager.get(Assets.FORTRESS_LINE_TEXTURE)){
            setHeight(getHeight()/2);
        }


        if(flipped){
            setRotation(180);
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
