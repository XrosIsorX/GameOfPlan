package com.mygdx.game;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOfPlan extends Game {
	public SpriteBatch batch;
	public BitmapFont font;
	public List<Character> selectedP1;
	public List<Character> selectedP2;
	
	public void create() { 
		//----------------------------------
		selectedP1 = new LinkedList<Character>();
		selectedP2 = new LinkedList<Character>();
		
		Swordman swordman = new Swordman(400 , 500 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.SWORDMAN_NUMBER , Settings.TURN_P1);
		selectedP1.add(swordman);
		Wizard wizard = new Wizard(600 , 500 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.WIZARD_NUMBER , Settings.TURN_P2);
		selectedP2.add(wizard);
		Meep meep = new Meep(400 , 350 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.MEEP_NUMBER , Settings.TURN_P1);
		selectedP1.add(meep);
		Skull skull = new Skull(600 , 350 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.SKULL_NUMBER , Settings.TURN_P2);
		selectedP2.add(skull);
		Character healPassive = new Character(400 , 200 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.HPRESTORE_NUMBER, Settings.TURN_P1);
		selectedP1.add(healPassive);
		Character manaPassive = new Character(600 , 200 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.MANARESTORE_NUMBER , Settings.TURN_P2);
		selectedP2.add(manaPassive);
		//----------------------------------
		batch = new SpriteBatch();
		font = new BitmapFont();
		Assets.load();
		//this.setScreen(new PickItemScreen(this));
		this.setScreen(new GameScreen(this, selectedP1, selectedP2));
	}
	
	public void render() {
		super.render();
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}
