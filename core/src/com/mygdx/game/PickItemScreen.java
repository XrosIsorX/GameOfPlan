package com.mygdx.game;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;

public class PickItemScreen implements Screen{
	GameOfPlan game;
	
	List<Character> characters;
	List<PassiveSkill> passiveSkills;
	
	PickItemScreenPlayer player1;
	PickItemScreenPlayer player2;
	PickItemScreenPlayer ally;

	Rectangle buttonStartGame;
	
	Mouse mouse;
	public int turn =0;
	int pick = 0;
	float pickX = 0;
	float pickY = 0;
	
	public PickItemScreen(GameOfPlan gam) {
		this.game = gam;
		player1 = new PickItemScreenPlayer(Settings.TURN_P1);
		player2 = new PickItemScreenPlayer(Settings.TURN_P2);
		ally = player1;
		mouse = new Mouse();
		setLinkedListItem();
		setButton();
		setItem();
	}
	
	public void setLinkedListItem() {
		characters = new LinkedList<Character>();
		passiveSkills = new LinkedList<PassiveSkill>();
	}
	
	public void setButton() {
		player1.createButtonSelect(Settings.BUTTON_SELECTP1_X, Settings.BUTTON_SELECT_Y);
		player2.createButtonSelect(Settings.BUTTON_SELECTP2_X, Settings.BUTTON_SELECT_Y);
		buttonStartGame = new Rectangle(Settings.BUTTON_STARTGAME_X, Settings.BUTTON_STARTGAME_Y, Settings.BUTTON_STARTGAME_WIDTH, Settings.BUTTON_STARTGAME_HEIGHT);
	}
	
	public void setItem() {
		Swordman swordman = new Swordman(400, 500, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,0);
		characters.add(swordman);
		Wizard wizard = new Wizard(600, 500, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, 0);
		characters.add(wizard);
		Meep meep = new Meep(400, 350, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, 0);
		characters.add(meep);
		Skull skull = new Skull(600, 350, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, 0);
		characters.add(skull);
		HpRestore hpRestore = new HpRestore(400, 200, Settings.BLOCK_SIZE , Settings.BLOCK_SIZE, 0);
		passiveSkills.add(hpRestore);
		ManaRestore manaRestore = new ManaRestore(600, 200, Settings.BLOCK_SIZE , Settings.BLOCK_SIZE, 0);
		passiveSkills.add(manaRestore);
	}
	
	public void updateClick() {
		for (Character n : characters) {
			if (n.bounds.contains(mouse.getX(), mouse.getY())) {
				pick = n.number;
				pickX = n.position.x;
				pickY = n.position.y;
			}
		}
		for (PassiveSkill n : passiveSkills) {
			if (n.bounds.contains(mouse.getX(), mouse.getY())) {
				pick = n.number;
				pickX = n.position.x;
				pickY = n.position.y;
			}
		}
	}
	
	public void updateButtonSelect() {
		if (turn < Settings.NUMBER_PICKITEM * 2) {
			if (ally.buttonSelect.contains(mouse.getX(), mouse.getY())) {
				ally.checkSelectedItemAdd(pick, ally.selectdItemX,  560 - ((turn / 2) * 100));
				turn++;
				if (turn % 2 == 0) {
					ally = player1;
				} else {
					ally = player2;
				}
			}
		}
	}
	
	public void updateButtonStartGame() {
		if (turn == 2 * Settings.NUMBER_PICKITEM) {
			if (buttonStartGame.contains(Gdx.input.getX(), Settings.BOARD_HEIGHT - Gdx.input.getY())) {
				game.setScreen(new GameScreen(game, player1, player2));
	        	dispose();
			}
		}
	}
	
	public void update() {
		if (Gdx.input.justTouched()) {
			updateClick();
			updateButtonSelect();
			updateButtonStartGame();
		}
	}

	@Override
	public void render(float delta) {
		update();
		
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        draw();
	}
	
