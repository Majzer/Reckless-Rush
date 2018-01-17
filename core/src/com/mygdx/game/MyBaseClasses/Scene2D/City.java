package com.mygdx.game.MyBaseClasses.Scene2D;

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

    public final String nev;
    public final Varostipus varostipus;
    public final HashMap<City, Integer> szomszedok = new HashMap<City, Integer>();


    public City(String nev, Varostipus varostipus) {
        this.nev = nev;
        this.varostipus = varostipus;
    }


}
