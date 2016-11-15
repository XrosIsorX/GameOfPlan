package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
	static Texture ground;
	static Texture grass;
	static Texture river;
	
	static Texture pickBoard;
	static Texture pickCharacter;
	
	static Texture nexusP1;
	static Texture nexusP2;
	
	static Texture pickitemscreen;
	static Texture turnP1Screen;
	static Texture turnP2Screen;
	static Texture slotBlock;
	
	static Texture buttonSelect;
	static Texture buttonStartGame;
	static Texture buttonEndTurn;
	static Texture buttonSkill;
	
	static Texture manaRestore;
	static Texture hpRestore;
	
	static Texture wizard;
	static Texture swordman;
	static Texture meep;
	static Texture skull;
	
	static Texture attack;
	static Texture slash;
	
	public static void load()
	{
		ground = new Texture(Gdx.files.internal("ground.png"));
		grass = new Texture(Gdx.files.internal("grass.png"));
		river = new Texture(Gdx.files.internal("river.png"));
		
		nexusP1 = new Texture(Gdx.files.internal("nexusP1.png"));
		nexusP2 = new Texture(Gdx.files.internal("nexusP2.png"));
		
		pickBoard = new Texture(Gdx.files.internal("pickboard.png"));
		pickCharacter = new Texture(Gdx.files.internal("pickCharacter.png"));

		pickitemscreen = new Texture(Gdx.files.internal("pickitemScreen.png"));
		turnP1Screen = new Texture(Gdx.files.internal("turnP1Screen.png"));
		turnP2Screen = new Texture(Gdx.files.internal("turnP2Screen.png"));
		slotBlock = new Texture(Gdx.files.internal("slotBlock.png"));
		
		buttonSelect = new Texture(Gdx.files.internal("buttonSelect.png"));
		buttonStartGame = new Texture(Gdx.files.internal("buttonStartGame.png"));
		buttonEndTurn = new Texture(Gdx.files.internal("buttonEndTurn.png"));
		buttonSkill = new Texture(Gdx.files.internal("buttonSkill.png"));
		
		manaRestore = new Texture(Gdx.files.internal("manaRestore.png"));
		hpRestore = new Texture(Gdx.files.internal("hpRestore.png"));
		wizard = new Texture(Gdx.files.internal("wizard.png"));
		swordman = new Texture(Gdx.files.internal("swordman.png"));
		meep = new Texture(Gdx.files.internal("meep.png"));
		skull = new Texture(Gdx.files.internal("skull.png"));
		
		attack = new Texture(Gdx.files.internal("attack.png"));
		slash= new Texture(Gdx.files.internal("slash.png"));
	}
}
