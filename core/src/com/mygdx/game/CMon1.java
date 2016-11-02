package com.mygdx.game;

public class CMon1 extends Character{

	public CMon1(float x, float y, float width, float height, int number) 
	{
		super(x, y, width, height, number);
		hp= Settings.MON1_HP;
		atk = Settings.MON1_ATK;
		atkrank = Settings.MON1_ATKRANK;
		walk = Settings.MON1_WALK;
		cost = Settings.MON1_COST;
		skill = "-";
		name = "Mon1";
	}


}
