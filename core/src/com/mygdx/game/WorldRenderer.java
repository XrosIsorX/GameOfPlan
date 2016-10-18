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
	
	public void backgroundrender()
	{
		batch.begin();
		batch.draw(Assets.pickitemscreen,0,0);
		batch.end();
	}
	
	public void itemrender()
	{
		batch.begin();
		checkItemrender(world.selectedp1 , 0 , 2);
		checkItemrender(world.selectedp2 , Settings.BOARD_WIDTH - ( 3 * Settings.BLOCK_SIZE ) , 2);
		batch.end();
	}
	
	public void checkItemrender(PickObject[] item , int blockX ,int blockY)
	{
		for(int i=0;i<Settings.NUMBER_PICKITEM;i++)
		{
			if(item[i].name == Settings.C_SWORDMAN)
			{
				batch.draw(Assets.cswordman , blockX + ( i * Settings.BLOCK_SIZE ) , Settings.BOARD_HEIGHT - (blockY * Settings.BLOCK_SIZE));
			}
			else if(item[i].name == Settings.C_WIZARD)
			{
				batch.draw(Assets.cwizard , blockX + ( i * Settings.BLOCK_SIZE ) , Settings.BOARD_HEIGHT - (blockY* Settings.BLOCK_SIZE));
			}
			else if(item[i].name == Settings.C_MON1)
			{
				batch.draw(Assets.cmon1 , blockX + ( i * Settings.BLOCK_SIZE ) , Settings.BOARD_HEIGHT - (blockY * Settings.BLOCK_SIZE));
			}
			else if(item[i].name == Settings.C_MON2)
			{
				batch.draw(Assets.cmon2, blockX + ( i * Settings.BLOCK_SIZE ) , Settings.BOARD_HEIGHT - (blockY * Settings.BLOCK_SIZE));
			}
			else if(item[i].name == Settings.S_HEALTH)
			{
				batch.draw(Assets.shealth, blockX + ( i * Settings.BLOCK_SIZE ) , Settings.BOARD_HEIGHT - (blockY * Settings.BLOCK_SIZE));
			}
			else if(item[i].name == Settings.S_MANA)
			{
				batch.draw(Assets.smana, blockX + ( i * Settings.BLOCK_SIZE ) , Settings.BOARD_HEIGHT - (blockY * Settings.BLOCK_SIZE));
			}
		}
	}
	
	public void render()
	{
		backgroundrender();
		boardrenderer.render();
		mousepickrender();
		itemrender();
	}
}
