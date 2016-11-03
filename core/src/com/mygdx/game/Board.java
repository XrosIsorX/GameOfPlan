package com.mygdx.game;

import com.badlogic.gdx.math.MathUtils;

public class Board {
	
	private GameOfPlan game;
	
	public short [][] map;
	
	public Board()
	{
		map = new short[Settings.BOARD_Y][Settings.BOARD_X]; 
		setGrass();
	}
	
	private void setGrass1()
	{
		map[0][0] = Settings.F_GRASS;
	}
	
	private void setGrass()
	{
		for(int i=0;i<Settings.NUMBER_GRASS/2;i++)
		{
			int r = MathUtils.random(0,(Settings.BOARD_Y/2)-1); 
			int c = MathUtils.random(0,Settings.BOARD_X-1);
			map[r][c]=Settings.F_GRASS;
		}
		for(int i=0;i<Settings.NUMBER_GRASS/2;i++)
		{
			int r = MathUtils.random((Settings.BOARD_Y/2)+1,Settings.BOARD_Y-1); 
			int c = MathUtils.random(0,Settings.BOARD_X-1);
			map[r][c]=Settings.F_GRASS;
		}
	}
}
