package com.mygdx.game;

import java.util.LinkedList;
import java.util.List;

public class CSwordman extends Character{

	public CSwordman(float x, float y, float width, float height, int number , int turn) 
	{
		super(x, y, width, height, number , turn);
		hp= Settings.SWORDMAN_HP;
		atk = Settings.SWORDMAN_ATK;
		atkRange = Settings.SWORDMAN_ATKRANGE;
		walk = Settings.SWORDMAN_WALK;
		cost = Settings.SWORDMAN_COST;
		skill = Settings.SWORDMAN_SKILL;
		name = "Swordman";
	}
	
	@Override
	public void skill()
	{
		if(World.turn == Settings.TURN_P1)
		{
			List<Character> substitute = new LinkedList<Character>(World.charactersp2);
			for(Character n : substitute)
			{
				if(n.getCol() <= this.getCol() + 2 && n.getCol() >= this.getCol() - 2 && n.getRow() <= this.getRow() + 2 && n.getCol() >= this.getRow() - 2)
				{
					n.reduceHP(3);
				}
			}
		}
		if(World.turn == Settings.TURN_P2)
		{
			List<Character> substitute = new LinkedList<Character>(World.charactersp1);
			for(Character n : substitute)
			{
				if(n.position.x <= this.position.x + (2 * Settings.BLOCK_SIZE) && n.position.x >= this.position.x - (2 * Settings.BLOCK_SIZE) && n.position.y >= this.position.y + (2 * Settings.BLOCK_SIZE) && n.position.y <= this.position.y + (2 * Settings.BLOCK_SIZE))
				{
					n.reduceHP(3);
				}
			}
		}
		
	}
	

}
