package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOfPlan extends Game{
	public SpriteBatch batch;
	public BitmapFont font;
	public PickObject[] selectedp1;
	public PickObject[] selectedp2;
	
	public void create() { 
		//----------------------------------
		selectedp1 = new PickObject[Settings.NUMBER_PICKITEM];
		selectedp2 = new PickObject[Settings.NUMBER_PICKITEM];
		
		PickObject cswordman = new PickObject(400 , 500 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.C_SWORDMAN);
		selectedp1[0] = cswordman;
		PickObject cwizard = new PickObject(600 , 500 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.C_WIZARD);
		selectedp2[0] = cwizard;
		PickObject cmon1 = new PickObject(400 , 350 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.C_MON1);
		selectedp1[1] = cmon1;
		PickObject cmon2 = new PickObject(600 , 350 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.C_MON2);
		selectedp2[1] = cmon2;
		PickObject shealth = new PickObject(400 , 200 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.S_HEALTH);
		selectedp1[2] = shealth;
		PickObject smana = new PickObject(600 , 200 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.S_MANA);
		selectedp2[2] = smana;
		//----------------------------------
		batch = new SpriteBatch();
		font = new BitmapFont();
		Assets.load();
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
