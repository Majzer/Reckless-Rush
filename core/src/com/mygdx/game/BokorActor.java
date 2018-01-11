package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyBaseClasses.Game.Scene2D.OneSpriteStaticActor;

/**
 * Created by tanulo on 2018. 01. 11..
 */

public class BokorActor extends OneSpriteStaticActor {
    public BokorActor(Texture texture, float x, float y) {
        super(texture);
        setPosition(x,y);
        setSize(171/2,228/2);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
