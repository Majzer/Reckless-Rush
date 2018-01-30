package com.mygdx.game.MyBaseClasses.Scene2D;

import com.mygdx.game.MyBaseClasses.RoadFrame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

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

        public int getDistance() {
            return distance;
        }
    }

    public final String nev;
    public final Varostipus varostipus;
    public final Vector<RoadToCity> szomszedok = new Vector();


    public int getIndexOfCityByNameFromRoadToCityArrayList(String s){
        for(int i = 0; i<szomszedok.size()-1;i++){
            if(szomszedok.get(i).city.nev.equals(s)) return i;
        }
        return -1;
    }

    static City keszthely = new City("Keszthely", Varostipus.kisvaros);
    static City zalaegerszeg = new City("Zalaegerszeg", Varostipus.megyeszekhely);
    static City bak = new City("Bak", Varostipus.falu);
    static City lenti = new City("Lenti", Varostipus.kisvaros);
    static City letenye = new City("Letenye", Varostipus.kisvaros);
    static City nagykanizsa = new City("Nagykanizsa", Varostipus.nagyvaros);

    public City(String nev, Varostipus varostipus) {

        this.nev = nev;
        this.varostipus = varostipus;
        if(nev.equals("Zalaegerszeg")) {
            szomszedok.add(new RoadToCity(40, keszthely, RoadFrame.Utminoseg.joketsavos));
            szomszedok.add(new RoadToCity(15, bak, RoadFrame.Utminoseg.rosszegysavos));
            szomszedok.add(new RoadToCity(40, lenti, RoadFrame.Utminoseg.joegysavos));
        } else if(nev.equals("Keszthely")){
            szomszedok.add(new RoadToCity(40, nagykanizsa, RoadFrame.Utminoseg.joketsavos));
            szomszedok.add(new RoadToCity(35, bak, RoadFrame.Utminoseg.joegysavos));
            szomszedok.add(new RoadToCity(15, zalaegerszeg, RoadFrame.Utminoseg.joketsavos));
        } else if(nev.equals("Bak")){
            szomszedok.add(new RoadToCity(35, keszthely, RoadFrame.Utminoseg.joegysavos));
            szomszedok.add(new RoadToCity(15, zalaegerszeg, RoadFrame.Utminoseg.rosszegysavos));
        } else if(nev.equals("Nagykanizsa")){
            szomszedok.add(new RoadToCity(35, letenye, RoadFrame.Utminoseg.joegysavos));
            szomszedok.add(new RoadToCity(40, keszthely, RoadFrame.Utminoseg.joketsavos));
        } else if(nev.equals("Letenye")){
            szomszedok.add(new RoadToCity(40, nagykanizsa, RoadFrame.Utminoseg.joegysavos));
            szomszedok.add(new RoadToCity(30, lenti, RoadFrame.Utminoseg.rosszegysavos));
        } else if(nev.equals("Lenti")){
            szomszedok.add(new RoadToCity(30, letenye, RoadFrame.Utminoseg.rosszegysavos));
            szomszedok.add(new RoadToCity(40, zalaegerszeg, RoadFrame.Utminoseg.joegysavos));
        }
    }

    public static void main(String[] args) {

    }
}
