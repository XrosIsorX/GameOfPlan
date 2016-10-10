package com.mygdx.game;

public class WorldRenderer {
	GameOfPlan game;
	
	public WorldRenderer(GameOfPlan gam){
		this.game = gam;
		Assets.load();
	}
	
	public void grassrender(int countrandomgrass,int[]randomgrass)
	{
		 game.batch.begin();
	     for(int i=0;i<Settings.BOARD_X;i++)
	     {
	    	 for(int j=0;j<Settings.BOARD_Y;j++)
	    	 {
	    		 game.batch.draw(Assets.fground,i*100,j*100);
	    		 for(int k=0;k<10;k++)
	    		 {
	    			 if(randomgrass[k]==countrandomgrass)
	    			 {
	    				 game.batch.draw(Assets.fgrass,i*100,j*100);
	    			 }
	    		 }
	    		 countrandomgrass++;
	    	 }
	    	 countrandomgrass++;
	     }
	     game.batch.end();
	}
}
