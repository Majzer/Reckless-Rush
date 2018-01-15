package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.DemoLoading.LoadingScreen;
import com.mygdx.game.MyBaseClasses.MyGame;
import com.mygdx.game.GlobalClasses.Assets;

public class RecklessRush extends MyGame {

	public TextButton.TextButtonStyle btnStart() {
		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.font = Assets.manager.get(Assets.ARIAL_30_FONT);
		textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_START_TEXTURE)));
		textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_START_TEXTURE)));
		textButtonStyle.down = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_START_DOWN_TEXTURE)));
		return textButtonStyle;
	}

	public TextButton.TextButtonStyle btnExit() {
		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.font = Assets.manager.get(Assets.ARIAL_30_FONT);
		textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_EXIT_TEXTURE)));
		textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_EXIT_TEXTURE)));
		textButtonStyle.down = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_EXIT_DOWN_TEXTURE)));
		return textButtonStyle;
	}

	@Override
	public void create () {
		Gdx.input.setCatchBackKey(true);

		Assets.prepare();
		setScreen(new LoadingScreen(this));
	}
}
