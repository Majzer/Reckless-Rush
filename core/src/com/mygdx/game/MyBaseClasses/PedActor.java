package com.mygdx.game.MyBaseClasses;

import com.mygdx.game.GameStage;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

/**
 * Created by tanulo on 2018. 01. 10..
 */

public class PedActor extends OneSpriteAnimatedActor {

    GameStage gameStage;
    float speed;
    boolean szembe;

    public PedActor(GameStage gameStage, float speed, boolean szembe, float y) {
        super(Assets.manager.get(Assets.WALK_TEXTURE));
        this.speed = speed;
        this.szembe = szembe;
        setFps(11);
        this.gameStage = gameStage;
        this.setY(y);
        this.setSize(getWidth()/1.5f,getHeight()/1.5f);
        if(szembe){
            setX(10);
            setRotation(180);
        }
        else setX(gameStage.getViewport().getWorldWidth()-10);
    }

    @Override
    public void act(float delta) {
        if(!szembe)
        setY(getY() + speed);
        else setY(getY()+speed);
        super.act(delta);
    }
}
