package com.mygdx.game;	

public class World {
	private GameOfPlan game;
	private Board board;
	private Mouse mouse;
	
	public World(GameOfPlan game)
	{
		this.game = game;
		board = new Board();
		mouse = new Mouse();
	}
	
	public void update()
	{
		
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
