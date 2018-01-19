package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteActor;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by tanulo on 2018. 01. 19..
 */

public class ChangingSpriteActor extends OneSpriteStaticActor {
    private final Texture[] textures;
    private int textureIndex = 0;
    public ChangingSpriteActor(Texture[] textures) {
        super(textures[0]);
        this.textures = textures;
    }

    public void change(){
        textureIndex++;
        textureIndex %= textures.length;
        this.setTexture(textures[textureIndex]);
    }
}
