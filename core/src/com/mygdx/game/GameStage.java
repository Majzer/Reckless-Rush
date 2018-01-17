package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.PedActor;
import com.mygdx.game.MyBaseClasses.RoadFrame;
import com.mygdx.game.MyBaseClasses.RoadFrameActor;
import com.mygdx.game.MyBaseClasses.Scene2D.City;
import com.mygdx.game.MyBaseClasses.Scene2D.MyActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;

import java.util.ArrayList;
import java.util.Random;

import sun.misc.Queue;

/**
 * Created by tanulo on 2018. 01. 08..
 */

public class GameStage extends MyStage {
    public enum WorldRotation{
        r0,
        r90,
        r180,
        r270
    }

    public WorldRotation worldRotation = WorldRotation.r0;

    protected int i =0;
    BgActor bg2;
    CarActor car;
    PedActor pedActor;
    BokorActor ba1 , ba2 , ba3;
    BgActor bg, bg3;
    boolean egyes=false,kettes=false;
    int db1=0, db2=0, db3;
    TruckActor truckActor, truckActor2;
    BlueCarActor blueCarActor, blueCarActor2;
    Random rand;

    Queue<RoadFrame> roadFrames;
    RoadFrameActor lastRoadFrameActor = null;

    public Queue<RoadFrame> generateMap(City a, City b){
        Queue<RoadFrame> roadFrames = new Queue<RoadFrame>();
        for (int i = 0; i<5; i++) {
            roadFrames.enqueue(new RoadFrame(RoadFrame.Utminoseg.joketsavos, RoadFrame.Tipus.csaladi));
        }
        RoadFrame roadFrame = new RoadFrame(RoadFrame.Utminoseg.joketsavos, RoadFrame.Tipus.bokros);
        roadFrame.telepulestabla = a.nev;
        roadFrame.telepulestablavege = true;
        roadFrames.enqueue(roadFrame);
        for (int i = 0; i<5; i++) {
            roadFrames.enqueue(new RoadFrame(RoadFrame.Utminoseg.joketsavos, RoadFrame.Tipus.bokros));
        }

        return roadFrames;
    }

