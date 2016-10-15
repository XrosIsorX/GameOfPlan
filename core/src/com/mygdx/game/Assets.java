package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
	static Texture fground;
	static Texture fgrass;
	static Texture friver;
	static Texture pickboard;
	static Texture cskeleton;
	static Texture pickitemscreen;
	static Texture slotblock;
	static Texture selectbutton;
	
	public static void load()
	{
		fground = new Texture(Gdx.files.internal("Fground.png"));
		fgrass = new Texture(Gdx.files.internal("Fgrass.png"));
		friver = new Texture(Gdx.files.internal("Friver.png"));
		
		pickboard = new Texture(Gdx.files.internal("Pickboard.png"));
		
		cskeleton = new Texture(Gdx.files.internal("mon2_walk.gif"));
		
		pickitemscreen = new Texture(Gdx.files.internal("PickitemScreen.png"));
		slotblock = new Texture(Gdx.files.internal("SlotBlock.png"));
		selectbutton = new Texture(Gdx.files.internal("SelectButton.png"));
	}
}
