package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MenuScreen implements Screen{
	final GameOfPlan game;
	int win;
	
	public MenuScreen(GameOfPlan game, int win)
	{
		this.win = win;
		this.game = game;
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      
        
        game.batch.begin();
        if (win == Settings.TURN_P1) {
            game.batch.draw(Assets.winP1, 300, 500);
        } else if (win == Settings.TURN_P2) {
        	game.batch.draw(Assets.winP2, 300, 500);
        }
        game.batch.draw(Assets.restart, 300, 200);
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
