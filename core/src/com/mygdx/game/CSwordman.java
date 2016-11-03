package com.mygdx.game;

public class CSwordman extends Character{

	public CSwordman(float x, float y, float width, float height, int number , int turn) 
	{
		super(x, y, width, height, number , turn);
		hp= Settings.SWORDMAN_HP;
		atk = Settings.SWORDMAN_ATK;
		atkRange = Settings.SWORDMAN_ATKRANGE;
		walk = Settings.SWORDMAN_WALK;
		cost = Settings.SWORDMAN_COST;
		skill = "deal 5 damage around\n itself for 2 blocks";
		name = "Swordman";
	}
	
	@Override
	public void skill()
	{
		if(World.turn == Settings.TURN_P1)
		{
			for(Character n : World.charactersp2)
			{
				if(n.getCol() <= this.getCol() + 2 && n.getCol() >= this.getCol() - 2 && n.getRow() <= this.getRow() + 2 && n.getCol() >= this.getRow() - 2)
				{System.out.println(World.turn);
					n.reduceHP(5);
				}
			}
		}
		if(World.turn == Settings.TURN_P2)
		{
			for(Character n : World.charactersp1)
			{
				if(n.position.x <= this.position.x + (2 * Settings.BLOCK_SIZE) && n.position.x >= this.position.x - (2 * Settings.BLOCK_SIZE) && n.position.y >= this.position.y + (2 * Settings.BLOCK_SIZE) && n.position.y <= this.position.y + (2 * Settings.BLOCK_SIZE))
				{
					n.reduceHP(5);
				}
			}
		}
		
	}
	

}
