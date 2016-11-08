package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Mouse {
	Vector2 pos;
	
	public Mouse() {
		pos = new Vector2(Gdx.input.getX(), Gdx.input.getY());
	}
	
	public float getX() {
		return Gdx.input.getX();
	}
	
	public float getY() {
		return Settings.BOARD_HEIGHT - Gdx.input.getY();
	}
	
	public int getRow() {
		return Settings.BOARD_Y - (int)(Gdx.input.getY() / Settings.BLOCK_SIZE) - 1;
	}
	
	public int getCol() {
		return (int)(Gdx.input.getX() / Settings.BLOCK_SIZE);
	}
	
	public float getColX() {
		return getCol() * Settings.BLOCK_SIZE;
	}
	
	public float getRowY() {
		return getRow() * Settings.BLOCK_SIZE;
	}
}
