package com.mygdx.game;

public class CMon1 extends Character{

	public CMon1(float x, float y, float width, float height, int number , int turn) 
	{
		super(x, y, width, height, number , turn);
		hp= Settings.MON1_HP;
		atk = Settings.MON1_ATK;
		atkRange = Settings.MON1_ATKRANGE;
		walk = Settings.MON1_WALK;
		cost = Settings.MON1_COST;
		skill = "-";
		name = "Mon1";
	}


}
