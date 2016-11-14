package com.mygdx.game;

import java.awt.Font;
import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.math.Rectangle;

public class World {
	private GameOfPlan game;
	
	public Board board;
	public Mouse mouse;
	
	public static int state = 0;
	public static int turn = Settings.TURN_P1;
	public static int skillSpawn;
	
	public static Player player1;
	public static Player player2;
	public static Player[] players;
	public static Player ally;
	public static Player enemy;
	
	public Character pick;

	public int[] resource;
	
	public World(GameOfPlan game, List<Character> selectedCharactersP1, List<Character> selectedCharactersP2) {
		this.game = game;
		board = new Board();
		mouse = new Mouse();
		
		player1 = new Player(selectedCharactersP1, this, Settings.BOARD_BLOCK_UPPER);
		player2 = new Player(selectedCharactersP2, this, Settings.BOARD_BLOCK_LOWER);
		players = new Player[Settings.TURN_P2 + 1];
		players[Settings.TURN_P1] = player1;
		players[Settings.TURN_P2] = player2;
		ally = player1;
		enemy = player2;
		
		setItem();
		setButton();
		setTower();
	}

	public void setButton() {
		player1.createButtonSkill(Settings.BUTTON_SKILLP1_X, Settings.BUTTON_SKILL_Y);
		player1.createButtonEndTurn(Settings.BUTTON_ENDTURNP1_X, Settings.BUTTON_ENDTURN_Y);
		player2.createButtonSkill(Settings.BUTTON_SKILLP2_X, Settings.BUTTON_SKILL_Y);
		player2.createButtonEndTurn(Settings.BUTTON_ENDTURNP2_X,  Settings.BUTTON_ENDTURN_Y);
	}
	
	public void setTower() {
		player1.createNexus(8 * Settings.BLOCK_SIZE, Settings.BOARD_HEIGHT - Settings.BLOCK_SIZE, Settings.TURN_P1);
		player2.createNexus(8 * Settings.BLOCK_SIZE, 0, Settings.TURN_P2);
	}
	
	public void setItem() {
		int i = 0;
		for (Character n : player1.selectedCharacters) {
			n.setPosition(i * Settings.BLOCK_SIZE, Settings.BOARD_HEIGHT - ( 2 * Settings.BLOCK_SIZE));
			i++;
		}
		i = 0;
		for (Character n : player2.selectedCharacters) {
			n.setPosition((i + Settings.BOARD_PLAYER + Settings.BOARD_X) * Settings.BLOCK_SIZE, Settings.BOARD_HEIGHT - ( 2 * Settings.BLOCK_SIZE));
			i++;
		}
	}
	
	public void update() {
		updateClickMouse();
	}
	
	public void updateClickMouse() {
		if (Gdx.input.justTouched()) {
			updateButtonEndTurn();
			updateButtonSkill();	
			updateState();
		}
	}
	
	public void updateButtonEndTurn() {
		if(ally.buttonEndTurn.contains(mouse.getX(), mouse.getY())) {
			ally.clickButtonEndTurn();
			if (turn == Settings.TURN_P1) {
				ally = player2;
				enemy = player1;
				turn = Settings.TURN_P2;
			} else if (turn == Settings.TURN_P2) {
				ally = player1;
				enemy = player2;
				turn = Settings.TURN_P1;
			}
			state = Settings.STATE_STILL;
		}

	}
	
	public void updateButtonSkill() {
		if (state == Settings.STATE_ACTION) {
			if(ally.buttonSkill.contains(mouse.getX(), mouse.getY())) {
				ally.clickButtonSkill(pick);
			}
		}
	}
	
	public void updateState() {
		if (state == Settings.STATE_STILL) {
			updateStateStill();
		} else if (state == Settings.STATE_SPAWN) {
			updateStateSpawn();
		} else if (state == Settings.STATE_ACTION) {
			updateStateAction();
		} else if (state == Settings.STATE_SKILLSPAWN) {
			updateSkillSpawn();
		}
	}
	
	public void updateStateStill() {
		if (ally.canGetCharacters(mouse.getX(), mouse.getY())) {
			pick = ally.getCharacters(mouse.getX(), mouse.getY());
			if (!pick.isUsed()) {
				state = Settings.STATE_ACTION;
			}
		} else if (ally.canGetSelectedCharacters(mouse.getX(), mouse.getY())) {
			pick = ally.getSelectedCharacters(mouse.getX(), mouse.getY());
			if(!pick.isUsed() && pick.cost <= ally.resource) {
				state = Settings.STATE_SPAWN;
			}
		} else if (enemy.canGetCharacters(mouse.getX(), mouse.getY())) {
			pick = enemy.getCharacters(mouse.getX(), mouse.getY());
		} else if (enemy.canGetSelectedCharacters(mouse.getX(), mouse.getY())) {
			pick = enemy.getSelectedCharacters(mouse.getX(), mouse.getY());
		}
	}
	
	public void updateStateSpawn() {
		if (board.isInBoard(mouse.getX(), mouse.getY())) {
			if (!hasCharacter()) {
				if (turn == Settings.TURN_P1) {
					if (board.isInBoardP1(mouse.getX(), mouse.getY())) {
						ally.spawnCharacter(mouse.getX(), mouse.getY());
						state = Settings.STATE_STILL;
					} 
				} else if (turn == Settings.TURN_P2) {
					if (board.isInBoardP2(mouse.getX(), mouse.getY())) {
						ally.spawnCharacter(mouse.getX(), mouse.getY());
						state = Settings.STATE_STILL;
					}
				}
			}
		} else {
			state = Settings.STATE_STILL;
		}
	}
	
	public void updateStateAction() {
		if (board.isInBoard(mouse.getX(), mouse.getY())) {
			if (hasCharacter()) {
				if (isInRange(pick.atkRange)) {
					ally.attack(mouse.getX(), mouse.getY());
				}
			} else {
				if (isInRange(pick.walk)) {
					ally.walk(mouse.getX(), mouse.getY());
				}
			}
			state = Settings.STATE_STILL;
		} else {
			state = Settings.STATE_STILL;
		}
	}
	
	public void updateSkillSpawn() {
		if (board.isInBoard(mouse.getX(), mouse.getY())) {
			if (isInRange(pick.skillRange)) {
				if (!hasCharacter()) {
					ally.checkItemupdate(skillSpawn, mouse.getColX(), mouse.getRowY());
					state = Settings.STATE_STILL;
				}
			}
		} else {
			state = Settings.STATE_ACTION;
		}
	}
	
	public boolean isInRange(int range) {
		if (Math.abs(mouse.getCol() - pick.getCol()) + Math.abs(mouse.getRow() - pick.getRow()) <= range) {
			return true;
		}
		return false;
	}
	
	public boolean hasCharacter() {
		return player1.canGetCharacters(mouse.getX(), mouse.getY())
				|| player2.canGetCharacters(mouse.getX(), mouse.getY());
	}
	
	public Board getBoard() {
		return board;
	}
	
}
