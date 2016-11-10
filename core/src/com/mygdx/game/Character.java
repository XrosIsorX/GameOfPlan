package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class Character extends GameObject {
	int skillRange = 0;
	int number = 0;
	int team = 0;
	int hp = 0;
	int atk = 0;
	int atkRange = 0;
	int walk = 0;
	int cost = 0;
	boolean isUsed = false;
	String skill;
	String name;
	
	public Character(float x, float y, float width, float height, int number) {
		super(x, y, width, height);
		this.number = number;
	}
	
	public Character(float x, float y, float width, float height, int number, int team) {
		super(x, y, width, height);
		this.number = number;
		this.team = team;
	}

	public Character(float x, float y, float width, float height, int number, int team ,int hp ,int atk, int atkrange, int walk) {
		super(x, y, width, height);
		this.hp = hp;
		this.atk = atk;
		this.atkRange = atkrange;
		this.walk = walk;
		this.team = team;
	}
	
	public void skill() {
		
	}
	
	public void reduceHP(int reduce) {
		hp -= reduce;
		if (hp <= 0) {
			if (team == Settings.TURN_P1) {
				World.charactersP1.remove(this);
			} else if (team == Settings.TURN_P2)
			{
				World.charactersP2.remove(this);
			}
		}
	}
	
	public void setPosition(float x, float y) {
		position.x = x;
		position.y = y;
		bounds.x = x;
		bounds.y = y;
	}
	
	public boolean isUsed() {
		return isUsed;
	}
	
	public int getRow() {
		return (int)(position.y / Settings.BLOCK_SIZE);
	}
	
	public int getCol() {
		return (int)(position.x / Settings.BLOCK_SIZE);
	}
}
