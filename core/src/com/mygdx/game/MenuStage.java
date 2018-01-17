package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by tanulo on 2018. 01. 15..
 */

public class MenuStage extends MyStage {

    TextButton btnStart, btnExit;
    OneSpriteStaticActor bg;

    public MenuStage(Viewport viewport, Batch batch, RecklessRush game) {
        super(viewport, batch, game);
        addActor(bg = new OneSpriteStaticActor(Assets.manager.get(Assets.MENU_HATTER_TEXTURE)));
        bg.setZIndex(0);
        setDebugAll(true);
    }


    @Override
    public void act(float delta) {
        super.act(delta);

            btnStart.setRotation(90);

    }

    @Override
    public void init() {
        btnStart = new MyButton("", game.btnStart());
        btnStart.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MainScreen(game));
            }
        });
        addActor(btnStart);
        btnStart.setZIndex(2);
        btnStart.setPosition((getViewport().getScreenWidth()/2)-(btnStart.getWidth()/2),(getViewport().getScreenHeight()/2)-150);


        btnExit = new MyButton("", game.btnExit());
        btnExit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.exit();
            }
        });
        addActor(btnExit);
        btnExit.setZIndex(2);
        btnExit.setPosition((getViewport().getScreenWidth()/2)-(btnExit.getWidth()/2), btnStart.getY()-170);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
