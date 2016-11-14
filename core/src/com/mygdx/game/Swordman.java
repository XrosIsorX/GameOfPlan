package com.mygdx.game;

import java.util.LinkedList;
import java.util.List;

public class Swordman extends Character{

	public Swordman(float x, float y, float width, float height, int team) {
		super(x, y, width, height, team);
		this.number = Settings.SWORDMAN_NUMBER;
		this.hp = Settings.SWORDMAN_HP;
		this.atk = Settings.SWORDMAN_ATK;
		this.atkRange = Settings.SWORDMAN_ATKRANGE;
		this.walk = Settings.SWORDMAN_WALK;
		this.cost = Settings.SWORDMAN_COST;
		this.skill = Settings.SWORDMAN_SKILL;
		this.name = "Swordman";
	}

	public Swordman(float x, float y, float width, float height, int team ,int hp ,int atk, int atkrange, int walk) {
		super(x, y, width, height, team);
		this.number = Settings.SWORDMAN_NUMBER;
		this.hp = hp;
		this.atk = atk;
		this.atkRange = atkrange;
		this.walk = walk;
		this.cost = Settings.SWORDMAN_COST;
		this.skill = Settings.SWORDMAN_SKILL;
		this.name = "Swordman";
	}
	
	@Override
	public void skill() {
		List<Character> substitute = new LinkedList<Character>(World.enemy.characters);
		for (Character n : substitute) {
			if (n.getCol() <= this.getCol() + 2 && n.getCol() >= this.getCol() - 2 && n.getRow() <= this.getRow() + 2 && n.getCol() >= this.getRow() - 2) {
				n.reduceHP(2);
			}
		}
	}
	
}
