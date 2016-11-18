package com.mygdx.game;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.math.Rectangle;

public class PickItemScreenPlayer {
	public List<Character> selectedCharacters;
	public List<PassiveSkill> selectedPassiveSkills;
	Rectangle buttonSelect;
	float selectdItemX;
	int team = 0;
	
	public PickItemScreenPlayer(int team) {
		if (team == Settings.TURN_P1) {
			selectdItemX = Settings.SELECTEDITEMP1_X;
		} else if (team == Settings.TURN_P2) {
			selectdItemX = Settings.SELECTEDITEMP2_X;
		}
		this.team = team;
		selectedCharacters = new LinkedList<Character>();
		selectedPassiveSkills = new LinkedList<PassiveSkill>();
	}
	
	public void createButtonSelect(float x, float y) {
		buttonSelect = new Rectangle(x, y, Settings.BUTTON_SELECT_WIDTH, Settings.BUTTON_SELECT_HEIGHT);
	}
	
	public void checkSelectedItemAdd(int number, float x, float y) {
		if (number == Settings.SWORDMAN_NUMBER) {
			addSwordman(x, y);
		} else if (number == Settings.WIZARD_NUMBER) {
			addWizard(x, y);
		} else if (number == Settings.MEEP_NUMBER) {
			addMeep(x, y);
		} else if (number == Settings.SKULL_NUMBER) {
			addSkull(x, y);
		} else if (number == Settings.HPRESTORE_NUMBER) {
			addHpRestore(x, y);
		} else if (number == Settings.MANARESTORE_NUMBER) {
			addManaRestore(x, y);
		}
	}
	
	public void addSwordman(float x, float y) {
		Swordman swordman = new Swordman(x, y, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, team);
		selectedCharacters.add(swordman);
	}
	
	public void addWizard(float x, float y) {
		Wizard wizard = new Wizard(x, y, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, team);
		selectedCharacters.add(wizard);
	}
	
	public void addMeep(float x, float y) {
		Meep meep = new Meep(x, y, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, team);
		selectedCharacters.add(meep);
	}
	
	public void addSkull(float x, float y) {
		Skull skull = new Skull(x, y, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, team);
		selectedCharacters.add(skull);
	}
	
	public void addHpRestore(float x, float y) {
		HpRestore hpRestore = new HpRestore(x, y, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, team);
		selectedPassiveSkills.add(hpRestore);
	}
	
	public void addManaRestore(float x, float y) {
		ManaRestore manaRestore = new ManaRestore(x, y, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, team);
		selectedPassiveSkills.add(manaRestore);
	}
}
