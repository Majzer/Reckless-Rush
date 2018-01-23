package com.mygdx.game;

import com.badlogic.gdx.Gdx;
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
import com.mygdx.game.MyBaseClasses.Scene2D.OffsetSprite;

import java.util.ArrayList;
import java.util.Random;

import sun.misc.Queue;

/**
 * Created by tanulo on 2018. 01. 08..
 */

public class GameStage extends MyStage {
    public enum WorldRotation {
        r0,
        r90,
        r180,
        r270
    }

    public WorldRotation worldRotation = WorldRotation.r0;

    protected int i = 0;
    BgActor bg2;
    CarActor car;
    PedActor pedActor;
    BokorActor ba1, ba2, ba3;
    BgActor bg, bg3;
    boolean egyes = false, kettes = false;
    int db1 = 0, db2 = 0, db3;
    TruckActor truckActor, truckActor2;
    BlueCarActor blueCarActor, blueCarActor2;
    Random rand;
    ExplosionActor explosionActor;
    ArrayList<Vehicle> vehicles = null;
    CarActor car2;

    Queue<RoadFrame> roadFrames;
    RoadFrameActor lastRoadFrameActor = null;

    public Queue<RoadFrame> generateMap(City a, City b) {
        Queue<RoadFrame> roadFrames = new Queue<RoadFrame>();
        for (int i = 0; i < 5; i++) {
            roadFrames.enqueue(new RoadFrame(RoadFrame.Utminoseg.joketsavos, RoadFrame.Tipus.csaladi));
        }
        RoadFrame roadFrame = new RoadFrame(RoadFrame.Utminoseg.joketsavos, RoadFrame.Tipus.bokros);
        roadFrame.telepulestabla = a.nev;
        roadFrame.telepulestablavege = true;
        roadFrames.enqueue(roadFrame);
        for (int i = 0; i < 5; i++) {
            roadFrames.enqueue(new RoadFrame(RoadFrame.Utminoseg.joketsavos, RoadFrame.Tipus.bokros));
        }

        return roadFrames;
    }

