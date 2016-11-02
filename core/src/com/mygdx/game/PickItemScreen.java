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
	List<Character> characters;
	Character pick;
	Rectangle b_selectp1;
	Rectangle b_selectp2;
	public Character[] selectedp1;
	public Character[] selectedp2;
	private int turn =0;
	Rectangle b_startgame;
	
	public PickItemScreen (GameOfPlan gam)
	{
		this.game = gam;
		characters = new LinkedList<Character>();
		b_selectp1 = new Rectangle(Settings.B_SELECTP1_X,Settings.B_SELECT_Y,Settings.B_SELECT_WIDTH,Settings.B_SELECT_HEIGHT);
		b_selectp2 = new Rectangle(Settings.B_SELECTP2_X,Settings.B_SELECT_Y,Settings.B_SELECT_WIDTH,Settings.B_SELECT_HEIGHT);
		b_startgame = new Rectangle(Settings.B_STARTGAME_X, Settings.B_STARTGAME_Y , Settings.B_STARTGAME_WIDTH , Settings.B_STARTGAME_HEIGHT);
		selectedp1 = new Character[Settings.NUMBER_PICKITEM];
		selectedp2 = new Character[Settings.NUMBER_PICKITEM];
		setCharacter();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	public void setCharacter()
	{
		Character cswordman = new Character(400 , 500 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.C_SWORDMAN);
		characters.add(cswordman);
		Character cwizard = new Character(600 , 500 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.C_WIZARD);
		characters.add(cwizard);
		Character cmon1 = new Character(400 , 350 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.C_MON1);
		characters.add(cmon1);
		Character cmon2 = new Character(600 , 350 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.C_MON2);
		characters.add(cmon2);
		Character shealth = new Character(400 , 200 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.S_HEALTH);
		characters.add(shealth);
		Character smana = new Character(600 , 200 , Settings.BLOCK_SIZE  , Settings.BLOCK_SIZE , Settings.S_MANA);
		characters.add(smana);
	}
	
	public void updateClick()
	{
		if(Gdx.input.justTouched())
		{
			for(Character n : characters)
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
						selectedp1[turn/2]=pick;
						turn++;
					}
				}
				else
				{
					if(b_selectp2.contains(Gdx.input.getX(),Settings.BOARD_HEIGHT-Gdx.input.getY()))
					{
						selectedp2[turn/2]=pick;
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
        Characterrender();
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
	
	public void Characterrender()
	{
		for(Character n : characters)
		{
			if(n.number == Settings.C_SWORDMAN)
			{
				game.batch.draw(Assets.cswordman , n.position.x , n.position.y);
			}
			else if(n.number == Settings.C_WIZARD )
			{
				game.batch.draw(Assets.cwizard, n.position.x , n.position.y);
			}
			else if(n.number == Settings.C_MON1)
			{
				game.batch.draw(Assets.cmon1, n.position.x , n.position.y);
			}
			else if(n.number == Settings.C_MON2)
			{
				game.batch.draw(Assets.cmon2, n.position.x , n.position.y);
			}
			else if(n.number == Settings.S_MANA)
			{
				game.batch.draw(Assets.smana, n.position.x , n.position.y);
			}
			else if(n.number == Settings.S_HEALTH)
			{
				game.batch.draw(Assets.shealth, n.position.x , n.position.y);
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
			if(selectedp1[i] == null)
			{
				game.batch.draw(Assets.slotblock, 100, 560 - (i * 100));
			}
			else if(selectedp1[i].number == Settings.C_SWORDMAN)
			{
				game.batch.draw(Assets.cswordman , 100 , 560 - (i * 100));
			}
			else if(selectedp1[i].number == Settings.C_WIZARD)
			{
				game.batch.draw(Assets.cwizard , 100 , 560 - (i * 100));
			}
			else if(selectedp1[i].number == Settings.C_MON1)
			{
				game.batch.draw(Assets.cmon1 , 100 , 560 - (i * 100));
			}
			else if(selectedp1[i].number == Settings.C_MON2)
			{
				game.batch.draw(Assets.cmon2, 100 , 560 - (i * 100));
			}
			else if(selectedp1[i].number == Settings.S_HEALTH)
			{
				game.batch.draw(Assets.shealth, 100 , 560 - (i * 100));
			}
			else if(selectedp1[i].number == Settings.S_MANA)
			{
				game.batch.draw(Assets.smana, 100 , 560 - (i * 100));
			}
		}
		for(int i=0;i<Settings.NUMBER_PICKITEM;i++)
		{
			if(selectedp2[i] == null)
			{
				game.batch.draw(Assets.slotblock, 986, 560 - (i * 100));
			}
			else if(selectedp2[i].number == Settings.C_SWORDMAN)
			{
				game.batch.draw(Assets.cswordman , 986 , 560 - (i * 100));
			}
			else if(selectedp2[i].number == Settings.C_WIZARD)
			{
				game.batch.draw(Assets.cwizard , 986 , 560 - (i * 100));
			}
			else if(selectedp2[i].number == Settings.C_MON1)
			{
				game.batch.draw(Assets.cmon1 , 986 , 560 - (i * 100));
			}
			else if(selectedp2[i].number == Settings.C_MON2)
			{
				game.batch.draw(Assets.cmon2, 986 , 560 - (i * 100));
			}
			else if(selectedp2[i].number == Settings.S_HEALTH)
			{
				game.batch.draw(Assets.shealth, 986 , 560 - (i * 100));
			}
			else if(selectedp2[i].number == Settings.S_MANA)
			{
				game.batch.draw(Assets.smana, 986 , 560 - (i * 100));
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
