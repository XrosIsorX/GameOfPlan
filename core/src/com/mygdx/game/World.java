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
	public static int skillSpawn;
	
	public Rectangle buttonEndTurnP1;
	public Rectangle buttonEndTurnP2;
	public Rectangle buttonSkillP1;
	public Rectangle buttonSkillP2;
	
	public static List<Character> towersP1;
	public static List<Character> towersP2;
	
	public static List<Character> charactersP1;
	public static List<Character> charactersP2;
	
	public List<Character> characterSelectedP1;
	public List<Character> characterSelectedP2;
	
	public Character pick;

	public int[] resource;
	
	public World(GameOfPlan game, List<Character> characterSelectedP1, List<Character> characterSelectedP2) {
		this.game = game;
		board = new Board();
		mouse = new Mouse();
		
		resource = new int[3];
		
		this.characterSelectedP1 = characterSelectedP1;
		this.characterSelectedP2 = characterSelectedP2;
		charactersP1 = new LinkedList<Character>();
		charactersP2 = new LinkedList<Character>();
		towersP1 = new LinkedList<Character>();
		towersP2 = new LinkedList<Character>();
		
		setItem();
		setButton();
		setTower();
	}

	public void setButton() {
		buttonEndTurnP1 = new Rectangle(Settings.BUTTON_ENDTURNP1_X ,Settings.BUTTON_ENDTURN_Y, Settings.BUTTON_ENDTURN_WIDTH, Settings.BUTTON_ENDTURN_HEIGHT);
		buttonEndTurnP2 = new Rectangle(Settings.BUTTON_ENDTURNP2_X ,Settings.BUTTON_ENDTURN_Y, Settings.BUTTON_ENDTURN_WIDTH, Settings.BUTTON_ENDTURN_HEIGHT);
		buttonSkillP1 = new Rectangle(Settings.BUTTON_SKILLBUTTONP1_X, Settings.BUTTON_SKILLBUTTON_Y, Settings.BUTTON_SKILL_WIDTH, Settings.BUTTON_SKILL_HEIGHT);
		buttonSkillP2 = new Rectangle(Settings.BUTTON_SKILLBUTTONP2_X, Settings.BUTTON_SKILLBUTTON_Y, Settings.BUTTON_SKILL_WIDTH, Settings.BUTTON_SKILL_HEIGHT);
	}
	
	public void update() {
		updateClickMouse();
	}
	
	public void setTower() {
		Nexus nexusP1 = new Nexus(8 * Settings.BLOCK_SIZE, Settings.BOARD_HEIGHT - Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, Settings.NEXUSP1_NUMBER, Settings.TURN_P1);
		towersP1.add(nexusP1);
		Nexus nexusP2 = new Nexus(8 * Settings.BLOCK_SIZE, 0, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, Settings.NEXUSP2_NUMBER, Settings.TURN_P1);
		towersP2.add(nexusP2);
	}
	
	public void setItem() {
		int i = 0;
		for ( Character n : characterSelectedP1) {
			n.setPosition(i * Settings.BLOCK_SIZE, Settings.BOARD_HEIGHT - ( 2 * Settings.BLOCK_SIZE));
			i++;
		}
		i = 0;
		for (Character n : characterSelectedP2) {
			n.setPosition((i + Settings.BOARD_PLAYER + Settings.BOARD_X) * Settings.BLOCK_SIZE, Settings.BOARD_HEIGHT - ( 2 * Settings.BLOCK_SIZE));
			i++;
		}
	}
	
	public void updateButtonEndTurn() {
		if (turn == Settings.TURN_P1) {
			if (buttonEndTurnP1.contains(mouse.getX(), mouse.getY())) {
				collectGrass(charactersP1);
				resetUsedCharacter(charactersP1);
				turn = Settings.TURN_P2;
			}
		} else if (turn == Settings.TURN_P2) {
			if (buttonEndTurnP2.contains(mouse.getX(), mouse.getY())) {
				collectGrass(charactersP2);
				resetUsedCharacter(charactersP2);
				turn = Settings.TURN_P1;
			}
		}
	}
	
	public void resetUsedCharacter(List<Character> characters) {
		for (Character n : characters) {
			n.isUsed = false;
		}
	}
	
	public void collectGrass(List<Character> characters)
	{
		for (Character n : characters) {
			int col = n.getCol() - Settings.BOARD_PLAYER;
			int row = n.getRow();
			if (board.map[row][col] == Settings.GRASS) {
				resource[turn]++;
			}
		}
	}
	
	public void updateButtonSkill() {
		if (state == Settings.STATE_ACTION) {
			if (turn == Settings.TURN_P1) {
				if (buttonSkillP1.contains(mouse.getX(), mouse.getY())) {
					pick.skill();
					pick.isUsed = true;
				}
			} else if (turn == Settings.TURN_P2) {
				if (buttonSkillP2.contains(mouse.getX(), mouse.getY())) {
					pick.skill();
					pick.isUsed = true;
				}
			}
		}
	}
	
	public void updateClickMouse() {
		if (Gdx.input.justTouched()) {
			if (state == Settings.STATE_STILL) {
				updateStateStill();
			} else if (state == Settings.STATE_SPAWN) {
				updateStateSpawn();
			} else if (state == Settings.STATE_ACTION) {
				updateStateAction();
			} else if (state == Settings.STATE_SKILLSPAWN) {
				updateSkillSpawn();
			}
			
			updateButtonEndTurn();
			updateButtonSkill();
		}
	}
	
	public void updateStateStill() {
		if (turn == Settings.TURN_P1) {
			for (Character n : charactersP1) {
				if (n.bounds.contains(mouse.getX(), mouse.getY())) {
					pick = n;
					if (!n.isUsed()) {
						state = Settings.STATE_ACTION;
					}
				}					
			}
			//getCharacterOnTarget(charactersP1, mouse.getX(), mouse.getY());		
		} else if (turn == Settings.TURN_P2) {
			for (Character n : charactersP2) {
				if (n.bounds.contains(mouse.getX(), mouse.getY())) {
					pick = n;
					if (n.isUsed()) {
						state = Settings.STATE_ACTION;
					}
				}					
			}
			//getCharacterOnTarget(charactersP2, mouse.getX(), mouse.getY());
		}
		for (Character n : characterSelectedP1) {
			if (turn == Settings.TURN_P1) {
				if (n.bounds.contains(mouse.getX(), mouse.getY())) {
					pick = n;
					if (pick.isUsed == false && pick.cost <= resource[turn]) {
						state = Settings.STATE_SPAWN;
					}
				}
			} else if (turn == Settings.TURN_P2) {
				if (n.bounds.contains(mouse.getX(), mouse.getY())) {
					pick = n;
					if (pick.isUsed == false && pick.cost <= resource[turn]) {
						state = Settings.STATE_SPAWN;
					}
				}
			}
		}
		for (Character n : characterSelectedP2) {
			if (turn == Settings.TURN_P1) {
				if (n.bounds.contains(mouse.getX(), mouse.getY())) {
					pick = n;
					if (pick.isUsed == false && pick.cost <= resource[turn]) {
						state = Settings.STATE_SPAWN;
					}
				}
			} else if (turn == Settings.TURN_P2) {
				if (n.bounds.contains(mouse.getX(), mouse.getY())) {
					pick = n;
					if (pick.isUsed == false && pick.cost <= resource[turn]) {
						state = Settings.STATE_SPAWN;
					}
				}
			}
		}
	}
	
	public void updateStateSpawn() {
		if (mouse.getX() >= Settings.BLOCK_SIZE * Settings.BOARD_PLAYER 
				&& mouse.getX() <= Settings.BOARD_WIDTH - (Settings.BOARD_PLAYER * Settings.BLOCK_SIZE)) {
			if (!hasCharacter()) {
				if (turn == Settings.TURN_P1) {
					if (mouse.getY() > Settings.BLOCK_SIZE * 6) {
						checkItemupdate(pick.number, mouse.getCol() * Settings.BLOCK_SIZE, mouse.getRow() * Settings.BLOCK_SIZE);
						disableSpawnChampion(pick);
						resource[turn] -= pick.cost;
						state = Settings.STATE_STILL;
					}
				} else if (turn == Settings.TURN_P2) {
					if (mouse.getY() < Settings.BLOCK_SIZE * 5) {
						checkItemupdate(pick.number, mouse.getCol() * Settings.BLOCK_SIZE, mouse.getRow() * Settings.BLOCK_SIZE);
						disableSpawnChampion(pick);
						resource[turn] -= pick.cost;
						state = Settings.STATE_STILL;
					}
				}
			}
		} else {
			state = Settings.STATE_STILL;
		}
	}
	
	public void updateStateAction() {
		if (mouse.getX() >= Settings.BLOCK_SIZE * Settings.BOARD_PLAYER 
				&& mouse.getX() <= Settings.BOARD_WIDTH - (Settings.BOARD_PLAYER * Settings.BLOCK_SIZE)) {
				if (hasCharacter()) {
					if (isInRange(pick.atkRange)) {
						if (turn == Settings.TURN_P1) {
							for (Character n : charactersP2) {
								if (n.bounds.contains(mouse.getX(), mouse.getY())) {
									n.reduceHP(pick.atk);
									pick.isUsed = true;
								}
							}
							for (Character n : towersP2) {
								if (n.bounds.contains(mouse.getX(), mouse.getY())) {
									n.reduceHP(pick.atk);
									pick.isUsed = true;
								}
							}
						} else if (turn == Settings.TURN_P2) {
							for (Character n : charactersP1) {
								if (n.bounds.contains(mouse.getX(), mouse.getY())) {
									n.reduceHP(pick.atk);
									pick.isUsed = true;
								}
							}
							for (Character n : towersP1) {
								if (n.bounds.contains(mouse.getX(), mouse.getY())) {
									n.reduceHP(pick.atk);
									pick.isUsed = true;
								}
							}
						}
					}
				} else {
					if (isInRange(pick.walk)) {
						pick.setPosition(mouse.getColX(), mouse.getRowY());
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
	
	public void updateSkillSpawn() {
		if (isInRange(pick.skillRange)) {
			if (mouse.getX() >= Settings.BLOCK_SIZE * Settings.BOARD_PLAYER 
				&& mouse.getX() <= Settings.BOARD_WIDTH - (Settings.BOARD_PLAYER * Settings.BLOCK_SIZE)) {
				if (!hasCharacter()) {
					checkItemupdate(skillSpawn, mouse.getColX(), mouse.getRowY());
					state = Settings.STATE_STILL;
				}
			} else {
				state = Settings.STATE_ACTION;
			}
		}
	}
	
	public Character getCharacterOnTarget(List<Character> characters, float x, float y) {
		for (Character n : characters) {
			if (n.bounds.contains(x, y)) {
				return n;
			}					
		}
		return null;
	}
	
	public boolean isInRange(int range) {
		if (Math.abs(mouse.getCol() - pick.getCol()) + Math.abs(mouse.getRow() - pick.getRow()) <= range) {
			return true;
		}
		return false;
	}
	
	public boolean hasCharacter() {
		for (Character n : charactersP1) {
			if (n.bounds.contains(mouse.getX(), mouse.getY())) {
				return true;
			}
		}
		for (Character n : charactersP2) {
			if (n.bounds.contains(mouse.getX(), mouse.getY())) {
				return true;
			}
		}
		for (Character n : towersP1) {
			if (n.bounds.contains(mouse.getX(), mouse.getY())) {
				return true;
			}
		}
		for (Character n : towersP2) {
			if (n.bounds.contains(mouse.getX(), mouse.getY())) {
				return true;
			}
		}
		return false;
	}
	
	public void disableSpawnChampion(Character character) {
		if (character.number >= Settings.WIZARD_NUMBER && character.number <Settings.MEEP_NUMBER) {
			character.isUsed = true;
		}
	}
	
	public void checkItemupdate(int number, float x ,float y) {
		if (number == Settings.SWORDMAN_NUMBER) {
			spawnSwordman(x,y);
		} else if (number == Settings.WIZARD_NUMBER) {
			spawnWizard(x,y);
		} else if (number == Settings.MEEP_NUMBER) {
			spawnMeep(x,y);
		} else if (number == Settings.SKULL_NUMBER) {
			spawnSkull(x,y);
		}
	}
	
	public void spawnSwordman(float x, float y) {
		Swordman swordman = new Swordman(x, y, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,Settings.SWORDMAN_NUMBER, turn);
		addToPlayer(swordman);
	}
	
	public void spawnWizard(float x, float y) {
		Wizard wizard = new Wizard(x, y, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, Settings.WIZARD_NUMBER, turn);
		addToPlayer(wizard);
	}
	
	public void spawnMeep(float x, float y) {
		Meep meep = new Meep(x, y, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, Settings.MEEP_NUMBER, turn);
		addToPlayer(meep);
	}
	
	public void spawnSkull(float x, float y) {
		Skull skull = new Skull(x, y, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, Settings.SKULL_NUMBER, turn);
		addToPlayer(skull);
	}
	
	
	public void addToPlayer(Character character) {
		if (turn == Settings.TURN_P1) {
			charactersP1.add(character); 
		} else if (turn == Settings.TURN_P2) {
			charactersP2.add(character);
		}
	}
	
	public Board getBoard() {
		return board;
	}
	
}