    private void addRoadFromQueue() {
        try {
            RoadFrameActor newRoadFrameActor = new RoadFrameActor(roadFrames.dequeue());
            addActor(newRoadFrameActor);
            newRoadFrameActor.setZIndex(1);
            if (lastRoadFrameActor != null) {
                newRoadFrameActor.setPosition(lastRoadFrameActor.getX(), lastRoadFrameActor.getY() + lastRoadFrameActor.getHeight());
            }
            lastRoadFrameActor = newRoadFrameActor;
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }

    public GameStage(final Batch batch, RecklessRush game) {
        super(new ExtendViewport(1024, 768), batch, game);
        rand = new Random();

        City a = new City("Zalaegerszeg", City.Varostipus.megyeszekhely);
        City b = new City("Keszthely", City.Varostipus.kisvaros);
        roadFrames = generateMap(a, b);
        vehicles = new ArrayList<Vehicle>();
        //addActor(bg =new BgActor(Assets.manager.get(Assets.HATTER_TEXTURE),0,100));
        //addActor(bg2 =new BgActor(Assets.manager.get(Assets.HATTER_TEXTURE),0,bg.getY()+bg.getHeight()/1.5f));

//        System.out.println(bg.getY());
//        System.out.println(bg.isInFrustum());
/*        addActor(ba1 = new BokorActor(Assets.manager.get(Assets.BOKOR_EP_TEXTURE), 470,bg.getY()));
        addActor(ba2 = new BokorActor(Assets.manager.get(Assets.BOKOR_EP_TEXTURE), 470, bg.getY()+250));
        addActor(ba3 = new BokorActor(Assets.manager.get(Assets.BOKOR_EP_TEXTURE), 470,bg.getY()+500));*/
        //addActor(bg3 =new BgActor(Assets.manager.get(Assets.HATTER_TEXTURE),0,1430));
        addActor(car = new CarActor(this));
        car.setSpeed(8);
        car2 = new CarActor(this);
        car2.setVisible(false);
        addActor(blueCarActor = new BlueCarActor(1000, rand.nextBoolean()));
        blueCarActor.setSpeed(6.5f);
        blueCarActor.setZIndex(10);
        addActor(blueCarActor2 = new BlueCarActor(1200, rand.nextBoolean()));
        blueCarActor2.setSpeed(6.5f);
        blueCarActor2.setZIndex(10);
        addActor(pedActor = new PedActor(this));
        car.setZIndex(10);
        pedActor.setZIndex(10);
        addActor(truckActor = new TruckActor(500, rand.nextBoolean()));
        addActor(truckActor2 = new TruckActor(900, rand.nextBoolean()));
        truckActor.setZIndex(10);
        truckActor2.setZIndex(10);
        truckActor.setSpeed(5);
        vehicles.add(truckActor2);
        vehicles.add(truckActor);
        vehicles.add(blueCarActor);
        vehicles.add(blueCarActor2);
        addListener(new ClickListener() {
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

    boolean go = false;
    boolean egyszer = true;

    @Override
    public void act(float delta) {
        super.act(delta);
        if (car != null) {
            car.setY(car.getY() + car.getSpeed());
            setCameraMoveToY(car.getY() + getViewport().getScreenHeight() / 2.5f);
        }

        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) {
                if (!(vehicle.isSzembe())) vehicle.setY(vehicle.getY() + vehicle.getSpeed());
                else vehicle.setY(vehicle.getY() - vehicle.getSpeed());
                vehicle.setZIndex(10);
            }

            if (vehicle instanceof BlueCarActor) vehicle.setSpeed(6.5f);
            else if (vehicle instanceof TruckActor) vehicle.setSpeed(5);

            if (vehicle.getY() + getViewport().getScreenHeight() < car.getY()) {
                vehicle.setY(car.getY() + getViewport().getScreenHeight());
                vehicle.setMagas(vehicle.getY());
                vehicle.setSzembe(rand.nextBoolean());
            }

        }




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
        while (!roadFrames.isEmpty() && lastRoadFrameActor.isInFrustum(2)) {
            addRoadFromQueue();
        }
        if (roadFrames.isEmpty()) {
            //TODO: Új térképet generálni az alapértelmezett út fele
        }

        Array<Actor> actors = getActors();

        ArrayList<Actor> deleteActor = new ArrayList<>();
        for (Actor a : actors) {
            if (a instanceof RoadFrameActor) {
                if (!car.overlaps((MyActor) a)) {
                    deleteActor.add(a);
                }
            }
        }
        for (Actor a : deleteActor) {
            actors.removeValue(a, true);
        }

        for (Vehicle vehicle : vehicles) {
            if (!(vehicle instanceof CarActor)) {
                for (String s : car.getMyOverlappedShapeKeys(vehicle)) {
                    try {
                        if (!(s.equals("Frustum")))
                           // System.out.println(s);
                        if (s.equals("JOBB_OLDAL") || s.equals("JOBB_ELSO") || s.equals("JOBB_HATSO") || s.equals("JOBB_SEGG")) {
                            vehicle.setGoToRightSide(true);
                        } else if (s.equals("BAL_OLDAL") || s.equals("BAL_ELSO") || s.equals("BAL_HATSO") || s.equals("BAL_SEGG")) {
                            vehicle.setGoToLeftSide(true);
                        }
                        if (s.equals("BAL_ORR") || s.equals("JOBB_ORR")) {
                            car.setSpeed(4);
                        }

                        if(vehicle.isSzembe() && (s.equals("BAL_ORR") || s.equals("JOBB_ORR"))){


                            addRobbanas(car.getX(), car.getY());
                            explosionActor.setPosition(car.getX() + car.getWidth() - explosionActor.getWidth() / 2, car.getY() + car.getHeight() - explosionActor.getHeight() / 2);
                            if (explosionActor.vege) {
                                game.setScreenBackByStackPop();
                            }
                            car.setSpeed(0);
                            vehicle.setSpeed(0);
                            car.mehet = false;

                        }
                        ChangingOffsetSprite changingOffsetSprite = (ChangingOffsetSprite) car.getSprite(s);
                        changingOffsetSprite.changeOnce();
                        car2.setVisible(false);
                        car2.removeCollisionShape("Frustum");
                        for (String ss : vehicle.getMyOverlappedShapeKeys(car2)){
                            if(!(vehicle instanceof CarActor) ) {
                                System.out.println(ss);
                                ChangingOffsetSprite changingOffsetSprite1 = (ChangingOffsetSprite) vehicle.getSprite(ss);
                                changingOffsetSprite1.changeOnce();
                            }
                        }
                    } catch (Exception e) {

                    }
                }
            }
        }
        if (car.getSpeed() < 8) {
            car.setSpeed(car.getSpeed() + 0.05f);
        }

      /*  for(String s: car.getMyOverlappedShapeKeys(truckActor)){
            try{
                System.out.println(s);
                if(!(s.equals("Frustum"))) truckActor.setGoToSide(true);
                car.changeSprite(s,new OffsetSprite(Assets.manager.get(Assets.B_SEGG_TOROTT),0,0));
            }catch(Exception e){

            }
        }

        for(String s: car.getMyOverlappedShapeKeys(truckActor2)){
            try{
                System.out.println(s);
                if(!(s.equals("Frustum"))) truckActor2.setGoToSide(true);
                car.changeSprite(s,new OffsetSprite(Assets.manager.get(Assets.B_SEGG_TOROTT),0,0));
            }catch(Exception e){

            }
        }

        for(String s: car.getMyOverlappedShapeKeys(blueCarActor)){
            try{
                if(!(s.equals("Frustum")))System.out.println(s);
                if(!(s.equals("Frustum"))) blueCarActor.setGoToSide(true);
                car.changeSprite(s,new OffsetSprite(Assets.manager.get(Assets.B_SEGG_TOROTT),0,0));
            }catch(Exception e){

            }
        }

        for(String s: car.getMyOverlappedShapeKeys(blueCarActor2)){
            try{
                if(!(s.equals("Frustum"))) blueCarActor2.setGoToSide(true);
                car.changeSprite(s,new OffsetSprite(Assets.manager.get(Assets.B_SEGG_TOROTT),0,0));
            }catch(Exception e){

            }
        }*/

        for (Vehicle vehicle : vehicles) {
            if (!(vehicle.isInFrustum())) {
                vehicle.setGoToSide(false);
                vehicle.setGoToLeftSide(false);
                vehicle.setGoToRightSide(false);
                vehicle.mehet=true;
            }
            for (Vehicle vehicle2 : vehicles) {
                if (!(vehicle instanceof CarActor) && !(vehicle2 instanceof CarActor) && (vehicle != vehicle2)) {
                    for (String s : vehicle.getMyOverlappedShapeKeys(vehicle2)) {

                        if ((s.equals("Slowdown"))) {
                          vehicle.setSpeed(vehicle2.getSpeed());
                        }
                        if (!(vehicle instanceof TruckActor && (s.equals("BAL_SEGG") || s.equals("JOBB_SEGG")))) {
                            if (s.equals("JOBB_OLDAL") || s.equals("JOBB_ELSO") || s.equals("JOBB_HATSO") || s.equals("JOBB_SEGG")) {
                                if (!(vehicle2.isGoToLeftSide()))
                                    vehicle2.setGoToRightSide(true);
                            } else if (s.equals("BAL_OLDAL") || s.equals("BAL_ELSO") || s.equals("BAL_HATSO") || s.equals("BAL_SEGG")) {

                                if (!(vehicle2.isGoToRightSide()))
                                    vehicle2.setGoToLeftSide(true);
                            }
                        }

                        if((s.equals("JOBB_ORR") || s.equals("BAL_ORR")) && vehicle2.isSzembe()){
                            vehicle.setSpeed(0);
                            vehicle2.setSpeed(0);
                            vehicle.mehet=false;
                            vehicle2.mehet=false;
                            addRobbanas(vehicle.getX(),vehicle.getY());
//                            explosionActor.setPosition(vehicle.getX()+vehicle.getWidth()-explosionActor.getWidth()/2,vehicle.getY()+vehicle.getHeight()-explosionActor.getHeight()/2);

                        }

                        if(!(s.equals("Slowdown")) && !(vehicle.isGoToRightSide()) && !(vehicle.isGoToLeftSide())){

                        }
                    }
                }
            }
        }
    }



    boolean isGoingToSide(){
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle.isGoToRightSide() || vehicle.isGoToLeftSide());
            if(vehicle.isGoToRightSide() || vehicle.isGoToLeftSide()) return true;
        }
        return false;
    }

    boolean van = false;

    void addRobbanas(float x, float y){
        for(Actor actor : getActors()){
            if(actor instanceof ExplosionActor) van=true;
        }
        if(!van)addActor(explosionActor = new ExplosionActor(x,y));
    }
}
