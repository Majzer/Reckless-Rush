package com.mygdx.game;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Game.PedActor;
import com.mygdx.game.MyBaseClasses.Game.Scene2D.MyStage;
import com.mygdx.game.MyBaseClasses.Game.Scene2D.OneSpriteStaticActor;

import java.time.Year;
import java.util.Random;

/**
 * Created by tanulo on 2018. 01. 08..
 */

public class GameStage extends MyStage {
    protected int i =0;
    BackgroundActor bg2;
    CarActor car;
    PedActor pedActor;
    BokorActor ba1 , ba2 , ba3;
    BackgroundActor bg, bg3;
    boolean egyes=false,kettes=false;
    int db1=0, db2=0, db3;


    public GameStage(final Batch batch, RecklessRush game) {
        super(new ExtendViewport(1024,768), batch, game);
        addActor(bg =new BackgroundActor(Assets.manager.get(Assets.HATTER_TEXTURE),0,1));
        addActor(bg2 =new BackgroundActor(Assets.manager.get(Assets.HATTER_TEXTURE),0,715));
        addActor(ba1 = new BokorActor(Assets.manager.get(Assets.BOKOR_EP_TEXTURE), 470,0));
        addActor(ba2 = new BokorActor(Assets.manager.get(Assets.BOKOR_EP_TEXTURE), 470, ba1.getY()*2));
        addActor(ba3 = new BokorActor(Assets.manager.get(Assets.BOKOR_EP_TEXTURE), 470,ba1.getY()*4));
        //addActor(bg3 =new BackgroundActor(Assets.manager.get(Assets.HATTER_TEXTURE),0,1430));
        addActor(car=new CarActor(this));
        addActor(pedActor = new PedActor(this));

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("x = " + x);
                System.out.println("y = " + y);
            }
        });



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

    @Override
    public void act(float delta) {
        super.act(delta);
        if(car!=null){
            car.setY(car.getY()+10);
            setCameraMoveToY(car.getY());
        }

        // TODO: 2018. 01. 11. mind3 bokor szépen jelenjen meg és tünjön el 
        if(!(bg.isInFrustum())){
            bg2.setY(bg.getY()+573);
            ba1.setY(bg.getY()+573);
        }

        if(!(bg2.isInFrustum())) {
            bg.setY(bg2.getY() + 573);
            ba1.setY(bg2.getY()+573);
        }
    }
}
