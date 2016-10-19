package com.mygdx.game;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;

public class World {
	private GameOfPlan game;
	private Board board;
	private Mouse mouse;
	public PickObject[] selectedp1;
	public PickObject[] selectedp2;
	public int state = 0;
	public int pick = 0;
	public int turn = 0;
	public List<Character> characters;
	
	
	public World(GameOfPlan game,PickObject[] selectedp1 , PickObject[] selectedp2)
	{
		this.game = game;
		board = new Board();
		mouse = new Mouse();
		this.selectedp1 = selectedp1;
		this.selectedp2 = selectedp2;
		
		characters = new LinkedList<Character>();
	}
	
	public void update()
	{
		itemupdate();
	}
	
	public void itemupdate()
	{
		setItem();
		Mouseupdate();
	}
	
	public void setItem()
	{
		for(int i=0;i<Settings.NUMBER_PICKITEM;i++)
		{
			selectedp1[i].position.x = i * Settings.BLOCK_SIZE;
			selectedp1[i].position.y = Settings.BOARD_HEIGHT - ( 2 * Settings.BLOCK_SIZE);
			selectedp1[i].bounds.x = selectedp1[i].position.x;
			selectedp1[i].bounds.y = selectedp1[i].position.y;
		}
		for(int i=0;i<Settings.NUMBER_PICKITEM;i++)
		{
			selectedp2[i].position.x = Settings.BOARD_WIDTH - ( ( 3 - i ) * Settings.BLOCK_SIZE ) ;
			selectedp2[i].position.y = Settings.BOARD_HEIGHT - ( 2 * Settings.BLOCK_SIZE);
			selectedp2[i].bounds.x = selectedp2[i].position.x;
			selectedp2[i].bounds.y = selectedp2[i].position.y;
		}
	}
	
	public void Mouseupdate()
	{
		if(Gdx.input.justTouched())
		{
			if(state == Settings.STATE_STILL)
			{
				for(int i=0 ; i < Settings.NUMBER_PICKITEM ; i++)
				{
					if(selectedp1[i].bounds.contains(Gdx.input.getX() , Settings.BOARD_HEIGHT - Gdx.input.getY()))
					{
						pick = selectedp1[i].name;
						state = Settings.STATE_SPAWN;
					}
					else if(selectedp2[i].bounds.contains(Gdx.input.getX() , Settings.BOARD_HEIGHT - Gdx.input.getY()))
					{
						pick = selectedp2[i].name;
						state = Settings.STATE_SPAWN;
					}
				}
			}
			else if(state == Settings.STATE_SPAWN)
			{
				if(Gdx.input.getX() >= Settings.BLOCK_SIZE * 3 && Gdx.input.getX() <= Settings.BOARD_WIDTH - (3 * Settings.BLOCK_SIZE))
				{
					checkItemupdate(pick , mouse.getCol() * Settings.BLOCK_SIZE , mouse.getRow() * Settings.BLOCK_SIZE);
					state = Settings.STATE_STILL;
				}
			}
		}
	}
	
	public void checkItemupdate(int name , float x ,float y)
	{
		if(name == Settings.C_SWORDMAN)
		{
			spawnswordman(x,y);
		}
		else if(name == Settings.C_WIZARD)
		{
			spawnwizard(x,y);
		}
		else if(name == Settings.C_MON1)
		{
			spawnmon1(x,y);
		}
		else if(name == Settings.C_MON2)
		{
			spawnmon2(x,y);
		}
	}
	
	public void spawnswordman(float x , float y)
	{
		Character swordman = new Character(x,y,Settings.BLOCK_SIZE,Settings.BLOCK_SIZE,Settings.C_SWORDMAN, turn , Settings.SWORDMAN_HP , Settings.SWORDMAN_ATK ,Settings.SWORDMAN_ATKRANK, Settings.SWORDMAN_WALK);
		characters.add(swordman);
	}
	
	public void spawnwizard(float x , float y)
	{
		Character wizard = new Character(x,y,Settings.BLOCK_SIZE,Settings.BLOCK_SIZE,Settings.C_WIZARD, turn , Settings.WIZARD_HP , Settings.WIZARD_ATK ,Settings.WIZARD_ATKRANK, Settings.WIZARD_WALK);
		characters.add(wizard);
	}
	
	public void spawnmon1(float x , float y)
	{
		Character mon1 = new Character(x,y,Settings.BLOCK_SIZE,Settings.BLOCK_SIZE,Settings.C_MON1, turn , Settings.MON1_HP , Settings.MON1_ATK ,Settings.MON1_ATKRANK, Settings.MON1_WALK);
		characters.add(mon1);
	}
	
	public void spawnmon2(float x , float y)
	{
		Character mon2 = new Character(x,y,Settings.BLOCK_SIZE,Settings.BLOCK_SIZE,Settings.C_MON2, turn , Settings.MON2_HP , Settings.MON2_ATK ,Settings.MON2_ATKRANK, Settings.MON2_WALK);
		characters.add(mon2);
	}
	
	public Board getBoard()
	{
		return board;
	}
	
	public Mouse getMouse()
	{
		return mouse;
	}
}
