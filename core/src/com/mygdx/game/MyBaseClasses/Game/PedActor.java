package com.mygdx.game.MyBaseClasses.Game;

import com.mygdx.game.GameStage;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Game.Scene2D.OneSpriteAnimatedActor;

/**
 * Created by tanulo on 2018. 01. 10..
 */

public class PedActor extends OneSpriteAnimatedActor {

    GameStage gameStage;

    public PedActor(GameStage gameStage) {
        super(Assets.manager.get(Assets.WALK_TEXTURE));
        setFps(13);
        this.gameStage = gameStage;
    }

    @Override
    public void act(float delta) {
        setY(getY() + 0.5f);
        super.act(delta);
    }
}
