package com.mygdx.game;

public class CSwordman extends Character{

	public CSwordman(float x, float y, float width, float height, int number) 
	{
		super(x, y, width, height, number);
		hp= Settings.SWORDMAN_HP;
		atk = Settings.SWORDMAN_ATK;
		atkrank = Settings.SWORDMAN_ATKRANK;
		walk = Settings.SWORDMAN_WALK;
		cost = Settings.SWORDMAN_COST;
		skill = "deal 5 damage around\n itself for 2 blocks";
		name = "Swordman";
	}
	
	@Override
	public void skill()
	{
		
	}
	

}
