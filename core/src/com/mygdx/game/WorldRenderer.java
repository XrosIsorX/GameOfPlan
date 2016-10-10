package com.mygdx.game;

public class WorldRenderer {
	GameOfPlan game;
	BoardRenderer boardrenderer;
	World world;
	
	public WorldRenderer(GameOfPlan gam, World world){
		this.game = gam;
		boardrenderer = new BoardRenderer(game,world.getBoard());
		this.world = world;
		
		Assets.load();
	}
	
	public void render()
	{
		boardrenderer.render();
	}
}
