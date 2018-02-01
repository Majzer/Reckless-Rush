package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

import java.util.Random;

import sun.java2d.pipe.AAShapePipe;

/**
 * Created by tanulo on 2018. 01. 31..
 */

public class KatyuActor extends OneSpriteStaticActor {

    int text=0;

    public KatyuActor(int x, int y, boolean rotation) {
        super(Assets.manager.get(Assets.KATYU1_TEXTURE));
        setPosition(x ,y);
        Random rand = new Random();
        float fok = rand.nextInt(45);
        this.text = rand.nextInt(150);

        if(rotation){
            setRotation(fok);
        }


    }

    @Override
    public void act(float delta) {
        super.act(delta);
        System.out.println(text);
        if(text > 50 && text < 100){
            setTexture(Assets.manager.get(Assets.KATYU2_TEXTURE));
        }else if (text > 100){
            setTexture(Assets.manager.get(Assets.KATYU3_TEXTURE));
        } else setTexture(Assets.manager.get(Assets.KATYU1_TEXTURE));

    }
}
