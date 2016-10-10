package com.mygdx.game;

public class World {
	private GameOfPlan game;
	private Board board;
	
	public World(GameOfPlan game)
	{
		this.game = game;
		board = new Board();
		
	}
	
	public void update()
	{
		
	}
	
	public Board getBoard()
	{
		return board;
	}
	
}
