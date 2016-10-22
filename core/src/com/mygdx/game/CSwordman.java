package com.mygdx.game;

public class CSwordman extends Character{

	public CSwordman(float x, float y, float width, float height, int name, int team) 
	{
		super(x, y, width, height, name, team);
		hp= Settings.SWORDMAN_HP;
		atk = Settings.SWORDMAN_ATK;
		atkrank = Settings.SWORDMAN_ATKRANK;
		walk = Settings.SWORDMAN_WALK;
		cost = Settings.SWORDMAN_COST;
	}
	

}
