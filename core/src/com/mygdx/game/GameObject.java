package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameObject {
	public final Vector2 position;
	public final Rectangle bounds;

	public GameObject (float x, float y, float width, float height) {
		this.position = new Vector2(x, y);
		this.bounds = new Rectangle(x - width / 2, y - height / 2, width, height);
	}
	
	public int getRow()
	{
		return (int)(position.y/Settings.BLOCK_SIZE);
	}
	
	public int getCol()
	{
		return (int)(position.x/Settings.BLOCK_SIZE);
	}
}
