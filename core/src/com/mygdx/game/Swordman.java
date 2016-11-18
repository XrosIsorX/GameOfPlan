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
				if (n.getCol() <= this.getCol() + 2 && n.getCol() >= this.getCol() - 2 && n.getRow() <= this.getRow() + 2 && n.getCol() >= this.getRow() - 2) {
					n.changeHp(-2);
				}
			}
//			for (int i = -1 * skillRange; i <= this.getRow() + skillRange; i++) {
//				for (int j = skillRange + this.getCol(); j >= this.getCol() - skillRange; j--) {
//					Animation slash = new Animation(this.getColX() + (i * Settings.BLOCK_SIZE), j * Settings.BLOCK_SIZE, 200, Settings.ANIMATION_SLASH);
//					System.out.println((this.getColX() + i * Settings.BLOCK_SIZE) + " " + (j * Settings.BLOCK_SIZE));
//					World.animations.add(slash);
//				}
//			}
			changeMana(-1 * Settings.SWORDMAN_SKILLCOST);
		}
		World.state = Settings.STATE_STILL;
	}
}
