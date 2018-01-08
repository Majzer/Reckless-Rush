package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyBaseClasses.Game.Scene2D.MyStage;

/**
 * Created by tanulo on 2018. 01. 08..
 */

public class GameStage extends MyStage {

    public GameStage(final Batch batch, RecklessRush game) {
        super(new ExtendViewport(10.24f,7.68f), batch, game);



        fitWorldToWidth();
    }

    @Override
    public void init() {

    }

    @Override
    protected void resized() {
        super.resized();
        fitWorldToWidth();
    }
}
