package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.PedActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;

/**
 * Created by tanulo on 2018. 01. 08..
 */

public class GameStage extends MyStage {
    protected int i =0;
    BgActor bg2;
    CarActor car;
    PedActor pedActor;
    BokorActor ba1 , ba2 , ba3;
    BgActor bg, bg3;
    boolean egyes=false,kettes=false;
    int db1=0, db2=0, db3;
    TruckActor truckActor;
    BlueCarActor blueCarActor;

    public GameStage(final Batch batch, RecklessRush game) {
        super(new ExtendViewport(1024,768), batch, game);
        addActor(bg =new BgActor(Assets.manager.get(Assets.HATTER_TEXTURE),0,1));
        addActor(bg2 =new BgActor(Assets.manager.get(Assets.HATTER_TEXTURE),0,715));
        addActor(ba1 = new BokorActor(Assets.manager.get(Assets.BOKOR_EP_TEXTURE), 470,bg.getY()));
        addActor(ba2 = new BokorActor(Assets.manager.get(Assets.BOKOR_EP_TEXTURE), 470, bg.getY()+250));
        addActor(ba3 = new BokorActor(Assets.manager.get(Assets.BOKOR_EP_TEXTURE), 470,bg.getY()+500));
        //addActor(bg3 =new BgActor(Assets.manager.get(Assets.HATTER_TEXTURE),0,1430));
        addActor(car=new CarActor(this));
        car.setSpeed(8);
        addActor(blueCarActor=new BlueCarActor(1000));
        blueCarActor.setSpeed(6.5f);
        addActor(pedActor=new PedActor(this));car.setZIndex(10);
        pedActor.setZIndex(10);
        addActor(truckActor = new TruckActor(500));
        truckActor.setSpeed(5);
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
            car.setY(car.getY()+car.getSpeed());
            setCameraMoveToY(car.getY()+210);
        }

        if(truckActor!=null){
            truckActor.setY(truckActor.getY()+truckActor.getSpeed());
        }

        if(blueCarActor!=null){
            blueCarActor.setY(blueCarActor.getY()+blueCarActor.getSpeed());
        }

        if(!(bg.isInFrustum())){
            bg2.setY(bg.getY()+500);
            bg2.setZIndex(0);
        }

        if(!(bg2.isInFrustum())) {
            bg.setY(bg2.getY() + 500);
            bg.setZIndex(0);
        }

        if(!(ba1.isInFrustum(1.3f))){
            ba1.setY(ba1.getY()+bg.getHeight()+60);
        }

        if(!(ba2.isInFrustum(1.3f))){
            ba2.setY(ba2.getY()+bg.getHeight()+60);
        }
        if(!(ba3.isInFrustum(1.3f))){
            ba3.setY(ba3.getY()+bg.getHeight()+60);
        }

        if(!(truckActor.isInFrustum(1.3f))){

        }
    }
}
