package com.mygdx.game;

import java.util.LinkedList;
import java.util.List;

public class Swordman extends Character{

	public Swordman(float x, float y, float width, float height, int number , int team) {
		super(x, y, width, height, number, team);
		this.hp = Settings.SWORDMAN_HP;
		this.atk = Settings.SWORDMAN_ATK;
		this.atkRange = Settings.SWORDMAN_ATKRANGE;
		this.walk = Settings.SWORDMAN_WALK;
		this.cost = Settings.SWORDMAN_COST;
		this.skill = Settings.SWORDMAN_SKILL;
		this.name = "Swordman";
	}

	public Swordman(float x, float y, float width, float height, int number, int team ,int hp ,int atk, int atkrange, int walk) {
		super(x, y, width, height, number, team);
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
		if(World.turn == Settings.TURN_P1) {
			List<Character> substitute = new LinkedList<Character>(World.charactersP2);
			for (Character n : substitute) {
				if (n.getCol() <= this.getCol() + 2 && n.getCol() >= this.getCol() - 2 && n.getRow() <= this.getRow() + 2 && n.getCol() >= this.getRow() - 2) {
					n.reduceHP(3);
				}
			}
		}
		if (World.turn == Settings.TURN_P2) {
			List<Character> substitute = new LinkedList<Character>(World.charactersP1);
			for (Character n : substitute) {
				if(n.position.x <= this.position.x + (2 * Settings.BLOCK_SIZE) && n.position.x >= this.position.x - (2 * Settings.BLOCK_SIZE) && n.position.y >= this.position.y + (2 * Settings.BLOCK_SIZE) && n.position.y <= this.position.y + (2 * Settings.BLOCK_SIZE)) {
					n.reduceHP(3);
				}
			}
		}
	}
	
}
