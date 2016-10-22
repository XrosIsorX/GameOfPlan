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
	
	public void buttonrender()
	{
		batch.draw(Assets.endturnbutton , Settings.B_ENDTURNP1_X , Settings.B_ENDTURN_Y);
		batch.draw(Assets.endturnbutton , Settings.B_ENDTURNP2_X , Settings.B_ENDTURN_Y);
	}

	public void checkFontrender(int name)
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
		if(name == Settings.C_SWORDMAN)
		{
			fontrender("Swordman" , Settings.SWORDMAN_COST ,Settings.SWORDMAN_HP , Settings.SWORDMAN_ATK , Settings.SWORDMAN_ATKRANK , Settings.SWORDMAN_WALK , x , Settings.BOARD_HEIGHT - (2.5f * Settings.BLOCK_SIZE));
		}
		else if(name == Settings.C_WIZARD)
		{
			fontrender("Wizard" , Settings.WIZARD_COST , Settings.WIZARD_HP , Settings.WIZARD_ATK , Settings.WIZARD_ATKRANK , Settings.WIZARD_WALK , x , Settings.BOARD_HEIGHT - (2.5f * Settings.BLOCK_SIZE));
		}
		else if(name == Settings.C_MON1)
		{
			fontrender("Mon1" , Settings.MON1_COST ,Settings.SWORDMAN_HP , Settings.MON1_ATK , Settings.MON1_ATKRANK , Settings.MON1_WALK , x , Settings.BOARD_HEIGHT - (2.5f * Settings.BLOCK_SIZE));
		}
		else if(name == Settings.C_MON2)
		{
			fontrender("Mon2" , Settings.MON2_COST ,Settings.SWORDMAN_HP , Settings.MON2_ATK , Settings.MON2_ATKRANK , Settings.MON2_WALK , x , Settings.BOARD_HEIGHT - (2.5f * Settings.BLOCK_SIZE));
		}
	}
	
	public void fontrender(String name , int cost , int hp , int atk , int atkrank , int walk , float x , float y)
	{
		font.draw(batch , "Name : " + name, x , y);
		font.draw(batch , "Cost : " + cost , x , y - (0.5f * Settings.BLOCK_SIZE));
		font.draw(batch , "Hp : " + hp , x , y - (1f * Settings.BLOCK_SIZE));
		font.draw(batch , "Atk : " + atk , x , y - (1.5f * Settings.BLOCK_SIZE));
		font.draw(batch , "Atk rank : " + atkrank, x , y - (2f * Settings.BLOCK_SIZE));
		font.draw(batch , "Walk : " + walk , x , y - (2.5f * Settings.BLOCK_SIZE));
	}
	
	public void resourcerender()
	{
		batch.draw(Assets.fgrass , 20 , Settings.BOARD_HEIGHT - (6f * Settings.BLOCK_SIZE) , 30 ,30);
		font.draw(batch , "X     " + world.resource[Settings.TURN_P1], 60 , Settings.BOARD_HEIGHT - (5.8f * Settings.BLOCK_SIZE));
		batch.draw(Assets.fgrass , 916 , Settings.BOARD_HEIGHT - (6f * Settings.BLOCK_SIZE) , 30 ,30);
		font.draw(batch , "X     " + world.resource[Settings.TURN_P1], 956 , Settings.BOARD_HEIGHT - (5.8f * Settings.BLOCK_SIZE));
	}
	
	public void render()
	{
		batch.begin();
		backgroundrender();
		boardrenderer.render();
		buttonrender();
		mousepickrender();
		itemrender();
		allCharacterrender();
		checkFontrender(world.pick);  
		spawnMouserender();
		resourcerender();
		batch.end();
	}
}
