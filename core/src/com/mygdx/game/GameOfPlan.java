package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOfPlan extends Game{
	public SpriteBatch batch;
	public BitmapFont font;
	
	public void create() { 
		batch = new SpriteBatch();
		font = new BitmapFont();
		Assets.load();
		this.setScreen(new GameScreen(this));
	}
	
	public void render() {
		super.render();
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}
