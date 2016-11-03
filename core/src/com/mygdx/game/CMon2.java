package com.mygdx.game;

public class CMon2 extends Character{

	public CMon2(float x, float y, float width, float height, int number , int turn) 
	{
		super(x, y, width, height, number , turn);
		hp= Settings.MON2_HP;
		atk = Settings.MON2_ATK;
		atkRange = Settings.MON2_ATKRANGE;
		walk = Settings.MON2_WALK;
		cost = Settings.MON2_COST;
		skill = "-";
		name = "Mon2";
	}


}
