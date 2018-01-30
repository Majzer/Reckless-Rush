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

        public int getDistance() {
            return distance;
        }
    }

    public final String nev;
    public final Varostipus varostipus;
    public final ArrayList<RoadToCity> szomszedok = new ArrayList<RoadToCity>();


    public int getIndexOfCityByNameFromRoadToCityArrayList(String s){
        for(int i = 0; i<szomszedok.size()-1;i++){
            if(szomszedok.get(i).city.nev.equals(s)) return i;
        }
        return -1;
    }

    public City(String nev, Varostipus varostipus) {
        this.nev = nev;
        this.varostipus = varostipus;
        if(nev.equals("Zalaegerszeg")) {
            szomszedok.add(new RoadToCity(40, new City("Keszthely",Varostipus.kisvaros), RoadFrame.Utminoseg.joketsavos));
            szomszedok.add(new RoadToCity(15, new City("Bak",Varostipus.falu), RoadFrame.Utminoseg.rosszegysavos));
            szomszedok.add(new RoadToCity(40, new City("Lenti",Varostipus.kisvaros), RoadFrame.Utminoseg.joegysavos));
        } /*else if(nev.equals("Keszthely")){
            szomszedok.add(new RoadToCity(40, new City("Nagykanizsa",Varostipus.nagyvaros), RoadFrame.Utminoseg.joketsavos));
            szomszedok.add(new RoadToCity(35, new City("Bak",Varostipus.falu), RoadFrame.Utminoseg.joegysavos));
            szomszedok.add(new RoadToCity(15, new City("Zalaegerszeg",Varostipus.megyeszekhely), RoadFrame.Utminoseg.joketsavos));
        } else if(nev.equals("Bak")){
            szomszedok.add(new RoadToCity(35, new City("Keszthely",Varostipus.kisvaros), RoadFrame.Utminoseg.joegysavos));
            szomszedok.add(new RoadToCity(15, new City("Zalaegerszeg",Varostipus.megyeszekhely), RoadFrame.Utminoseg.rosszegysavos));
        } else if(nev.equals("Nagykanizsa")){
            //szomszedok.add(new RoadToCity(35, new City("Letenye",Varostipus.kisvaros), RoadFrame.Utminoseg.joegysavos));
            szomszedok.add(new RoadToCity(40, new City("Keszthely",Varostipus.kisvaros), RoadFrame.Utminoseg.joketsavos));
        } else if(nev.equals("Letenye")){
           // szomszedok.add(new RoadToCity(40, new City("Nagykanizsa",Varostipus.nagyvaros), RoadFrame.Utminoseg.joegysavos));
            szomszedok.add(new RoadToCity(30, new City("Lenti",Varostipus.falu), RoadFrame.Utminoseg.rosszegysavos));
        } else if(nev.equals("Lenti")){
            szomszedok.add(new RoadToCity(30, new City("Letenye",Varostipus.nagyvaros), RoadFrame.Utminoseg.rosszegysavos));
            szomszedok.add(new RoadToCity(40, new City("Zalaegerszeg",Varostipus.megyeszekhely), RoadFrame.Utminoseg.joegysavos));
        }*/
    }

    public static void main(String[] args) {

    }
}
