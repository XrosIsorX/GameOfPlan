package com.mygdx.game;

public class PickObject extends GameObject{
	public int name;
	
	public PickObject(float x, float y, float width, float height , int name) {
		super(x, y, width, height);
		this.name = name;
	}
	
}
