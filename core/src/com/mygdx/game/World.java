package com.mygdx.game;

import java.awt.Font;
import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.math.Rectangle;

public class World {
	private GameOfPlan game;
	private Board board;
	private Mouse mouse;
	public int state = 0;
	public int pick = 0;
	public int turn = Settings.TURN_P1;
	public Rectangle B_Endturnp1;
	public Rectangle B_Endturnp2;
	public List<Character> characters;
	
	public PickObject[] selectedp1;
	public PickObject[] selectedp2;
	public int[] resource;
	
	public World(GameOfPlan game,PickObject[] selectedp1 , PickObject[] selectedp2)
	{
		this.game = game;
		board = new Board();
		mouse = new Mouse();
		this.selectedp1 = selectedp1;
		this.selectedp2 = selectedp2;
		resource = new int[3];
		setButton();
		characters = new LinkedList<Character>();
	}
	
	public void setButton()
	{
		B_Endturnp1 = new Rectangle(Settings.B_ENDTURNP1_X ,Settings.B_ENDTURN_Y , Settings.B_ENDTURN_WIDTH , Settings.B_ENDTURN_HEIGHT);
		B_Endturnp2 = new Rectangle(Settings.B_ENDTURNP2_X ,Settings.B_ENDTURN_Y , Settings.B_ENDTURN_WIDTH , Settings.B_ENDTURN_HEIGHT);
	}
	
	public void update()
	{
		Screenupdate();
		Mouseupdate();
		updateB_Endturn();
	}
	
	public void Screenupdate()
	{
		setItem();
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
	
	public void updateB_Endturn()
	{
		if(Gdx.input.justTouched())
		{
			if(turn == Settings.TURN_P1)
			{
				if(B_Endturnp1.contains(mouse.getX() , mouse.getY()))
				{
					turn = Settings.TURN_P2;
				}
			}
			else if(turn == Settings.TURN_P2)
			{
				if(B_Endturnp2.contains(mouse.getX() , mouse.getY()))
				{
					turn = Settings.TURN_P1;
				}
			}
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
					if(turn == Settings.TURN_P1)
					{
						if(selectedp1[i].bounds.contains(mouse.getX() , mouse.getY()))
						{
							pick = selectedp1[i].name;
							state = Settings.STATE_SPAWN;
						}
					}
					else if( turn == Settings.TURN_P2)
					{
						if(selectedp2[i].bounds.contains(mouse.getX() , mouse.getY()))
						{
							pick = selectedp2[i].name;
							state = Settings.STATE_SPAWN;
						}
					}

				}
			}
			else if(state == Settings.STATE_SPAWN)
			{
				if(mouse.getX() >= Settings.BLOCK_SIZE * Settings.BOARD_PLAYER && mouse.getX() <= Settings.BOARD_WIDTH - (Settings.BOARD_PLAYER * Settings.BLOCK_SIZE))
				{
					if(!hasCharacter())
					{
						checkItemupdate(pick , mouse.getCol() * Settings.BLOCK_SIZE , mouse.getRow() * Settings.BLOCK_SIZE);
						state = Settings.STATE_STILL;
					}
				}
				else
				{
					state = Settings.STATE_STILL;
				}
			}
		}
	}
	
	public boolean hasCharacter()
	{
		for(Character n : characters)
		{
			if(n.bounds.contains(mouse.getX(), mouse.getY()))
			{
				return true;
			}
		}
		return false;
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
		CSwordman swordman = new CSwordman(x,y,Settings.BLOCK_SIZE,Settings.BLOCK_SIZE,Settings.C_SWORDMAN, turn);
		characters.add(swordman);
	}
	
	public void spawnwizard(float x , float y)
	{
		CWizard wizard = new CWizard(x,y,Settings.BLOCK_SIZE,Settings.BLOCK_SIZE,Settings.C_WIZARD, turn);
		characters.add(wizard);
	}
	
	public void spawnmon1(float x , float y)
	{
		CMon1 mon1 = new CMon1(x,y,Settings.BLOCK_SIZE,Settings.BLOCK_SIZE,Settings.C_MON1, turn);
		characters.add(mon1);
	}
	
	public void spawnmon2(float x , float y)
	{
		CMon2 mon2 = new CMon2(x,y,Settings.BLOCK_SIZE,Settings.BLOCK_SIZE,Settings.C_MON2, turn);
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
