package com.mygdx.game;

import com.badlogic.gdx.math.MathUtils;

public class Board {
	
	private GameOfPlan game;
	
	public short [][] map;
	
	public Board() {
		map = new short[Settings.BOARD_Y][Settings.BOARD_X]; 
		setGrass();
	}
	
	private void setGrass() {
		map[0][0] = Settings.GRASS;
		map[0][10] = Settings.GRASS;
		map[4][3] = Settings.GRASS;
		map[4][7] = Settings.GRASS;
		map[2][5] = Settings.GRASS;
		map[10][0] = Settings.GRASS;
		map[10][10] = Settings.GRASS;
		map[6][3] = Settings.GRASS;
		map[6][7] = Settings.GRASS;
		map[8][5] = Settings.GRASS;
	}
	
	private void setRandomGrass() {
		for (int i = 0; i < Settings.NUMBER_GRASS / 2; i++) {
			int r = MathUtils.random(0, (Settings.BOARD_Y / 2) - 1); 
			int c = MathUtils.random(0, Settings.BOARD_X - 1);
			map[r][c] = Settings.GRASS;
		}
		for (int i = 0; i < Settings.NUMBER_GRASS / 2; i++) {
			int r = MathUtils.random((Settings.BOARD_Y / 2) + 1, Settings.BOARD_Y - 1); 
			int c = MathUtils.random(0, Settings.BOARD_X - 1);
			map[r][c] = Settings.GRASS;
		}
	}
	
	public boolean isInBoard(float x, float y) {
		if (x >= Settings.BLOCK_SIZE * Settings.BOARD_PLAYER 
				&& y <= Settings.BOARD_WIDTH - (Settings.BOARD_PLAYER * Settings.BLOCK_SIZE)) {
			return true;
		}
		return false;
	}
	
	public boolean isInBoardP1(float x, float y) {
		if (y > Settings.BLOCK_SIZE * Settings.BOARD_BLOCK_UPPER) {
			return true;
		}
		return false;
	}
	
	public boolean isInBoardP2(float x, float y) {
		if (y < Settings.BLOCK_SIZE * Settings.BOARD_BLOCK_UPPER) {
			return true;
		}
		return false;
	}
	
	
}
