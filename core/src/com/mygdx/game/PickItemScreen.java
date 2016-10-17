package com.mygdx.game;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;

public class PickItemScreen implements Screen{
	GameOfPlan game;
	List<PickObject> pickobjects;
	PickObject pick;
	Rectangle b_selectp1;
	Rectangle b_selectp2;
	public int[] selectedp1;
	public int[] selectedp2;
	private int turn =0;
	Rectangle b_startgame;
	
	public PickItemScreen (GameOfPlan gam)
	{
		this.game = gam;
		pickobjects = new LinkedList<PickObject>();
		b_selectp1 = new Rectangle(Settings.B_SELECTP1_X,Settings.B_SELECT_Y,Settings.B_SELECT_WIDTH,Settings.B_SELECT_HEIGHT);
		b_selectp2 = new Rectangle(Settings.B_SELECTP2_X,Settings.B_SELECT_Y,Settings.B_SELECT_WIDTH,Settings.B_SELECT_HEIGHT);
		b_startgame = new Rectangle(Settings.B_STARTGAME_X, Settings.B_STARTGAME_Y , Settings.B_STARTGAME_WIDTH , Settings.B_STARTGAME_HEIGHT);
		selectedp1 = new int[Settings.NUMBER_PICKITEM];
		selectedp2 = new int[Settings.NUMBER_PICKITEM];
		setPickObject();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	public void setPickObject()
	{
		PickObject p1 = new PickObject(500 , 500 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , 1);
		pickobjects.add(p1);
		PickObject p2 = new PickObject(500 , 350 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , 2);
		pickobjects.add(p2);
		PickObject p3 = new PickObject(500 , 200 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , 3);
		pickobjects.add(p3);
	}
	
	public void updateClick()
	{
		if(Gdx.input.justTouched())
		{
			for(PickObject n : pickobjects)
			{
				if(n.bounds.contains(Gdx.input.getX(),Settings.BOARD_HEIGHT - Gdx.input.getY()))
				{
					pick = n;
				}
			}
		}
	}
	
	public void updateB_Select()
	{
		if(turn < Settings.NUMBER_PICKITEM*2 )
		{
			if(Gdx.input.justTouched())
			{
				if(turn % 2 ==0)
				{
					if(b_selectp1.contains(Gdx.input.getX(),Settings.BOARD_HEIGHT-Gdx.input.getY()))
					{
						selectedp1[turn/2]=pick.name;
						turn++;
					}
				}
				else
				{
					if(b_selectp2.contains(Gdx.input.getX(),Settings.BOARD_HEIGHT-Gdx.input.getY()))
					{
						selectedp2[turn/2]=pick.name;
						turn++;
					}
				}
			}
		}
	}
	
	public void updateB_StartGame()
	{
		if(turn == 6)
		{
			if(Gdx.input.justTouched())
			{
				if(b_startgame.contains(Gdx.input.getX(),Settings.BOARD_HEIGHT-Gdx.input.getY()))
				{
					game.setScreen(new GameScreen(game,selectedp1,selectedp2));
		        	dispose();
				}
			}
		}
	}
	
	public void update()
	{
		updateClick();
		updateB_Select();
		updateB_StartGame();
	}

	@Override
	public void render(float delta) {
		update();
		
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                
        game.batch.begin();
        backgroundrender();
        slotblockrender();
        wordrender();
        buttonrender();
        pickObjectrender();
        pickrender();
        game.batch.end();
	}
	
	public void pickrender()
	{
		if(pick != null)
		{
			game.batch.setColor(1, 1, 1, 0.5f);
			game.batch.draw(Assets.pickboard , pick.position.x , pick.position.y);
			game.batch.setColor(1, 1, 1, 1);
		}
	}
	
	public void pickObjectrender()
	{
		for(PickObject n : pickobjects)
		{
			if(n.name == 1)
			{
				game.batch.draw(Assets.friver , n.position.x , n.position.y);
			}
			else if(n.name ==2 )
			{
				game.batch.draw(Assets.fgrass , n.position.x , n.position.y);
			}
			else if(n.name == 3)
			{
				game.batch.draw(Assets.fground , n.position.x , n.position.y);
			}
		}
	}
	
	public void backgroundrender()
	{
		game.batch.draw(Assets.pickitemscreen,0,0);
	}
	
	public void buttonrender()
	{
		game.batch.draw(Assets.selectbutton, Settings.B_SELECTP1_X , Settings.B_SELECT_Y);
		game.batch.draw(Assets.selectbutton, Settings.B_SELECTP2_X , Settings.B_SELECT_Y);
		if(turn == 6)
		{
			game.batch.draw(Assets.startgamebutton, Settings.B_STARTGAME_X , Settings.B_STARTGAME_Y);
		}
	}
	
	public void slotblockrender()
	{
		for(int i=0;i<Settings.NUMBER_PICKITEM;i++)
		{
			if(selectedp1[i] == 1)
			{
				game.batch.draw(Assets.friver , 100 , 560 - (i * 100));
			}
			else if(selectedp1[i] == 2)
			{
				game.batch.draw(Assets.fgrass , 100 , 560 - (i * 100));
			}
			else if(selectedp1[i] == 3)
			{
				game.batch.draw(Assets.fground , 100 , 560 - (i * 100));
			}
			else
			{
				game.batch.draw(Assets.slotblock, 100 , 560 - (i * 100));
			}
		}
		for(int i=0;i<Settings.NUMBER_PICKITEM;i++)
		{
			if(selectedp2[i] == 1)
			{
				game.batch.draw(Assets.friver , 986 , 560 - (i * 100));
			}
			else if(selectedp2[i] == 2)
			{
				game.batch.draw(Assets.fgrass , 986 , 560 - (i * 100));
			}
			else if(selectedp2[i] == 3)
			{
				game.batch.draw(Assets.fground , 986 , 560 - (i * 100));
			}
			else
			{
				game.batch.draw(Assets.slotblock, 986 , 560 - (i * 100));
			}
		}

	}
	
	public void wordrender()
	{
		game.font.draw(game.batch,"Select your items or champion", 450,675);
		
		game.font.draw(game.batch,"Slot 1",20 , 600);
		game.font.draw(game.batch,"Slot 1",916 , 600);
		game.font.draw(game.batch,"Slot 2",20 , 500);
		game.font.draw(game.batch,"Slot 2",916 , 500);
		game.font.draw(game.batch,"Slot 3",20 , 400);
		game.font.draw(game.batch,"Slot 3",916 , 400);
		
		game.font.draw(game.batch,"Champions",500 , 600);
		game.font.draw(game.batch,"Minions",510 , 450);
		game.font.draw(game.batch,"Skills",515 , 300);
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
