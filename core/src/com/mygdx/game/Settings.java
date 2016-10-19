package com.mygdx.game;

public abstract class Settings {
	//board and object on board
	static final int BOARD_X = 11;
	static final int BOARD_Y = 11;
	static final int BOARD_WIDTH = 1088;
	static final int BOARD_HEIGHT = 704;

	static final int BLOCK_SIZE= 64;
	
	static final int HP_SKELETON =10;
	
	static final int F_GRASS = 1;
	
	static final float B_SELECTP1_X = 50;
	static final float B_SELECTP2_X = 946;
	static final float B_SELECT_Y = 50;
	static final float B_SELECT_WIDTH = 100;
	static final float B_SELECT_HEIGHT = 50;
	static final float B_STARTGAME_X = 375;
	static final float B_STARTGAME_Y = 50;
	static final float B_STARTGAME_WIDTH = 300;
	static final float B_STARTGAME_HEIGHT = 100;
	
	static final int NUMBER_GRASS= 10;
	static final int NUMBER_PICKITEM = 3;
	
	static final int C_WIZARD = 100;
	static final int C_SWORDMAN = 101;
	static final int C_MON1 = 200;
	static final int C_MON2 = 201;
	
	static final int SWORDMAN_HP = 10;
	static final int SWORDMAN_ATK = 3;
	static final int SWORDMAN_ATKRANK = 1;
	static final int SWORDMAN_WALK = 2;
	
	static final int WIZARD_HP = 5;
	static final int WIZARD_ATK = 1;
	static final int WIZARD_ATKRANK = 2;
	static final int WIZARD_WALK = 3;
	
	static final int MON1_HP = 2;
	static final int MON1_ATK = 2;
	static final int MON1_ATKRANK = 1;
	static final int MON1_WALK = 1;
	
	static final int MON2_HP = 3;
	static final int MON2_ATK = 1;
	static final int MON2_ATKRANK = 1;
	static final int MON2_WALK = 2;
	
	static final int S_HEALTH = 300;
	static final int S_MANA = 301;
	
	static final int STATE_STILL = 0;
	static final int STATE_SPAWN = 1;
	
	//camera
	//static final float SCREEN_X = 880;
	//static final float SCREEN_Y = 880;
}
