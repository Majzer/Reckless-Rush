package com.mygdx.game.MyBaseClasses.Scene2D;

import com.mygdx.game.MyBaseClasses.RoadFrame;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tanulo on 2018. 01. 17..
 */

public class City {
    public enum Varostipus{
        falu,
        kisvaros,
        nagyvaros,
        megyeszekhely,
        fovaros
    }

    public class RoadToCity{
        public int distance;
        public City city;
        public RoadFrame.Utminoseg utminoseg;

        public RoadToCity(int distance, City city, RoadFrame.Utminoseg utminoseg) {
            this.distance = distance;
            this.city = city;
            this.utminoseg = utminoseg;
        }
    }

    public final String nev;
    public final Varostipus varostipus;
    public final ArrayList<RoadToCity> szomszedok = new ArrayList<RoadToCity>();


    public City(String nev, Varostipus varostipus) {
        this.nev = nev;
        this.varostipus = varostipus;
    }


    public static void main(String[] args) {

    }
}
