package com.mygdx.game;

public abstract class Settings {
	//board and object on board
	static final int BOARD_X = 11;
	static final int BOARD_Y = 11;
	static final int BOARD_WIDTH = 1088;
	static final int BOARD_HEIGHT = 704;
	static final int BOARD_PLAYER = 3;
	static final int BOARD_BLOCK_UPPER = 6;
	static final int BOARD_BLOCK_LOWER = 5;

	static final int BLOCK_SIZE= 64;
	
	static final int FONT_COST_X =20;
	
	static final int FONT_RENDER_NOTHING = 0;
	static final int FONT_RENDER_CHARACTER = 1;
	static final int FONT_RENDER_PASSIVESKILL = 2;
	
	static final int GROUND = 0;
	static final int GRASS = 1;
	static final int RIVER = 2;
	
	static final float BUTTON_SELECTP1_X = 50;
	static final float BUTTON_SELECTP2_X = 946;
	static final float BUTTON_SELECT_Y = 50;
	static final float BUTTON_SELECT_WIDTH = 100;
	static final float BUTTON_SELECT_HEIGHT = 50;
	static final float BUTTON_STARTGAME_X = 375;
	static final float BUTTON_STARTGAME_Y = 50;
	static final float BUTTON_STARTGAME_WIDTH = 300;
	static final float BUTTON_STARTGAME_HEIGHT = 100;
	static final float BUTTON_ENDTURNP1_X = 21;
	static final float BUTTON_ENDTURNP2_X = 917;
	static final float BUTTON_ENDTURN_Y = 20;
	static final float BUTTON_ENDTURN_WIDTH = 150;
	static final float BUTTON_ENDTURN_HEIGHT = 64;
	static final float BUTTON_SKILLP1_X = 20;
	static final float BUTTON_SKILLP2_X = 917;
	static final float BUTTON_SKILL_Y = 325;
	static final float BUTTON_SKILL_WIDTH = 50;
	static final float BUTTON_SKILL_HEIGHT = 30;
	
	static final int NUMBER_GRASS = 10;
	static final int NUMBER_PICKITEM = 3;
	
	static final int WIZARD_NUMBER = 100;
	static final int SWORDMAN_NUMBER = 101;
	static final int MEEP_NUMBER = 200;
	static final int SKULL_NUMBER = 201;
	static final int NEXUSP1_NUMBER = 1000;
	static final int NEXUSP2_NUMBER = 1001;
	static final int MANARESTORE_NUMBER = 2000;
	static final int HPRESTORE_NUMBER = 2001;
	
	static final int NEXUS_HP = 20;
	static final int NEXUS_ATK = 0;
	static final int NEXUS_ATKRANGE = 0;
	static final int NEXUS_WALK = 0;
	static final int NEXUS_COST = 0;
	static final String NEXUS_SKILL = "-";
	
	static final int SWORDMAN_HP = 10;
	static final int SWORDMAN_ATK = 3;
	static final int SWORDMAN_ATKRANGE = 1;
	static final int SWORDMAN_WALK = 2;
	static final int SWORDMAN_COST = 0;
	static final String SWORDMAN_SKILL = "Deal 3 damage around \nitself 2 blocks.";
	static final int SWORDMAN_MANA = 5;
	
	static final int WIZARD_HP = 5;
	static final int WIZARD_ATK = 1;
	static final int WIZARD_ATKRANGE = 2;
	static final int WIZARD_WALK = 3;
	static final int WIZARD_COST = 0;
	static final String WIZARD_SKILL = "Spawn 1 SKULL on the \ntarget block.";
	static final int WIZARD_MANA = 10;
	
	static final int MEEP_HP = 2;
	static final int MEEP_ATK = 2;
	static final int MEEP_ATKRANGE = 1;
	static final int MEEP_WALK = 1;
	static final int MEEP_COST = 2;
	static final String MEEP_SKILL = "-";
	
	static final int SKULL_HP = 3;
	static final int SKULL_ATK = 1;
	static final int SKULL_ATKRANGE = 1;
	static final int SKULL_WALK = 2;
	static final int SKULL_COST = 2;
	static final String SKULL_SKILL = "-";
	
	static final String HPRESTORE_SKILL = "Restore 1 hp for all\n characters' when your\n turn end.";
	
	static final String MANARESTORE_SKILL = "Restore 2 mana for all\n characters' when your\n turn end.";
	
	static final int STATE_STILL = 0;
	static final int STATE_SPAWN = 1;
	static final int STATE_ACTION = 2;
	static final int STATE_SKILLSPAWN = 3;
	
	static final int TURN_P1 = 1;
	static final int TURN_P2 = 2 ;
	
	static final int ANIMATION_ATTACK = 1;
	static final int ANIMATION_SLASH = 2;
	
	//camera
	//static final float SCREEN_X = 880;
	//static final float SCREEN_Y = 880;
}
