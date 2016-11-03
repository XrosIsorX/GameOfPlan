package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOfPlan extends Game{
	public SpriteBatch batch;
	public BitmapFont font;
	public Character[] selectedp1;
	public Character[] selectedp2;
	
	public void create() { 
		//----------------------------------
		selectedp1 = new Character[Settings.NUMBER_PICKITEM];
		selectedp2 = new Character[Settings.NUMBER_PICKITEM];
		
		CSwordman cswordman = new CSwordman(400 , 500 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.C_SWORDMAN , Settings.TURN_P1);
		selectedp1[0] = cswordman;
		CWizard cwizard = new CWizard(600 , 500 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.C_WIZARD , Settings.TURN_P2);
		selectedp2[0] = cwizard;
		CMon1 cmon1 = new CMon1(400 , 350 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.C_MON1 , Settings.TURN_P1);
		selectedp1[1] = cmon1;
		CMon2 cmon2 = new CMon2(600 , 350 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.C_MON2 , Settings.TURN_P2);
		selectedp2[1] = cmon2;
		Character shealth = new Character(400 , 200 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.S_HEALTH , Settings.TURN_P1);
		selectedp1[2] = shealth;
		Character smana = new Character(600 , 200 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.S_MANA , Settings.TURN_P2);
		selectedp2[2] = smana;
		//----------------------------------
		batch = new SpriteBatch();
		font = new BitmapFont();
		Assets.load();
		//this.setScreen(new PickItemScreen(this));
		this.setScreen(new GameScreen(this , selectedp1 , selectedp2));
	}
	
	public void render() {
		super.render();
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}
