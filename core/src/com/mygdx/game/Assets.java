package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
	static Texture fground;
	static Texture fgrass;
	
	public static void load()
	{
		fground = new Texture(Gdx.files.internal("Fground.png"));
		fgrass = new Texture(Gdx.files.internal("Fgrass.png"));
	}
}
