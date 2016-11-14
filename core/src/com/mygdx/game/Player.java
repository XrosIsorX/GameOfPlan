package com.mygdx.game;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.math.Rectangle;

public class Player {
	public Rectangle buttonEndTurn;
	public Rectangle buttonSkill;
	//public List<Character> towers;
	public List<Character> characters;
	public List<Character> selectedCharacters;
	public List<PassiveSkill> selectedPassiveSkills;
	
	public World world;
	
	public int boardArea; 
	
	public int resource = 4;
	
	public Player(List<Character> selectedCharacters, List<PassiveSkill> selectedPassiveSkills, World world, int boardArea) {
		this.selectedCharacters = selectedCharacters;
		this.selectedPassiveSkills = selectedPassiveSkills;
		this.characters = new LinkedList<Character>();
		//this.towers = new LinkedList<Character>();
		this.boardArea = boardArea;
		
		this.world = world;
	}
	
	public void createButtonSkill(float x, float y) {
		buttonSkill = new Rectangle(x, y, Settings.BUTTON_SKILL_WIDTH, Settings.BUTTON_SKILL_HEIGHT);
	}
	
	public void createButtonEndTurn(float x, float y) {
		buttonEndTurn = new Rectangle(x, y, Settings.BUTTON_ENDTURN_WIDTH, Settings.BUTTON_ENDTURN_HEIGHT);
	}
	
	public void clickButtonEndTurn() {
		collectGrass();
		resetAllUsedCharacter();
	}
	
	public void resetAllUsedCharacter() {
		for (Character n : characters) {
			n.isUsed = false;
		}
	}
	
	public void collectGrass() {
		for (Character n : characters) {
			int col = n.getCol() - Settings.BOARD_PLAYER;
			int row = n.getRow();
			if (world.board.map[row][col] == Settings.GRASS) {
				resource++;
			}
		}
	}
	
	public void clickButtonSkill(Character pick) {
			pick.skill();
			pick.isUsed = true;
	}
	
	public void spawnCharacter(float x, float y) {
		checkItemupdate(world.pick.number, world.mouse.getCol() * Settings.BLOCK_SIZE, world.mouse.getRow() * Settings.BLOCK_SIZE);
		disableSpawnChampion(world.pick);
		resource -= world.pick.cost;
	}
	
	public void attack(float x, float y) {
		if (world.enemy.canGetCharacters(x, y)) {
			Character target = world.enemy.getCharacters(x, y);
			target.reduceHP(world.pick.atk);
			world.pick.isUsed = true;
		}
	}
	
	public void walk(float x, float y) {
		float newX = (int)(x / Settings.BLOCK_SIZE) * Settings.BLOCK_SIZE;
		float newY = (int)(y / Settings.BLOCK_SIZE) * Settings.BLOCK_SIZE;
		world.pick.setPosition(newX, newY);
		world.pick.isUsed =true;
	}
	
	public void checkItemupdate(int number, float x ,float y) {
		if (number == Settings.SWORDMAN_NUMBER) {
			spawnSwordman(x,y);
		} else if (number == Settings.WIZARD_NUMBER) {
			spawnWizard(x,y);
		} else if (number == Settings.MEEP_NUMBER) {
			spawnMeep(x,y);
		} else if (number == Settings.SKULL_NUMBER) {
			spawnSkull(x,y);
		}
	}
	
	public void spawnSwordman(float x, float y) {
		Swordman swordman = new Swordman(x, y, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, world.turn);
		characters.add(swordman);
	}
	
	public void spawnWizard(float x, float y) {
		Wizard wizard = new Wizard(x, y, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, world.turn);
		characters.add(wizard);
	}
	
	public void spawnMeep(float x, float y) {
		Meep meep = new Meep(x, y, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, world.turn);
		characters.add(meep);
	}
	
	public void spawnSkull(float x, float y) {
		Skull skull = new Skull(x, y, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, world.turn);
		characters.add(skull);
	}
	
	public void createNexus(float x, float y, int team, int number) {
		Nexus nexus = new Nexus(x, y, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, team, number);
		characters.add(nexus);
	}
	
	public void disableSpawnChampion(Character character) {
		if (character.number >= Settings.WIZARD_NUMBER && character.number < Settings.MEEP_NUMBER) {
			character.isUsed = true;
		}
	}
	
	public boolean canGetCharacters(float x, float y) {
		for (Character n : characters) {
			if (n.bounds.contains(x, y)) {
				return true;
			}
		}
		return false;
	}
	
	public Character getCharacters(float x, float y) {
		for (Character n : characters) {
			if (n.bounds.contains(x, y)) {
				return n;
			}
		}
		return null;
	}
	
	public boolean canGetSelectedCharacters(float x, float y) {
		for (Character n : selectedCharacters) {
			if (n.bounds.contains(x, y)) {
				return true;
			}
		}
		return false;
	}
	
	public Character getSelectedCharacters(float x, float y) {
		for (Character n : selectedCharacters) {
			if (n.bounds.contains(x, y)) {
				return n;
			}
		}
		return null;
	}
	
}
