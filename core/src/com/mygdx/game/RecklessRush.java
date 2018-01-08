package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.DemoLoading.LoadingScreen;
import com.mygdx.game.MyBaseClasses.Game.MyGame;
import com.mygdx.game.GlobalClasses.Assets;

public class RecklessRush extends MyGame {
	
	@Override
	public void create () {
		Gdx.input.setCatchBackKey(true);

		Assets.prepare();
		setScreen(new LoadingScreen(this));
	}
}
