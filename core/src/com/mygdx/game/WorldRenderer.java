package com.mygdx.game;

import com.badlogic.gdx.Gdx;
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
		batch.setColor(1, 1, 1, 0.5f);
		batch.draw(Assets.pickboard,world.getMouse().getCol()*Settings.BLOCK_SIZE,world.getMouse().getRow()*Settings.BLOCK_SIZE);
		batch.setColor(1,1,1,1);
	}
	
	public void backgroundrender()
	{
		batch.draw(Assets.pickitemscreen,0,0);
	}
	
	public void itemrender()
	{
		for(int i=0 ;i <Settings.NUMBER_PICKITEM ;i++)
		{
			checkItemrender(world.selectedp1[i].name , world.selectedp1[i].position.x , world.selectedp1[i].position.y);
		}
		for(int i=0 ;i <Settings.NUMBER_PICKITEM ;i++)
		{
			checkItemrender(world.selectedp2[i].name , world.selectedp2[i].position.x , world.selectedp2[i].position.y);
		}
	}

	public void checkItemrender(int name , float x ,float y)
	{
		if(name == Settings.C_SWORDMAN)
		{
			batch.draw(Assets.cswordman , x , y);
		}
		else if(name == Settings.C_WIZARD)
		{
			batch.draw(Assets.cwizard , x , y );
		}
		else if(name == Settings.C_MON1)
		{
			batch.draw(Assets.cmon1 , x , y );
		}
		else if(name == Settings.C_MON2)
		{
			batch.draw(Assets.cmon2, x , y );
		}
		else if(name == Settings.S_HEALTH)
		{
			batch.draw(Assets.shealth, x , y );
		}
		else if(name == Settings.S_MANA)
		{
			batch.draw(Assets.smana, x , y );
		}
	}
	
	public void spawnMouserender()
	{
		if(world.state == Settings.STATE_SPAWN)
		{
			checkItemrender(world.pick , Gdx.input.getX() - (Settings.BLOCK_SIZE / 2) , Settings.BOARD_HEIGHT - Gdx.input.getY() - (Settings.BLOCK_SIZE / 2));
		}
	}
	
	public void allCharacterrender()
	{
		for(Character n : world.characters)
		{
			checkItemrender(n.name , n.position.x , n.position.y);
		}
	}
	
	public void render()
	{
		batch.begin();
		backgroundrender();
		boardrenderer.render();
		mousepickrender();
		itemrender();
		allCharacterrender();
		spawnMouserender();
		batch.end();
	}
}
