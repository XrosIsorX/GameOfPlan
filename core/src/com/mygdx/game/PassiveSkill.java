package com.mygdx.game;

public class PassiveSkill extends GameObject{
	int team = 0;
	int number = 0;
	String skillDetail = "-";

	public PassiveSkill(float x, float y, float width, float height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void setPosition(float x, float y) {
		position.x = x;
		position.y = y;
		bounds.x = x;
		bounds.y = y;
	}
	
	
	public void skill() {
		
	}
}
