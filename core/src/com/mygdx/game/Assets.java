package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
	static Texture fground;
	static Texture fgrass;
	static Texture friver;
	static Texture pickboard;
	static Texture pickitemscreen;
	static Texture slotblock;
	
	static Texture selectbutton;
	static Texture startgamebutton;
	static Texture endturnbutton;
	
	static Texture smana;
	static Texture shealth;
	
	static Texture cwizard;
	static Texture cswordman;
	static Texture cmon1;
	static Texture cmon2;
	
	public static void load()
	{
		fground = new Texture(Gdx.files.internal("Fground.png"));
		fgrass = new Texture(Gdx.files.internal("Fgrass.png"));
		friver = new Texture(Gdx.files.internal("Friver.png"));
		
		pickboard = new Texture(Gdx.files.internal("Pickboard.png"));

		pickitemscreen = new Texture(Gdx.files.internal("PickitemScreen.png"));
		slotblock = new Texture(Gdx.files.internal("SlotBlock.png"));
		selectbutton = new Texture(Gdx.files.internal("SelectButton.png"));
		startgamebutton = new Texture(Gdx.files.internal("StartGameButton.png"));
		endturnbutton = new Texture(Gdx.files.internal("EndturnButton.png"));
		
		smana = new Texture(Gdx.files.internal("Smana.png"));
		shealth = new Texture(Gdx.files.internal("Shealth.png"));
		cwizard = new Texture(Gdx.files.internal("Cwizard.png"));
		cswordman = new Texture(Gdx.files.internal("Cswordman.png"));
		cmon1 = new Texture(Gdx.files.internal("Cmon1.png"));
		cmon2 = new Texture(Gdx.files.internal("Cmon2.png"));
	}
}
