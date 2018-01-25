package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.audio.Music;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MyScreen;

/**
 * Created by tanulo on 2018. 01. 08..
 */

public class MainScreen extends MyScreen {

    GameStage gameStage;

    Music music = Assets.manager.get(Assets.Miami_Soul);

    public MainScreen(RecklessRush game) {
        super(game);
        setBackGroundColor(0,0,0);
        gameStage = new GameStage(spriteBatch, game);
        InputMultiplexer im = new InputMultiplexer();
        im.addProcessor(gameStage);
        gameStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(im);
        music.setVolume(0.4f);
        music.setLooping(true);
        music.play();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        gameStage.act(delta);
        gameStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        gameStage.resize(width,height);
    }

    @Override
    public void init() {

    }
}
