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
	
	public GameScreen(final GameOfPlan gam , PickObject[] selectedp1 , PickObject[] selectedp2){
		this.game = gam;
		
		world = new World(game , selectedp1 , selectedp2);
		worldrenderer = new WorldRenderer(game,world);
	}
	
	
	public void update()
	{
	    world.update();
	}
	
	public void draw()
	{
		update();
	    
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
