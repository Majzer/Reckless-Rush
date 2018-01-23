package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class ExplosionActor extends OneSpriteAnimatedActor {
    public ExplosionActor() {
        //super("explosion.atlas");
        super(Assets.manager.get(Assets.EXPLOSION_TEXTURE));
        setFps(20);
    }

    public ExplosionActor(float x, float y) {
        //super("explosion.atlas");
        super(Assets.manager.get(Assets.EXPLOSION_TEXTURE));
        setPosition(x,y);
        setSize(getWidth()*3, getHeight()*3);
        setFps(20);
    }

    boolean vege=false;

    @Override
    protected void repeated() {
        if (getStage()!=null) {
            getStage().getActors().removeValue(this, true);
            vege=true;
        }
        super.repeated();
    }
}
