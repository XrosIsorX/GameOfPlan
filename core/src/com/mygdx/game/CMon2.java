package com.mygdx.game;

public class CMon2 extends Character{

	public CMon2(float x, float y, float width, float height, int number) 
	{
		super(x, y, width, height, number);
		hp= Settings.MON2_HP;
		atk = Settings.MON2_ATK;
		atkrank = Settings.MON2_ATKRANK;
		walk = Settings.MON2_WALK;
		cost = Settings.MON2_COST;
		skill = "-";
		name = "Mon2";
	}


}
