package com.mygdx.game;

public class CMon2 extends Character{

	public CMon2(float x, float y, float width, float height, int name, int team) 
	{
		super(x, y, width, height, name, team);
		hp= Settings.MON2_HP;
		atk = Settings.MON2_ATK;
		atkrank = Settings.MON2_ATKRANK;
		walk = Settings.MON2_WALK;
	}


}
