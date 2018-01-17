package com.mygdx.game.MyBaseClasses;

import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MultiSpriteActor;
import com.mygdx.game.MyBaseClasses.Scene2D.OffsetSprite;
import com.mygdx.game.MyBaseClasses.Scene2D.ShapeType;

/**
 * Created by tanulo on 2018. 01. 17..
 */

public class RoadFrameActor extends MultiSpriteActor {
    public final RoadFrame roadFrame;

    public RoadFrameActor(RoadFrame roadFrame) {
        super(1024, 720);
        this.roadFrame = roadFrame;
        switch (roadFrame.utminoseg){
            case joegysavos:
                break;
            case joketsavos:
                break;
            case rosszegysavos:
                break;
        }
        addSprite(new OffsetSprite(Assets.manager.get(Assets.HATTER_TEXTURE),0,0));
        addBaseCollisionRectangleShape();
    }

}
