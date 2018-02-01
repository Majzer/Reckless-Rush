package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Music;
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
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;

import javax.smartcardio.CardTerminal;

import java.util.Deque;

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
    HouseActor house1, house2 ,house3, house4;
    BokorActor bokor1 , bokor2 , bokor3 , bokor4;
    Vector<KatyuActor> katyuk = new Vector(1,1);
    Music sound;
    Music music;
    RoadFrame roadFrame;

    Queue<RoadFrame> roadFrames;
    RoadFrameActor lastRoadFrameActor = null;
    RoadFrameActor lowestRoadFrameActor=null;

    public Queue<RoadFrame> generateMap(City a, City b) {
        Queue<RoadFrame> roadFrames = new LinkedList<>();
        for (int i = 0; i < a.szomszedok.get(a.getIndexOfCityByNameFromRoadToCityArrayList(b.nev)).getDistance(); i++) {
            roadFrames.add(new RoadFrame(RoadFrame.Utminoseg.joegysavos, RoadFrame.Tipus.ures));
            try {
                roadFrames.add(new RoadFrame(RoadFrame.Utminoseg.joegysavos, RoadFrame.Tipus.ures));
            } catch(Exception e){

            }
        }
        roadFrame = new RoadFrame(RoadFrame.Utminoseg.rosszegysavos, RoadFrame.Tipus.elagazojobbra);
        roadFrame.telepulestabla = a.nev;
        roadFrame.telepulestablavege = true;
        roadFrames.add(roadFrame);
        return roadFrames;
    }

    boolean elso = true;
    boolean mostmehet=false;
    RoadFrameActor kanyarodos=null;
    City a,b;

    private void addRoadFromQueue() {
        try {
            RoadFrameActor newRoadFrameActor = new RoadFrameActor(roadFrames.remove(), this);
            addActor(newRoadFrameActor);
            newRoadFrameActor.setZIndex(1);
            if(newRoadFrameActor.roadFrame.tipus == RoadFrame.Tipus.elagazojobbra) kanyarodos = newRoadFrameActor;
            if (lastRoadFrameActor != null) {
               // System.out.println(worldRotation == worldRotation.r90);
               // System.out.println(worldRotation == worldRotation.r0);
                if(worldRotation == worldRotation.r0)
                    newRoadFrameActor.setPosition(lastRoadFrameActor.getX(), lastRoadFrameActor.getY() + lastRoadFrameActor.getHeight());
                if(worldRotation == worldRotation.r90) {
                    newRoadFrameActor.setRotation(90);
                    if(elso){
                        newRoadFrameActor.setPosition(lowestRoadFrameActor.getX()+lowestRoadFrameActor.getWidth(),lowestRoadFrameActor.getY()+lowestRoadFrameActor.getHeight());
                        elso=false;
                    } else
                    newRoadFrameActor.setPosition(lastRoadFrameActor.getX()+lastRoadFrameActor.getHeight(), lastRoadFrameActor.getY());

                }

            }
            lastRoadFrameActor = newRoadFrameActor;
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public void rotate(WorldRotation worldRotation){
        this.worldRotation = worldRotation;
        switch (worldRotation){
            case r90:
                getCamera().rotate(90, 0,0,-1);
                break;
        }
    }



    public GameStage(final Batch batch, RecklessRush game) {
        super(new ExtendViewport(1024, 768), batch, game);
        sound = Assets.manager.get(Assets.ThemeSound);
        music = Assets.manager.get(Assets.Miami_Soul);
        rand = new Random();


        music.pause();
        sound.setVolume(0.4f);
        sound.setLooping(true);
        sound.play();

        switch(worldRotation){
            case r90:
                getCamera().rotate(90, 0,0,-1);
                break;
        }

        a = new City("Zalaegerszeg", City.Varostipus.megyeszekhely);
        b = new City("Bak", City.Varostipus.kisvaros);
        roadFrames = generateMap(a, b);
        vehicles = new ArrayList<Vehicle>();
        //addActor(bg =new BgActor(Assets.manager.get(Assets.ROAD_TEXTURE),0,100));
        //addActor(bg2 =new BgActor(Assets.manager.get(Assets.ROAD_TEXTURE),0,bg.getY()+bg.getHeight()/1.5f));

//        System.out.println(bg.getY());
//        System.out.println(bg.isInFrustum());
/*        addActor(ba1 = new BokorActor(Assets.manager.get(Assets.BOKOR_EP_TEXTURE), 470,bg.getY()));
        addActor(ba2 = new BokorActor(Assets.manager.get(Assets.BOKOR_EP_TEXTURE), 470, bg.getY()+250));
        addActor(ba3 = new BokorActor(Assets.manager.get(Assets.BOKOR_EP_TEXTURE), 470,bg.getY()+500));*/
        //addActor(bg3 =new BgActor(Assets.manager.get(Assets.ROAD_TEXTURE),0,1430));


        //Út melletti objektumoknak az actorai
        addActor(bokor1 = new BokorActor(Assets.manager.get(Assets.BUSH_LINE_TEXTURE), getViewport().getScreenWidth()-127 , 0 , false));
        addActor(bokor2 = new BokorActor(Assets.manager.get(Assets.BUSH_LINE_TEXTURE), getViewport().getScreenWidth()-127 , 0 , false));
        addActor(bokor3 = new BokorActor(Assets.manager.get(Assets.BUSH_LINE_TEXTURE), 0 , 0 , true));
        addActor(bokor4 = new BokorActor(Assets.manager.get(Assets.BUSH_LINE_TEXTURE), 0 , 0 , true));
        addActor(house1 = new HouseActor(0,0, false));
        addActor(house2 = new HouseActor(0,0, false));
        addActor(house3 = new HouseActor(getViewport().getScreenWidth()-127,0, true));
        addActor(house4 = new HouseActor(getViewport().getScreenWidth()-127,0, true));

        addActor(car = new CarActor(this));
        car.setSpeed(8);
        car2 = new CarActor(this);
        car2.setVisible(false);
        addActor(blueCarActor = new BlueCarActor(1000, rand.nextBoolean(), this));
        blueCarActor.setSpeed(6.5f);
        blueCarActor.setZIndex(10);
        addActor(blueCarActor2 = new BlueCarActor(1200, rand.nextBoolean(), this));
        blueCarActor2.setSpeed(6.5f);
        blueCarActor2.setZIndex(10);
        addActor(pedActor = new PedActor(this, 0.5f, rand.nextBoolean(), car.getY()+getViewport().getWorldHeight()));
        car.setZIndex(10);
        pedActor.setZIndex(10);
        addActor(truckActor = new TruckActor(500, rand.nextBoolean(), this));
        addActor(truckActor2 = new TruckActor(900, rand.nextBoolean(), this));
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

        //Kátyú actorjai
        for (int i = 0; i<3 ; i++){
            KatyuActor katyu = new KatyuActor(car.destinations);
            addActor(katyu);
            katyuk.add(katyu);
        }

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
    boolean voltMarEgyszer=false;
    long ido = System.currentTimeMillis();

    @Override
    public void act(float delta) {
        super.act(delta);


        if(System.currentTimeMillis()-ido>2500){
            addActor(new PedActor(this, 0.5f, rand.nextBoolean(), car.getY()+getViewport().getWorldHeight()));
            ido=System.currentTimeMillis();
        }

        if (car != null) {
            car.refreshDestinations();
            if(worldRotation == worldRotation.r0) {
                car.setY(car.getY() + car.getSpeed());
                setCameraMoveToY(car.getY() + getViewport().getScreenHeight() / 2.5f);
                getViewport().setScreenPosition(getViewport().getScreenX(),getViewport().getScreenY()+(int)car.getSpeed());
            } else if (worldRotation == worldRotation.r90){
                if(car.kenyszerithet)
                    car.intteKenyszerit();
                car.setX(car.getX() + car.getSpeed());
                setCameraMoveToX(car.getX() + getViewport().getScreenWidth() / 3);
                getViewport().setScreenPosition(getViewport().getScreenX()+(int)car.getSpeed(), getViewport().getScreenY());
            }
        }

        if(lastRoadFrameActor.getRoadFrame().tipus == RoadFrame.Tipus.elagazojobbra){
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) ||  Gdx.input.getAccelerometerY() > 3) {
                if(lowestRoadFrameActor!=null)
                if(worldRotation!=worldRotation.r90 && car.getY()>(lowestRoadFrameActor.getY()+49)){
                    car.setRotationBase(-90);
                    for(Vehicle vehicle : vehicles){
                        vehicle.setRotationBase(270);
                    }

                    worldRotation = worldRotation.r90;
                    rotate(worldRotation.r90);
                    getViewport().setScreenPosition((int)(lowestRoadFrameActor.getX()+lowestRoadFrameActor.getWidth()),(int)(lowestRoadFrameActor.getY()+lowestRoadFrameActor.getHeight()));

                    car.setWorldRotation(true);
                    roadFrames = generateMap(new City("Keszthely", City.Varostipus.nagyvaros),new City("Nagykanizsa", City.Varostipus.nagyvaros));
                    addRoadFromQueue();
                }

            }
        }

        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) {
                if(worldRotation == worldRotation.r0) {
                    if (!(vehicle.isSzembe())) vehicle.setY(vehicle.getY() + vehicle.getSpeed());
                    else {vehicle.setY(vehicle.getY() - vehicle.getSpeed());}
                    if(!(vehicle instanceof CarActor))vehicle.setWorldRotation(false);
                }
                else {
                    if (!(vehicle.isSzembe())) vehicle.setX(vehicle.getX() + vehicle.getSpeed());
                    else {vehicle.setX(vehicle.getX() - vehicle.getSpeed());}
                    if(!(vehicle instanceof CarActor))vehicle.setWorldRotation(true);
                }
                vehicle.setZIndex(10);
            }

            if (vehicle instanceof BlueCarActor) vehicle.setSpeed(6.5f);
            else if (vehicle instanceof TruckActor) vehicle.setSpeed(5);

            if(worldRotation == worldRotation.r0){
            if (vehicle.getY() + getViewport().getScreenHeight() < car.getY()) {
                vehicle.setY(car.getY() + getViewport().getScreenHeight());
                vehicle.setMagas(vehicle.getY());
                vehicle.setSzembe(rand.nextBoolean());
            }

            } else {
                if (vehicle.getX() + getViewport().getScreenHeight() < car.getX()) {
                    vehicle.setX(car.getX() + getViewport().getScreenHeight());
                    vehicle.setMagas(vehicle.getX());
                    vehicle.setSzembe(rand.nextBoolean());
                }
            }

        }

        //Út melletti objektumok kiválasztása és lehelyezése
        if(roadFrame.tipus == RoadFrame.Tipus.bokros){
            if(bokor1.getY()+bokor1.getHeight()+80 < car.getY()){
                bokor1.setY(bokor2.getY()+bokor2.getHeight());
                bokor1.setZIndex(50);
            }

            if(bokor2.getY()+bokor2.getHeight()+80 < car.getY()){
                bokor2.setY(bokor1.getY()+bokor1.getHeight());
                bokor2.setZIndex(50);

            }

            if(bokor3.getY()+bokor3.getHeight()+80 < car.getY()){
                bokor3.setY(bokor4.getY()+bokor4.getHeight());
                bokor3.setZIndex(50);
            }

            if(bokor4.getY()+bokor4.getHeight()+80 < car.getY()){
                bokor4.setY(bokor3.getY()+bokor3.getHeight());
                bokor4.setZIndex(50);

            }
        }

        if(roadFrame.tipus == RoadFrame.Tipus.erdos){
            bokor1.setTexture(Assets.manager.get(Assets.FORTRESS_LINE_TEXTURE));
            bokor2.setTexture(Assets.manager.get(Assets.FORTRESS_LINE_TEXTURE));
            bokor3.setTexture(Assets.manager.get(Assets.FORTRESS_LINE_TEXTURE));
            bokor4.setTexture(Assets.manager.get(Assets.FORTRESS_LINE_TEXTURE));

            if(bokor1.getY()+bokor1.getHeight()+80 < car.getY()){
                bokor1.setY(bokor2.getY()+bokor2.getHeight());
                bokor1.setZIndex(50);
            }

            if(bokor2.getY()+bokor2.getHeight()+80 < car.getY()){
                bokor2.setY(bokor1.getY()+bokor1.getHeight());
                bokor2.setZIndex(50);

            }

            if(bokor3.getY()+bokor3.getHeight()+80 < car.getY()){
                bokor3.setY(bokor4.getY()+bokor4.getHeight());
                bokor3.setZIndex(50);
            }

            if(bokor4.getY()+bokor4.getHeight()+80 < car.getY()){
                bokor4.setY(bokor3.getY()+bokor3.getHeight());
                bokor4.setZIndex(50);

            }

        }

        if (roadFrame.tipus == RoadFrame.Tipus.csaladi){

            if(house1.getY()+house1.getHeight()+80 < car.getY()){
                house1.setY(house2.getY()+house2.getHeight());
                house1.setZIndex(50);
            }

            if(house2.getY()+house2.getHeight()+80 < car.getY()){
                house2.setY(house1.getY()+house1.getHeight());
                house2.setZIndex(50);

            }

            if(house3.getY()+house3.getHeight()+80 < car.getY()){
                house3.setY(house4.getY()+house4.getHeight());
                house3.setZIndex(50);
            }

            if(house4.getY()+house4.getHeight()+80 < car.getY()){
                house4.setY(house3.getY()+house3.getHeight());
                house4.setZIndex(50);

            }

        }
        //Eddig tart!

        //Katyú csökkenti az autó sebbeségét
        for(KatyuActor a : katyuk)
            if(a.overlaps(car)){
                car.setSpeed(4);
            }

        if(roadFrame.utminoseg == RoadFrame.Utminoseg.rosszegysavos){
            for(KatyuActor a : katyuk){
                if(a.getY()<car.getY()-500)
                    a.makeNewValues(car.getY());
            }
        }

        if(roadFrame.utminoseg == RoadFrame.Utminoseg.joegysavos) {
            try{
                car.destinations = new int[]{
                        300, 400
                };
            }catch(Exception e){

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
            try{
                //if(kanyarodos==null){
                    //b = a.getCityFromNeighboursList(rand);
                    //roadFrames = generateMap(a, b);
                   // a=b;
                //}

            }catch(Exception e){

            }
            //roadFrames = generateMap(new City("Keszthely", City.Varostipus.nagyvaros),new City("Nagykanizsa", City.Varostipus.nagyvaros));
            //TODO: Új térképet generálni az alapértelmezett út fele
        }

        Array<Actor> actors = getActors();

        ArrayList<Actor> deleteActor = new ArrayList<>();
        for (Actor a : actors) {
            if(a instanceof PedActor){
                if(a.getY()<car.getY()-200){
                    deleteActor.add(a);
                }
            }
            if (a instanceof RoadFrameActor) {
                if (!car.overlaps((MyActor) a)) {
                    deleteActor.add(a);
                }
                if(car.getY()+100>a.getY() && !(a.getY()<car.getY()-100)) lowestRoadFrameActor = (RoadFrameActor)a;
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
                            car.setLife(car.ChangeLife(10, car.getLife()));
                            System.out.println(car.getLife()+ "********************************************************");
                        }

                        if(car.die(car.getLife())) {
                            game.setScreen(new MenuScreen(game));
                        }

                        if(vehicle.isSzembe() && (s.equals("BAL_ORR") || s.equals("JOBB_ORR"))){
                            addRobbanas(car.getX(), car.getY());
                            explosionActor.setPosition(car.getX() + car.getWidth() - explosionActor.getWidth() / 2, car.getY() + car.getHeight() - explosionActor.getHeight() / 2);car.setSpeed(0);
                            vehicle.setSpeed(0);
                            car.mehet = false;
                            if (explosionActor.vege) {
                                game.setScreen(new MenuScreen(game));
                            }
                        }
                        ChangingOffsetSprite changingOffsetSprite = (ChangingOffsetSprite) car.getSprite(s);
                        changingOffsetSprite.changeOnce();
                        car2.setVisible(false);
                        car2.removeCollisionShape("Frustum");
                        for (String ss : vehicle.getMyOverlappedShapeKeys(car2)){
                            if(!(vehicle instanceof CarActor) ) {
                               // System.out.println(ss);
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
                            vehicle.setX(vehicle.getX());
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

                        robbanasos = false;
                        if((s.equals("JOBB_ORR") || s.equals("BAL_ORR")) && vehicle2.isSzembe()){
                            vehicle.setSpeed(0);
                            vehicle2.setSpeed(0);
                            vehicle.setGoToRightSide(false);
                            vehicle2.setGoToRightSide(false);
                            vehicle.setGoToLeftSide(false);
                            vehicle2.setGoToLeftSide(false);
                            vehicle.setGoToSide(false);
                            vehicle2.setGoToSide(false);
                            vehicle.mehet=false;
                            vehicle2.mehet=false;
                            addRobbanas(vehicle.getX(),vehicle.getY());
                            if(!robbanasos) explosionActor.setPosition(vehicle.getX() + vehicle.getWidth() - explosionActor.getWidth() / 2, vehicle.getY() + vehicle.getHeight() - explosionActor.getHeight() / 2);
                            robbanasos=true;
                        }
                        if(!robbanasos)
                            if(!(s.equals("Slowdown")) && !(vehicle.isGoToRightSide()) && !(vehicle.isGoToLeftSide())&& !(vehicle2.isGoToRightSide())&& !(vehicle2.isGoToLeftSide())){
                                if(!(vehicle instanceof TruckActor && (s.equals("BAL_SEGG") || s.equals("JOBB_SEGG"))))
                                    vehicle.setY(vehicle.getY()+100);
                            }
                    }
                }
            }
        }
    }

    boolean robbanasos = false;

    boolean isGoingToSide(){
        for(Vehicle vehicle : vehicles){
           // System.out.println(vehicle.isGoToRightSide() || vehicle.isGoToLeftSide());
            if(vehicle.isGoToRightSide() || vehicle.isGoToLeftSide()) return true;
        }
        return false;
    }

    boolean van = false;

    void addRobbanas(float x, float y){
        for(Actor actor : getActors()){
            if(actor instanceof ExplosionActor) van=true;
        }
        if(!van){
            addActor(explosionActor = new ExplosionActor(x,y));
        }
    }
}