package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BoardRenderer {
	private GameOfPlan game;
	private Board board;
	private SpriteBatch batch;
	
	public BoardRenderer(GameOfPlan game,Board board)
	{
		this.game = game;
		this.board = board;
		this.batch = game.batch;
		
	}
	
	public void render()
	{
		for(int i=0;i<Settings.BOARD_Y;i++)
		{
			for(int j= Settings.BOARD_PLAYER;j<Settings.BOARD_X + Settings.BOARD_PLAYER;j++)
			{
				if(i==Settings.BOARD_Y/2)
				{
					batch.draw(Assets.friver,j*Settings.BLOCK_SIZE,i*Settings.BLOCK_SIZE);
				}
				else
				{
					batch.draw(Assets.fground,j*Settings.BLOCK_SIZE,i*Settings.BLOCK_SIZE);
					if(board.map[i][j - Settings.BOARD_PLAYER]== Settings.F_GRASS)
					{
						batch.draw(Assets.fgrass,j*Settings.BLOCK_SIZE,i*Settings.BLOCK_SIZE);
					}
				}
			}
		}
	}
}
