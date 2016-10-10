package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class GameScreen implements Screen{
	final GameOfPlan game;
	 
	//OrthographicCamera camera;
	
	World world;
	WorldRenderer worldrenderer;
	
	int[]whererandomgrass = new int[10];
	int countrandomgrass =0;
	
	public GameScreen(final GameOfPlan gam){
		this.game = gam;
		//camera = new OrthographicCamera();
		//camera.setToOrtho(false,Settings.SCREEN_X,Settings.SCREEN_Y);
		
		world = new World(game);
		worldrenderer = new WorldRenderer(game,world);
		
	}
	
	
	public void update()
	{
		
	}
	
	public void draw()
	{
		//camera.update();
	    //game.batch.setProjectionMatrix(camera.combined);
	    
	    world.update();
	    
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    
	    worldrenderer.render();
	    
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		update();
		draw();
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
