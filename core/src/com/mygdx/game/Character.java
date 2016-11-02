package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class Character extends GameObject{
	int number = 0;
	int team = 0;
	int hp = 0;
	int atk = 0;
	int atkrank = 0;
	int walk = 0;
	int cost = 0;
	boolean isused = false;
	String skill;
	String name;
	
	public void skill()
	{
		
	}
	
	public Character(float x , float y , float width , float height , int number)
	{
		super(x , y , width, height);
		this.number = number;
	}

	public Character(float x, float y, float width, float height, int number ,int hp ,int atk , int atkrank , int walk) {
		super(x, y, width, height);
		this.hp = hp;
		this.atk = atk;
		this.atkrank = atk;
		this.walk = walk;
	}
	
	public int getRow()
	{
		return (int)(position.y/Settings.BLOCK_SIZE);
	}
	
	public int getCol()
	{
		return (int)(position.x/Settings.BLOCK_SIZE);
	}
}
