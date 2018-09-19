package com.yakovlev.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.yakovlev.game.YADGame;

import java.io.File;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Donater";
		config.resizable = false;
		config.height = 600;
		config.width = 400;
		config.addIcon("donut_ico.png", Files.FileType.Internal);
		new LwjglApplication(new YADGame(), config);
	}
}
