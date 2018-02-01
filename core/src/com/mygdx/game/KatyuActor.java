package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

import java.util.Random;
import java.util.Vector;

import sun.java2d.pipe.AAShapePipe;

/**
 * Created by tanulo on 2018. 01. 31..
 */

public class KatyuActor extends OneSpriteStaticActor {

    Vector<Texture> textures = new Vector();

    public void setDestinations(int[] destinations) {
        this.destinations = destinations;
    }

    private int[] destinations;
    Random rand;

    public KatyuActor(int[] destinations) {
        super(Assets.manager.get(Assets.KATYU1_TEXTURE));
        this.destinations = destinations;

        rand = new Random();

        //katyu texturak hozzarendelese
        textures.add(Assets.manager.get(Assets.KATYU1_TEXTURE));
        textures.add(Assets.manager.get(Assets.KATYU2_TEXTURE));
        textures.add(Assets.manager.get(Assets.KATYU3_TEXTURE));
         makeNewValues(0);
    }

    public int aroundByNumber(int number, int plusminus){
        int result = number, change = rand.nextInt(plusminus);
        if(rand.nextBoolean())
            change *= -1;
        return result+change;
    }

    public void makeNewValues(float carYPos){
        //szog
        setRotation(rand.nextInt(45));
        //text
        setTexture(textures.get(rand.nextInt(textures.size())));
        //hely
        setPosition(
                aroundByNumber(destinations[rand.nextInt(destinations.length)], 40),
                carYPos + rand.nextInt(2000)+500
        );
    }


}
