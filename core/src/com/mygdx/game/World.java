package com.mygdx.game;	

public class World {
	private GameOfPlan game;
	private Board board;
	private Mouse mouse;
	public PickObject[] selectedp1;
	public PickObject[] selectedp2;
	
	public World(GameOfPlan game,PickObject[] selectedp1 , PickObject[] selectedp2)
	{
		this.game = game;
		board = new Board();
		mouse = new Mouse();
		this.selectedp1 = selectedp1;
		this.selectedp2 = selectedp2;
	}
	
	public void update()
	{
		
	}
	
	public void itemupdate()
	{
		setItem();
	}
	
	public void setItem()
	{
		for(int i=0;i<Settings.NUMBER_PICKITEM;i++)
		{
			selectedp1[i].position.x = i * Settings.BLOCK_SIZE;
			selectedp1[i].position.y = Settings.BOARD_HEIGHT - ( 2 * Settings.BLOCK_SIZE);
		}
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
