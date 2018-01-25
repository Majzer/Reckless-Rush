package com.mygdx.game.MyBaseClasses;

/**
 * Created by tanulo on 2018. 01. 17..
 */

public class RoadFrame {
    public enum Utminoseg{
        rosszegysavos,
        joegysavos,
        joketsavos,
    }

    public enum Tipus{
        ures,
        csaladi,
        panel,
        bokros,
        erdos,
        elagazojobbra,
    }

    public Utminoseg utminoseg;
    public Tipus tipus;
    public String utelagazasjelzotabla = null;
    public String telepulestabla = null;
    public boolean telepulestablavege = false;
    public RoadFrame kovetkezo = null;
    public RoadFrame elozo = null;

    public RoadFrame(Utminoseg utminoseg, Tipus tipus) {
        this.utminoseg = utminoseg;
        this.tipus = tipus;
    }
}
