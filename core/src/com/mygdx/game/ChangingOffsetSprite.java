package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyBaseClasses.Scene2D.OffsetSprite;

/**
 * Created by tanulo on 2018. 01. 23..
 */

public class ChangingOffsetSprite extends OffsetSprite {

    private final Texture[] textures;
    private boolean isChanged = false;
    private int textureIndex = 0;

    public ChangingOffsetSprite(Texture[] textures, float xOffset, float yOffset) {
        super(textures[0], xOffset, yOffset);
        this.textures = textures;
    }

    public void setBack(){
        textureIndex = 0;
        isChanged = false;
        setTexture(textures[0]);
    }

    public void changeOnce(){
        if(!isChanged)
            changeEveryTime();
    }

    public void changeEveryTime(){
        isChanged=true;
        textureIndex++;
        textureIndex %= textures.length;
        setTexture(textures[textureIndex]);
    }
}
