package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.RecklessRush;

public class DesktopLauncher {
	public static void main (String[] arg) {
		 config = new LwjglApplicationConfiguration();
		config.width=1920;
		config.height=768;
		new LwjglApplication(new RecklessRush(), config);
	}
}
