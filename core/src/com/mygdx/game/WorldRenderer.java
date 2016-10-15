package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {
	SpriteBatch batch;
	BoardRenderer boardrenderer;
	World world;
	
	public WorldRenderer(GameOfPlan game, World world){
		this.batch = game.batch;
		boardrenderer = new BoardRenderer(game,world.getBoard());
		this.world = world;
		
	}
	
	public void mousepickrender()
	{
		batch.begin();
		batch.setColor(1, 1, 1, 0.5f);
		batch.draw(Assets.pickboard,world.getMouse().getCol()*Settings.BLOCK_SIZE,world.getMouse().getRow()*Settings.BLOCK_SIZE);
		batch.end();
		batch.setColor(1,1,1,1);
	}
	
	public void render()
	{
		boardrenderer.render();
		mousepickrender();
		
	}
}
