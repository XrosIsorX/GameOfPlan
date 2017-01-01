package com.mygdx.game;

import java.util.LinkedList;
import java.util.List;

public class Swordman extends Character{

	public Swordman(float x, float y, float width, float height, int team) {
		super(x, y, width, height, team);
		this.number = Settings.SWORDMAN_NUMBER;
		this.hp = Settings.SWORDMAN_HP;
		this.maxHp = Settings.SWORDMAN_HP;
		this.mana = Settings.SWORDMAN_MANA;
		this.maxMana = Settings.SWORDMAN_MANA;
		this.atk = Settings.SWORDMAN_ATK;
		this.atkRange = Settings.SWORDMAN_ATKRANGE;
		this.walk = Settings.SWORDMAN_WALK;
		this.cost = Settings.SWORDMAN_COST;
		this.skillDetail = Settings.SWORDMAN_SKILL;
		this.skillRange = Settings.SWORDMAN_SKILLRANGE;
		this.name = "Swordman";
	}
	
	@Override
	public void skill() {
		if (this.mana >= Settings.SWORDMAN_SKILLCOST) {
			List<Character> substitute = new LinkedList<Character>(World.enemy.characters);
			for (Character n : substitute) {
				if (n.getCol() <= this.getCol() + Settings.SWORDMAN_SKILLRANGE && n.getCol() >= this.getCol() - Settings.SWORDMAN_SKILLRANGE && n.getRow() <= this.getRow() + Settings.SWORDMAN_SKILLRANGE && n.getRow() >= this.getRow() - Settings.SWORDMAN_SKILLRANGE) {
					n.changeHp(-2);
				}
			}
			for (int i = this.getRow() - Settings.SWORDMAN_SKILLRANGE; i <= this.getRow() + Settings.SWORDMAN_SKILLRANGE; i++) {
				for (int j = this.getCol() - Settings.SWORDMAN_SKILLRANGE; j <= this.getCol() + Settings.SWORDMAN_SKILLRANGE; j++) {
					if (i != this.getRow() || j != this.getCol()) {
						Animation slash = new Animation(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, 200, Settings.ANIMATION_SLASH);
						World.animations.add(slash);
					}
				}
			}
			changeMana(-1 * Settings.SWORDMAN_SKILLCOST);
		}
		World.state = Settings.STATE_STILL;
	}
}
