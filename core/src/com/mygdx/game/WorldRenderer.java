package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {
	public SpriteBatch batch;
	public BitmapFont font;
	
	BoardRenderer boardrenderer;
	World world;
	
	public WorldRenderer(GameOfPlan game, World world){
		this.batch = game.batch;
		this.font = game.font;
		boardrenderer = new BoardRenderer(game,world.getBoard());
		this.world = world;
		
	}
	
	public void mousepickrender()
	{
		batch.setColor(1, 1, 1, 0.5f);
		batch.draw(Assets.pickboard,world.mouse.getColX() , world.mouse.getRowY());
		batch.setColor(1,1,1,1);
	}
	
	public void pickcharacterrender()
	{
		if(world.state == Settings.STATE_ACTION)
		{
			batch.setColor(1, 1, 1, 0.5f);
			batch.draw(Assets.pickcharacter,world.pick.position.x,world.pick.position.y);
			batch.setColor(1,1,1,1);
		}
	}
	
	public void backgroundrender()
	{
		if(world.turn == Settings.TURN_P1)
		{
			batch.draw(Assets.turnp1screen , 0 , 0);
		}
		if(world.turn == Settings.TURN_P2)
		{
			batch.draw(Assets.turnp2screen , 0 , 0);
		}
	}
	
	public void itemrender()
	{
		for(int i=0 ;i <Settings.NUMBER_PICKITEM ;i++)
		{
			checkItemrender(world.selectedp1[i].number , world.selectedp1[i].position.x , world.selectedp1[i].position.y);
		}
		for(int i=0 ;i <Settings.NUMBER_PICKITEM ;i++)
		{
			checkItemrender(world.selectedp2[i].number , world.selectedp2[i].position.x , world.selectedp2[i].position.y);
		}
	}

	public void checkItemrender(int number , float x ,float y)
	{
		if(number == Settings.C_SWORDMAN)
		{
			batch.draw(Assets.cswordman , x , y);
		}
		else if(number == Settings.C_WIZARD)
		{
			batch.draw(Assets.cwizard , x , y );
		}
		else if(number == Settings.C_MON1)
		{
			batch.draw(Assets.cmon1 , x , y );
		}
		else if(number == Settings.C_MON2)
		{
			batch.draw(Assets.cmon2, x , y );
		}
		else if(number == Settings.S_HEALTH)
		{
			batch.draw(Assets.shealth, x , y );
		}
		else if(number == Settings.S_MANA)
		{
			batch.draw(Assets.smana, x , y );
		}
	}
	
	public void spawnMouserender()
	{
		if(world.state == Settings.STATE_SPAWN)
		{
			checkItemrender(world.pick.number , Gdx.input.getX() - (Settings.BLOCK_SIZE / 2) , Settings.BOARD_HEIGHT - Gdx.input.getY() - (Settings.BLOCK_SIZE / 2));
		}
	}
	
	public void allCharacterrender()
	{
		for(Character n : world.charactersp1)
		{
			checkItemrender(n.number , n.position.x , n.position.y);
		}
		for(Character n : world.charactersp2)
		{
			checkItemrender(n.number , n.position.x , n.position.y);
		}
	}
	
	public void buttonrender()
	{
		batch.draw(Assets.endturnbutton , Settings.B_ENDTURNP1_X , Settings.B_ENDTURN_Y);
		batch.draw(Assets.endturnbutton , Settings.B_ENDTURNP2_X , Settings.B_ENDTURN_Y);
		batch.draw(Assets.skillbutton , Settings.B_SKILLBUTTONP1_X , Settings.B_SKILLBUTTON_Y);
		batch.draw(Assets.skillbutton , Settings.B_SKILLBUTTONP2_X , Settings.B_SKILLBUTTON_Y);
	}

	public void checkFontrender(Character pick)
	{
		int x=0;
		if(world.turn == Settings.TURN_P1)
		{
			x = 20;
		}
		else if(world.turn == Settings.TURN_P2)
		{
			x = 916;
		}
		fontrender(pick.name , pick.cost , pick.hp , pick.atk , pick.atkRange , pick.walk , pick.skill , x , Settings.BOARD_HEIGHT - (2.5f * Settings.BLOCK_SIZE));
	}
	
	public void fontrender(String name , int cost , int hp , int atk , int atkRange , int walk , String skill , float x , float y)
	{
		font.draw(batch , "Name : " + name, x , y);
		font.draw(batch , "Cost : " + cost , x , y - (0.5f * Settings.BLOCK_SIZE));
		font.draw(batch , "Hp : " + hp , x , y - (1f * Settings.BLOCK_SIZE));
		font.draw(batch , "Atk : " + atk , x , y - (1.5f * Settings.BLOCK_SIZE));
		font.draw(batch , "Atk range : " + atkRange, x , y - (2f * Settings.BLOCK_SIZE));
		font.draw(batch , "Walk : " + walk , x , y - (2.5f * Settings.BLOCK_SIZE));
		font.draw(batch , skill , x , y - (3.8f * Settings.BLOCK_SIZE));
	}
	
	public void resourcerender()
	{
		batch.draw(Assets.fgrass , 20 , 100 , 30 ,30);
		font.draw(batch , "  X     " + world.resource[Settings.TURN_P1], 60 , 115);
		batch.draw(Assets.fgrass , 916 , 100 , 30 ,30);
		font.draw(batch , "  X     " + world.resource[Settings.TURN_P1], 956 , 115);
	}
	
	public void actionrender()
	{
		
	}
	
	public void render()
	{
		batch.begin();
		backgroundrender();
		boardrenderer.render();
		buttonrender();
		mousepickrender();
		pickcharacterrender();
		itemrender();
		allCharacterrender();
		if(world.pick != null)
		{
			checkFontrender(world.pick);
			spawnMouserender();
		}
		resourcerender();
		batch.end();
	}
}
