package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MyScreen;

/**
 * Created by tanulo on 2018. 01. 15..
 */

public class MenuScreen extends MyScreen {

    protected MenuStage menuStage;

    public MenuScreen(RecklessRush game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        menuStage.act(delta);
        menuStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        menuStage.resize(width,height);
    }

    @Override
    public void dispose() {
        menuStage.dispose();
        super.dispose();
    }

    @Override
    public void init() {
        menuStage = new MenuStage(new ExtendViewport(game.WORLD_WIDTH,game.WORLD_HEIGHT,new OrthographicCamera(game.WORLD_WIDTH,game.WORLD_HEIGHT)), spriteBatch, game);
        Gdx.input.setInputProcessor(menuStage);
        //rgb(0, 184, 230)
        //rgb(66, 98, 244)
        setBackGroundColor(0f, 0.31f, 1);

    }
}