	public void draw() {
        game.batch.begin();
        renderBackGround();
        renderSlotBlock();
        renderWord();
        renderButton();
        renderCharacter();
        renderPick();
        renderSelectedItem();
        game.batch.end();
	}
	
	public void renderPick() {
		game.batch.setColor(1, 1, 1, 0.5f);
		if(pick != 0) {
			game.batch.draw(Assets.pickBoard, pickX, pickY);
		}
		game.batch.setColor(1, 1, 1, 1);
	}
	
	public void renderCharacter() {
		for(Character n : characters) {
			checkItemRender(n.number, n.position.x, n.position.y);
		}
		for (PassiveSkill n : passiveSkills) {
			checkItemRender(n.number, n.position.x, n.position.y);
		}
	}
	
	public void renderBackGround() {
		game.batch.draw(Assets.pickitemscreen,0 , 0);
	}
	
	public void renderButton() {
		game.batch.draw(Assets.buttonSelect, player1.buttonSelect.x, player1.buttonSelect.y);
		game.batch.draw(Assets.buttonSelect, player2.buttonSelect.x, player2.buttonSelect.y);
		if (turn == 6) {
			game.batch.draw(Assets.buttonStartGame, Settings.BUTTON_STARTGAME_X, Settings.BUTTON_STARTGAME_Y);
		}
	}
	
	public void renderSlotBlock() {
		for (int i = 0; i < Settings.NUMBER_PICKITEM; i++) {
			game.batch.draw(Assets.slotBlock, Settings.SELECTEDITEMP1_X,  560 - (i * 100));
			game.batch.draw(Assets.slotBlock, Settings.SELECTEDITEMP2_X,  560 - (i * 100));
		}
	}
	
	public void renderSelectedItem() {
		int i = 0;
		for (Character n : player1.selectedCharacters) {
			checkItemRender(n.number, n.position.x, n.position.y);
			i++;
		}
		for (PassiveSkill n : player1.selectedPassiveSkills) {
			checkItemRender(n.number, n.position.x, n.position.y);
			i++;
		}
		i = 0;
		for (Character n : player2.selectedCharacters) {
			checkItemRender(n.number, n.position.x, n.position.y);
			i++;
		}
		for (PassiveSkill n : player2.selectedPassiveSkills) {
			checkItemRender(n.number, n.position.x, n.position.y);
			i++;
		}
	}
	
	public void checkItemRender(int number, float x, float y) {
		if (number == 0) {
			game.batch.draw(Assets.slotBlock, x, y);
		} else if (number == Settings.SWORDMAN_NUMBER) {
			game.batch.draw(Assets.swordman, x, y);
		} else if (number == Settings.WIZARD_NUMBER) {
			game.batch.draw(Assets.wizard, x, y);
		} else if (number == Settings.MEEP_NUMBER) {
			game.batch.draw(Assets.meep, x, y);
		} else if (number == Settings.SKULL_NUMBER) {
			game.batch.draw(Assets.skull, x, y);
		} else if (number == Settings.HPRESTORE_NUMBER) {
			game.batch.draw(Assets.hpRestore, x, y);
		} else if (number == Settings.MANARESTORE_NUMBER) {
			game.batch.draw(Assets.manaRestore, x, y);
		}
	}
	
	public void renderWord()
	{
		game.font.draw(game.batch,"Select your items or champion", 450,675);
		
		game.font.draw(game.batch,"Slot 1",20, 600);
		game.font.draw(game.batch,"Slot 1",916, 600);
		game.font.draw(game.batch,"Slot 2",20, 500);
		game.font.draw(game.batch,"Slot 2",916, 500);
		game.font.draw(game.batch,"Slot 3",20, 400);
		game.font.draw(game.batch,"Slot 3",916, 400);
		
		game.font.draw(game.batch,"Champions",500, 600);
		game.font.draw(game.batch,"Minions",510, 450);
		game.font.draw(game.batch,"Skills",515, 300);
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
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
}
