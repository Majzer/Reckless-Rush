package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyBaseClasses.Game.Scene2D.OneSpriteStaticActor;

/**
 * Created by tanulo on 2018. 01. 11..
 */

public class BackgroundActor extends OneSpriteStaticActor {

    public BackgroundActor(Texture texture, float x, float y) {
        super(texture);
        setPosition(x,y);
    }
}
