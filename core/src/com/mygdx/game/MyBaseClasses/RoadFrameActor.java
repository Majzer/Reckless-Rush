package com.mygdx.game.MyBaseClasses;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MultiSpriteActor;
import com.mygdx.game.MyBaseClasses.Scene2D.OffsetSprite;

/**
 * Created by tanulo on 2018. 01. 17..
 */

public class RoadFrameActor extends MultiSpriteActor {
    public final RoadFrame roadFrame;

    public RoadFrame getRoadFrame() {
        return roadFrame;
    }

    public RoadFrameActor(RoadFrame roadFrame) {
        super(1024, 720);
        this.roadFrame = roadFrame;
        switch (roadFrame.utminoseg){
            case joegysavos:
                addSprite(new OffsetSprite(Assets.manager.get(Assets.JO_KANYAR_TEXTURE),0,0),"Út");
                break;
            case joketsavos:
                addSprite(new OffsetSprite(Assets.manager.get(Assets.ROAD_TEXTURE),0,0),"Út");
                break;
            case rosszegysavos:
                break;
        }

        switch(roadFrame.tipus){
            case elagazojobbra:
                changeSprite("Út", new OffsetSprite(Assets.manager.get(Assets.KANYAR_TEXTURE),0,0));
        }
        addBaseCollisionRectangleShape();
    }

}
