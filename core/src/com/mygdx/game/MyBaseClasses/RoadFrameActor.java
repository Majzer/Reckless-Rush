package com.mygdx.game.MyBaseClasses;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.mygdx.game.BokorActor;
import com.mygdx.game.GameStage;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.HouseActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MultiSpriteActor;
import com.mygdx.game.MyBaseClasses.Scene2D.OffsetSprite;

/**
 * Created by tanulo on 2018. 01. 17..
 */

public class RoadFrameActor extends MultiSpriteActor {
    public final RoadFrame roadFrame;
    GameStage gameStage;
    BokorActor bokorActor;

    public RoadFrame getRoadFrame() {
        return roadFrame;
    }

    public RoadFrameActor(RoadFrame roadFrame, GameStage gameStage) {
        super(1024, 720);
        this.roadFrame = roadFrame;
        this.gameStage = gameStage;
        switch (roadFrame.utminoseg){
            case joegysavos:
                addSprite(new OffsetSprite(Assets.manager.get(Assets.JO_UT_TEXTURE), 0 , 0), "Út");
                break;
            case joketsavos:
                addSprite(new OffsetSprite(Assets.manager.get(Assets.ROAD_TEXTURE),0,0),"Út");
                break;
            case rosszegysavos:
                break;
        }

        // TODO: 2018. 01. 30. Ismétlődést megcsinálni 
        switch(roadFrame.tipus){
            case elagazojobbra:
                changeSprite("Út", new OffsetSprite(Assets.manager.get(Assets.KANYAR_TEXTURE),0,0));
                break;
            case csaladi:
                break;
            case bokros:
                break;
            case erdos:

                break;
        }
        addBaseCollisionRectangleShape();
    }

}
