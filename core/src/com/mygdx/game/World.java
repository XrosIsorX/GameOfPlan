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
	public Mouse mouse;
	public static int state = 0;
	public static int turn = Settings.TURN_P1;
	
	public Rectangle B_Endturnp1;
	public Rectangle B_Endturnp2;
	public Rectangle b_SkillP1;
	public Rectangle b_SkillP2;
	
	public static List<Character> towersP1;
	public static List<Character> towersP2;
	
	public static List<Character> charactersp1;
	public static List<Character> charactersp2;
	
	public Character pick;
	public static int skillSpawn;
	public Character[] selectedp1;
	public Character[] selectedp2;
	public int[] resource;
	
	public World(GameOfPlan game,Character[] selectedp1 , Character[] selectedp2)
	{
		this.game = game;
		board = new Board();
		mouse = new Mouse();
		this.selectedp1 = selectedp1;
		this.selectedp2 = selectedp2;
		resource = new int[3];
		setButton();
		charactersp1 = new LinkedList<Character>();
		charactersp2 = new LinkedList<Character>();
		towersP1 = new LinkedList<Character>();
		towersP2 = new LinkedList<Character>();
		setTower();
	}

	public void setButton()
	{
		B_Endturnp1 = new Rectangle(Settings.B_ENDTURNP1_X ,Settings.B_ENDTURN_Y , Settings.B_ENDTURN_WIDTH , Settings.B_ENDTURN_HEIGHT);
		B_Endturnp2 = new Rectangle(Settings.B_ENDTURNP2_X ,Settings.B_ENDTURN_Y , Settings.B_ENDTURN_WIDTH , Settings.B_ENDTURN_HEIGHT);
		b_SkillP1 = new Rectangle(Settings.B_SKILLBUTTONP1_X , Settings.B_SKILLBUTTON_Y , Settings.B_SKILL_WIDTH , Settings.B_SKILL_HEIGHT);
		b_SkillP2 = new Rectangle(Settings.B_SKILLBUTTONP2_X , Settings.B_SKILLBUTTON_Y , Settings.B_SKILL_WIDTH , Settings.B_SKILL_HEIGHT);
	}
	
	public void update()
	{
		updateB_Skill();
		Screenupdate();
		Mouseupdate();
		updateB_Endturn();
	}
	
	public void Screenupdate()
	{
		setItem();
	}
	
	public void setPosition(Character n , float x , float y)
	{
		n.position.x = x;
		n.position.y = y;
		n.bounds.x = x;
		n.bounds.y = y;
	}
	
	public void setTower()
	{
		Nexus nexusP1 = new Nexus(8 * Settings.BLOCK_SIZE , Settings.BOARD_HEIGHT - Settings.BLOCK_SIZE , Settings.BLOCK_SIZE , Settings.BLOCK_SIZE , Settings.C_NEXUSP1 , Settings.TURN_P1);
		towersP1.add(nexusP1);
		Nexus nexusP2 = new Nexus(8 * Settings.BLOCK_SIZE , 0 , Settings.BLOCK_SIZE , Settings.BLOCK_SIZE , Settings.C_NEXUSP2 , Settings.TURN_P1);
		towersP2.add(nexusP2);
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
					collectGrass(charactersp1);
					for(Character n : charactersp1)
					{
						n.isUsed = false;
					}
					turn = Settings.TURN_P2;
				}
			}
			else if(turn == Settings.TURN_P2)
			{
				if(B_Endturnp2.contains(mouse.getX() , mouse.getY()))
				{
					collectGrass(charactersp2);
					for(Character n : charactersp2)
					{
						n.isUsed = false;
					}
					turn = Settings.TURN_P1;
				}
			}
		}
	}
	
	public void collectGrass(List<Character> characters)
	{
		for(Character n : characters)
		{
			int col = n.getCol() - Settings.BOARD_PLAYER;
			int row = n.getRow();
			if(board.map[row][col] == Settings.F_GRASS)
			{
				resource[turn]++;
			}
		}
	}
	
	public void updateB_Skill()
	{
		if(state == Settings.STATE_ACTION)
		{
			if(Gdx.input.justTouched())
			{
				if(turn == Settings.TURN_P1)
				{
					if(b_SkillP1.contains(mouse.getX() , mouse.getY()))
					{
						pick.skill();
						pick.isUsed = true;
					}
				}
				else if(turn == Settings.TURN_P2)
				{
					if(b_SkillP2.contains(mouse.getX() , mouse.getY()))
					{
						pick.skill();
						pick.isUsed = true;
					}
				}

			}
		}
	}
	
	public void Mouseupdate()
	{	//System.out.println(state);
		if(Gdx.input.justTouched())
		{
			if(state == Settings.STATE_STILL)
			{
				if(turn == Settings.TURN_P1)
				{
					for(Character n : charactersp1)
					{
						if(n.bounds.contains(mouse.getX() , mouse.getY()))
						{
							pick = n;
							if(n.isUsed == false)
							{
								state = Settings.STATE_ACTION;
							}
						}					
					}
					//getCharacterOnTarget(charactersp1 , mouse.getX() , mouse.getY());		

				}
				else if(turn == Settings.TURN_P2)
				{
					for(Character n : charactersp2)
					{
						if(n.bounds.contains(mouse.getX() , mouse.getY()))
						{
							pick = n;
							if(n.isUsed == false)
							{
								state = Settings.STATE_ACTION;
							}
						}					
					}
					//getCharacterOnTarget(charactersp2 , mouse.getX() , mouse.getY());
					
				}
				for(int i=0 ; i < Settings.NUMBER_PICKITEM ; i++)
				{
					if(turn == Settings.TURN_P1)
					{
						if(selectedp1[i].bounds.contains(mouse.getX() , mouse.getY()))
						{
							pick = selectedp1[i];
							if(pick.isUsed == false && pick.cost <= resource[turn])
							{
								state = Settings.STATE_SPAWN;
							}
						}
					}
					else if( turn == Settings.TURN_P2)
					{
						if(selectedp2[i].bounds.contains(mouse.getX() , mouse.getY()))
						{
							pick = selectedp2[i];
							if(pick.isUsed == false && pick.cost <= resource[turn])
							{
								state = Settings.STATE_SPAWN;
							}
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
						if(turn == Settings.TURN_P1)
						{
							if(mouse.getY() > Settings.BLOCK_SIZE * 6)
							{
								checkItemupdate(pick.number , mouse.getCol() * Settings.BLOCK_SIZE , mouse.getRow() * Settings.BLOCK_SIZE);
								disableSpawnChampion(pick);
								resource[turn] -= pick.cost;
								state = Settings.STATE_STILL;
							}
						}
						else if(turn == Settings.TURN_P2)
						{
							if(mouse.getY() < Settings.BLOCK_SIZE * 5)
							{
								checkItemupdate(pick.number , mouse.getCol() * Settings.BLOCK_SIZE , mouse.getRow() * Settings.BLOCK_SIZE);
								disableSpawnChampion(pick);
								resource[turn] -= pick.cost;
								state = Settings.STATE_STILL;
							}
						}
					}
				}
				else
				{
					state = Settings.STATE_STILL;
				}
			}
			else if(state == Settings.STATE_ACTION)
			{
				if(mouse.getX() >= Settings.BLOCK_SIZE * Settings.BOARD_PLAYER && mouse.getX() <= Settings.BOARD_WIDTH - (Settings.BOARD_PLAYER * Settings.BLOCK_SIZE))
				{
					if(hasCharacter())
					{
						if(isInRange(pick.atkRange))
						{
							if(turn == Settings.TURN_P1)
							{
								for(Character n : charactersp2)
								{
									if(n.bounds.contains(mouse.getX(), mouse.getY()))
									{
										n.reduceHP(pick.atk);
										pick.isUsed = true;
									}
								}
								for(Character n : towersP2)
								{
									if(n.bounds.contains(mouse.getX(), mouse.getY()))
									{
										n.reduceHP(pick.atk);
										pick.isUsed = true;
									}
								}
							}
							else if(turn == Settings.TURN_P2)
							{
								for(Character n : charactersp1)
								{
									if(n.bounds.contains(mouse.getX(), mouse.getY()))
									{
										n.reduceHP(pick.atk);
										pick.isUsed = true;
									}
								}
								for(Character n : towersP1)
								{
									if(n.bounds.contains(mouse.getX(), mouse.getY()))
									{
										n.reduceHP(pick.atk);
										pick.isUsed = true;
									}
								}
							}
						}
					}
					else
					{
						if(isInRange(pick.walk))
						{
							setPosition(pick , mouse.getColX() , mouse.getRowY());
							pick.isUsed =true;
						}
					}
					state = Settings.STATE_STILL;
				}
				else
				{
					state = Settings.STATE_STILL;
				}
			}
			else if(state == Settings.STATE_SKILLSPAWN)
			{
				if(isInRange(pick.skillRange))
				{
					if(mouse.getX() >= Settings.BLOCK_SIZE * Settings.BOARD_PLAYER && mouse.getX() <= Settings.BOARD_WIDTH - (Settings.BOARD_PLAYER * Settings.BLOCK_SIZE))
					{
						if(!hasCharacter())
						{
							checkItemupdate(skillSpawn , mouse.getColX(), mouse.getRowY());
							state = Settings.STATE_STILL;
						}
					}
					else
					{
						state = Settings.STATE_ACTION;
					}
				}
			}
		}
	}
	
	public void getCharacterOnTarget(List<Character> characters , float x , float y)
	{
		for(Character n : characters)
		{
			if(n.bounds.contains(x , y))
			{
				pick = n;
			}					
		}
	}
	
	public boolean isInRange(int range)
	{
		if(Math.abs(mouse.getCol() - pick.getCol()) + Math.abs(mouse.getRow() - pick.getRow()) <= range)
		{
			return true;
		}
		return false;
	}
	
	public boolean hasCharacter()
	{
		for(Character n : charactersp1)
		{
			if(n.bounds.contains(mouse.getX(), mouse.getY()))
			{
				return true;
			}
		}
		for(Character n : charactersp2)
		{
			if(n.bounds.contains(mouse.getX(), mouse.getY()))
			{
				return true;
			}
		}
		for(Character n : towersP1)
		{
			if(n.bounds.contains(mouse.getX(), mouse.getY()))
			{
				return true;
			}
		}
		for(Character n : towersP2)
		{
			if(n.bounds.contains(mouse.getX(), mouse.getY()))
			{
				return true;
			}
		}
		return false;
	}
	
	public void disableSpawnChampion(Character character)
	{
		if(character.number >= Settings.C_WIZARD && character.number <Settings.C_MON1)
		{
			character.isUsed = true;
		}
	}
	
	public void checkItemupdate(int number , float x ,float y)
	{
		if(number == Settings.C_SWORDMAN)
		{
			spawnswordman(x,y);
		}
		else if(number == Settings.C_WIZARD)
		{
			spawnwizard(x,y);
		}
		else if(number == Settings.C_MON1)
		{
			spawnmon1(x,y);
		}
		else if(number == Settings.C_MON2)
		{
			spawnmon2(x,y);
		}
	}
	
	public void spawnswordman(float x , float y)
	{
		CSwordman swordman = new CSwordman(x,y,Settings.BLOCK_SIZE,Settings.BLOCK_SIZE,Settings.C_SWORDMAN , turn);
		addToPlayer(swordman);
	}
	
	public void spawnwizard(float x , float y)
	{
		CWizard wizard = new CWizard(x,y,Settings.BLOCK_SIZE,Settings.BLOCK_SIZE,Settings.C_WIZARD , turn);
		addToPlayer(wizard);
	}
	
	public void spawnmon1(float x , float y)
	{
		CMon1 mon1 = new CMon1(x,y,Settings.BLOCK_SIZE,Settings.BLOCK_SIZE,Settings.C_MON1, turn);
		addToPlayer(mon1);
	}
	
	public void spawnmon2(float x , float y)
	{
		CMon2 mon2 = new CMon2(x,y,Settings.BLOCK_SIZE,Settings.BLOCK_SIZE,Settings.C_MON2 , turn);
		addToPlayer(mon2);
	}
	
	
	public void addToPlayer(Character character)
	{
		if(turn == Settings.TURN_P1)
		{
			charactersp1.add(character);
		}
		else if(turn == Settings.TURN_P2)
		{
			charactersp2.add(character);
		}
	}
	
	public Board getBoard()
	{
		return board;
	}
	
}