    private void addRoadFromQueue(){
        try {
            RoadFrameActor newRoadFrameActor = new RoadFrameActor(roadFrames.dequeue());
            addActor(newRoadFrameActor);
            if (lastRoadFrameActor != null){
                newRoadFrameActor.setPosition(lastRoadFrameActor.getX(), lastRoadFrameActor.getY() + lastRoadFrameActor.getHeight());
            }
            lastRoadFrameActor = newRoadFrameActor;
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }

    public GameStage(final Batch batch, RecklessRush game) {
        super(new ExtendViewport(1024,768), batch, game);
        rand = new Random();

        City a = new City("Zalaegerszeg", City.Varostipus.megyeszekhely);
        City b = new City("Keszthely", City.Varostipus.kisvaros);
        roadFrames = generateMap(a,b);

        //addActor(bg =new BgActor(Assets.manager.get(Assets.HATTER_TEXTURE),0,100));
        //addActor(bg2 =new BgActor(Assets.manager.get(Assets.HATTER_TEXTURE),0,bg.getY()+bg.getHeight()/1.5f));

//        System.out.println(bg.getY());
//        System.out.println(bg.isInFrustum());
/*        addActor(ba1 = new BokorActor(Assets.manager.get(Assets.BOKOR_EP_TEXTURE), 470,bg.getY()));
        addActor(ba2 = new BokorActor(Assets.manager.get(Assets.BOKOR_EP_TEXTURE), 470, bg.getY()+250));
        addActor(ba3 = new BokorActor(Assets.manager.get(Assets.BOKOR_EP_TEXTURE), 470,bg.getY()+500));*/
        //addActor(bg3 =new BgActor(Assets.manager.get(Assets.HATTER_TEXTURE),0,1430));
        addActor(car=new CarActor(this));
        car.setSpeed(8);
        addActor(blueCarActor=new BlueCarActor(1000,rand.nextBoolean()));
        blueCarActor.setSpeed(6.5f);
        addActor(blueCarActor2=new BlueCarActor(1200, rand.nextBoolean()));
        blueCarActor2.setSpeed(6.5f);
        addActor(pedActor=new PedActor(this));
        car.setZIndex(10);
        pedActor.setZIndex(10);
        addActor(truckActor = new TruckActor(500,rand.nextBoolean()));
        addActor(truckActor2 = new TruckActor(900,rand.nextBoolean()));
        truckActor.setSpeed(5);
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("x = " + x);
                System.out.println("y = " + y);
            }
        });

        addRoadFromQueue();
        //fitWorldToWidth();
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
            setCameraMoveToY(car.getY()+getViewport().getScreenHeight()/2.5f);
        }


        //TODO: Ehelyett valami más megoldást! Listák? Tömbök?
        if(truckActor!=null){
            if(!(truckActor.isSzembe()))truckActor.setY(truckActor.getY()+truckActor.getSpeed());
            else truckActor.setY(truckActor.getY()-truckActor.getSpeed());
        }

        if(truckActor2!=null){
            if(!(truckActor2.isSzembe()))truckActor2.setY(truckActor2.getY()+truckActor2.getSpeed());
            else truckActor2.setY(truckActor2.getY()-truckActor2.getSpeed());
        }

        if(blueCarActor!=null){
            if(!(blueCarActor.isSzembe()))blueCarActor.setY(blueCarActor.getY()+blueCarActor.getSpeed());
            else blueCarActor.setY(blueCarActor.getY()-blueCarActor.getSpeed());
        }

        if(blueCarActor2!=null){
            if(!(blueCarActor2.isSzembe()))blueCarActor2.setY(blueCarActor2.getY()+blueCarActor2.getSpeed());
            else blueCarActor2.setY(blueCarActor2.getY()-blueCarActor2.getSpeed());
        }

        if(blueCarActor.getY()+getViewport().getScreenHeight()<car.getY()){
            blueCarActor.setY(car.getY()+getViewport().getScreenHeight());
            blueCarActor.setMagas(blueCarActor.getY());
            blueCarActor.setSzembe(rand.nextBoolean());
        }

        if(blueCarActor2.getY()+getViewport().getScreenHeight()<car.getY()){
            blueCarActor2.setY(car.getY()+getViewport().getScreenHeight());
            blueCarActor2.setMagas(blueCarActor2.getY());
            blueCarActor2.setSzembe(rand.nextBoolean());
        }

        if(truckActor.getY()+getViewport().getScreenHeight()<car.getY()){
            truckActor.setY(car.getY()+getViewport().getScreenHeight());
            truckActor.setMagas(truckActor.getY());
            truckActor.setSzembe(rand.nextBoolean());
        }

        if(truckActor2.getY()+getViewport().getScreenHeight()<car.getY()){
            truckActor2.setY(car.getY()+getViewport().getScreenHeight());
            truckActor2.setMagas(truckActor2.getY());
            truckActor2.setSzembe(rand.nextBoolean());
        }

        //TODO: Csak egy egyik út ugrál az autó mögött
/*
        if(!(bg.isInFrustum(2))){
            //System.out.println("1 kint");
            bg2.setY(bg.getY()+(bg.getHeight()));
            bg2.setZIndex(0);
        }

        if(!(bg2.isInFrustum(2))) {
            //System.out.println("2 kint");
            bg.setY(bg2.getY() + (bg.getHeight()));
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
*/
        if(!(truckActor.isInFrustum(1.3f))){

        }

        while (!roadFrames.isEmpty() && lastRoadFrameActor.isInFrustum(2)){
            addRoadFromQueue();
        }
        if (roadFrames.isEmpty()){
            //TODO: Új térképet generálni az alapértelmezett út fele
        }

        Array<Actor> actors = getActors();

        ArrayList<Actor> deleteActor = new ArrayList<>();
        for(Actor a : actors){
            if (a instanceof RoadFrameActor){
                if (!car.overlaps((MyActor)a)){
                    deleteActor.add(a);
                }
            }
        }
        for (Actor a: deleteActor) {
            actors.removeValue(a,true);
        }


    }
}
