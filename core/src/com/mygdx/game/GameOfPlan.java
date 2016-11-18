package com.mygdx.game;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOfPlan extends Game {
	public SpriteBatch batch;
	public BitmapFont font;
	public List<Character> selectedCharactersP1;
	public List<PassiveSkill> selectedPassiveSkillsP1;
	public List<Character> selectedCharactersP2;
	public List<PassiveSkill> selectedPassiveSkillsP2;
	
	public void create() { 
		//----------------------------------
		selectedCharactersP1 = new LinkedList<Character>();
		selectedPassiveSkillsP1 = new LinkedList<PassiveSkill>();
		selectedCharactersP2 = new LinkedList<Character>();
		selectedPassiveSkillsP2 = new LinkedList<PassiveSkill>();
		
		Swordman swordman = new Swordman(400 , 500 , Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, Settings.TURN_P1);
		selectedCharactersP1.add(swordman);
		Wizard wizard = new Wizard(600 , 500 , Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, Settings.TURN_P2);
		selectedCharactersP2.add(wizard);
		Meep meep = new Meep(400 , 350 , Settings.BLOCK_SIZE, Settings.BLOCK_SIZE , Settings.TURN_P1);
		selectedCharactersP1.add(meep);
		Skull skull = new Skull(600 , 350 , Settings.BLOCK_SIZE, Settings.BLOCK_SIZE , Settings.TURN_P2);
		selectedCharactersP2.add(skull);
		HpRestore hpRestore = new HpRestore(400 , 200 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE, Settings.TURN_P1);
		selectedPassiveSkillsP1.add(hpRestore);
		ManaRestore manaRestore = new ManaRestore(600 , 200 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE, Settings.TURN_P2);
		selectedPassiveSkillsP2.add(manaRestore);
		//----------------------------------
		batch = new SpriteBatch();
		font = new BitmapFont();
		Assets.load();
		this.setScreen(new PickItemScreen(this));
		//this.setScreen(new GameScreen(this, selectedCharactersP1, selectedPassiveSkillsP1, selectedCharactersP2, selectedPassiveSkillsP2));
	}
	
	public void render() {
		super.render();
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}
