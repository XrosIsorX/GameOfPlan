package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MenuScreen implements Screen{
	final GameOfPlan game;
	OrthographicCamera camera;
	
	public MenuScreen(final GameOfPlan gam)
	{
		this.game = gam;
		//camera =  new OrthographicCamera();
		//camera.setToOrtho(false,Settings.SCREEN_X,Settings.SCREEN_Y);
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        //camera.update();
        //game.batch.setProjectionMatrix(camera.combined);
        
        game.batch.begin();
        game.font.draw(game.batch,"Welcome to Game Of Plan !!!", 500, 700);
        game.font.draw(game.batch,"Tap anywhere to start game!", 500, 500);
        game.batch.end();
        
        if(Gdx.input.justTouched()){
        	game.setScreen(new PickItemScreen(game));
        	dispose();
        }
        
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
