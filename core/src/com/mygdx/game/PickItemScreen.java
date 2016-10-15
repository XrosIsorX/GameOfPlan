package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class PickItemScreen implements Screen{
	GameOfPlan game;
	
	public PickItemScreen (GameOfPlan gam)
	{
		this.game = gam;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                
        game.batch.begin();
        backgroundrender();
        slotblockrender();
        wordrender();
        buttonrender();
        game.batch.end();
        
        
	}
	
	public void backgroundrender()
	{
		game.batch.draw(Assets.pickitemscreen,0,0);
	}
	
	public void buttonrender()
	{
		game.batch.draw(Assets.selectbutton, 50 , 30);
		game.batch.draw(Assets.selectbutton, 946 , 30);
	}
	
	public void slotblockrender()
	{
		game.batch.draw(Assets.slotblock, 100 , 560);
		game.batch.draw(Assets.slotblock, 986 , 560);
		game.batch.draw(Assets.slotblock, 100 , 460);
		game.batch.draw(Assets.slotblock, 986 , 460);
		game.batch.draw(Assets.slotblock, 100 , 360);
		game.batch.draw(Assets.slotblock, 986 , 360);
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
