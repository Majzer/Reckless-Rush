package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by tanulo on 2018. 01. 15..
 */

public class MenuStage extends MyStage {

    //TextButton btnStart, btnExit;
    OneSpriteStaticActor bg, btnStart , btnExit;
    ChangingSpriteActor logo;
    boolean plusz=false;

    public MenuStage(Viewport viewport, Batch batch, RecklessRush game) {
        super(viewport, batch, game);
        addActor(bg = new OneSpriteStaticActor(Assets.manager.get(Assets.MENU_HATTER_TEXTURE)));
        bg.setPosition(0,0);
        //bg.stretchToViewportRealWorldSizeWithoutBlackBars();
        bg.setZIndex(0);
        setDebugAll(true);
    }

    private float passedMilisec = 0;
    @Override
    public void act(float delta) {
        super.act(delta);
        passedMilisec += delta;



            if (!plusz) {
                btnStart.rotateBy(-0.05f);
                //btnStart.setPosition(btnStart.getX()+0.19f , btnStart.getY()+0.19f);
                btnExit.rotateBy(-0.05f);
                if (btnStart.getRotation() < -6) {
                    plusz = true;
                }
            } else if (plusz) {
                btnStart.rotateBy(0.05f);
                //btnStart.setPosition(btnStart.getX()-0.19f , btnStart.getY()-0.19f);
                btnExit.rotateBy(0.05f);
                if (btnStart.getRotation() > 6) {
                    plusz = false;
                }
            }
            if (passedFrames > 600){
               logo.change();
               passedFrames = 0;
            }
        }


    @Override
    public void init() {
        btnStart = new ButtonActor(Assets.manager.get(Assets.BTN_START_TEXTURE));
        btnStart.addListener(new ClickListener() {
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                super.enter(event, x, y, pointer, fromActor);
                btnStart.setTexture(Assets.manager.get(Assets.BTN_START_DOWN_TEXTURE));
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                super.exit(event, x, y, pointer, toActor);
                btnStart.setTexture(Assets.manager.get(Assets.BTN_START_TEXTURE));
            }
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //btnStart.setTexture(Assets.manager.get(Assets.BTN_START_DOWN_TEXTURE));
                super.clicked(event, x, y);
                game.setScreen(new MainScreen(game));
            }
        });
        addActor(btnStart);
        btnStart.setZIndex(2);
        btnStart.setPosition((getViewport().getScreenWidth()/2)-(btnStart.getWidth()/2),(getViewport().getScreenHeight()/2)-150);


        btnExit = new ButtonActor(Assets.manager.get(Assets.BTN_EXIT_TEXTURE));
        btnExit.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                super.enter(event, x, y, pointer, fromActor);
                btnExit.setTexture(Assets.manager.get(Assets.BTN_EXIT_DOWN_TEXTURE));
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                super.exit(event, x, y, pointer, toActor);
                btnExit.setTexture(Assets.manager.get(Assets.BTN_EXIT_TEXTURE));
            }

            @Override
            public void clicked(InputEvent event, float x, float y) {
                //btnExit.setTexture(Assets.manager.get(Assets.BTN_EXIT_DOWN_TEXTURE));
                super.clicked(event, x, y);
                Gdx.app.exit();
            }
        });
        addActor(btnExit);
        btnExit.setZIndex(2);
        btnExit.setPosition((getViewport().getScreenWidth()/2)-(btnExit.getWidth()/2), btnStart.getY()-170);

        logo = new ChangingSpriteActor(new Texture[]{
                Assets.manager.get(Assets.LOGO1_TEXTURE),
                Assets.manager.get(Assets.LOGO2_TEXTURE),
                Assets.manager.get(Assets.LOGO3_TEXTURE),
        });
        addActor(logo);
        logo.setZIndex(0);
        logo.setY(170);

    }

    @Override
    public void dispose() {
        super.dispose();
    }

}
