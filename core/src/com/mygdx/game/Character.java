package com.mygdx.game;

public class Character extends PickObject{
	int team =0;
	int hp =0;
	int atk =0;
	int atkrank =0;
	int walk =0;
	
	public Character(float x , float y , float width , float height , int name , int team )
	{
		super(x , y , width, height , name);
		this.team = team;
	}

	public Character(float x, float y, float width, float height, int name , int team ,int hp ,int atk , int atkrank , int walk) {
		super(x, y, width, height, name);
		this.team = team;
		this.hp = hp;
		this.atk = atk;
		this.atkrank = atk;
		this.walk = walk;
	}

	
}
