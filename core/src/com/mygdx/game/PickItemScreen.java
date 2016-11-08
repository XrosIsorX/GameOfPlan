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
	public List<Character> characterSelectedP1;
	public List<Character> characterSelectedP2;
	
	Character pick;

	Rectangle buttonSelectP1;
	Rectangle buttonSelectP2;
	Rectangle buttonStartGame;
	
	public int turn =0;
	
	public PickItemScreen(GameOfPlan gam) {
		this.game = gam;
		
		characters = new LinkedList<Character>();
		characterSelectedP1 = new LinkedList<Character>();
		characterSelectedP2 = new LinkedList<Character>();
		
		buttonSelectP1 = new Rectangle(Settings.BUTTON_SELECTP1_X ,Settings.BUTTON_SELECT_Y, Settings.BUTTON_SELECT_WIDTH, Settings.BUTTON_SELECT_HEIGHT);
		buttonSelectP2 = new Rectangle(Settings.BUTTON_SELECTP2_X ,Settings.BUTTON_SELECT_Y, Settings.BUTTON_SELECT_WIDTH, Settings.BUTTON_SELECT_HEIGHT);
		buttonStartGame = new Rectangle(Settings.BUTTON_STARTGAME_X, Settings.BUTTON_STARTGAME_Y, Settings.BUTTON_STARTGAME_WIDTH, Settings.BUTTON_STARTGAME_HEIGHT);

		setCharacter();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	public void setCharacter() {
		Swordman swordman = new Swordman(400, 500, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, Settings.SWORDMAN_NUMBER ,0);
		characters.add(swordman);
		Wizard wizard = new Wizard(600, 500, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, Settings.WIZARD_NUMBER, 0);
		characters.add(wizard);
		Meep meep = new Meep(400, 350, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, Settings.MEEP_NUMBER, 0);
		characters.add(meep);
		Skull skull = new Skull(600, 350, Settings.BLOCK_SIZE, Settings.BLOCK_SIZE, Settings.SKULL_NUMBER, 0);
		characters.add(skull);
		Character healPassive = new Character(400, 200, Settings.BLOCK_SIZE , Settings.BLOCK_SIZE, Settings.HPRESTORE_NUMBER);
		characters.add(healPassive);
		Character manaPassive = new Character(600, 200, Settings.BLOCK_SIZE , Settings.BLOCK_SIZE, Settings.MANARESTORE_NUMBER);
		characters.add(manaPassive);
	}
	
	public void updateClick() {
		if (Gdx.input.justTouched()) {
			for (Character n : characters) {
				if (n.bounds.contains(Gdx.input.getX(),Settings.BOARD_HEIGHT - Gdx.input.getY())) {
					pick = n;
				}
			}
		}
	}
	
	public void updateButtonSelect() {
		if (turn < Settings.NUMBER_PICKITEM * 2) {
			if (Gdx.input.justTouched()) {
				if (turn % 2 ==0) {
					if (buttonSelectP1.contains(Gdx.input.getX(), Settings.BOARD_HEIGHT - Gdx.input.getY())) {
						characterSelectedP1.add(pick);
						turn++;
					}
				} else {
					if (buttonSelectP2.contains(Gdx.input.getX(), Settings.BOARD_HEIGHT - Gdx.input.getY())) {
						characterSelectedP2.add(pick);
						turn++;
					}
				}
			}
		}
	}
	
	public void updateButtonStartGame() {
		if (turn == 6) {
			if (Gdx.input.justTouched()) {
				if (buttonStartGame.contains(Gdx.input.getX(), Settings.BOARD_HEIGHT - Gdx.input.getY())) {
					game.setScreen(new GameScreen(game, characterSelectedP1, characterSelectedP2));
		        	dispose();
				}
			}
		}
	}
	
	public void update()
	{
		updateClick();
		updateButtonSelect();
		updateButtonStartGame();
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
        game.batch.end();
	}
	
	public void renderPick() {
		if (pick != null) {
			game.batch.setColor(1, 1, 1, 0.5f);
			game.batch.draw(Assets.pickBoard, pick.position.x, pick.position.y);
			game.batch.setColor(1, 1, 1, 1);
		}
	}
	
	public void renderCharacter() {
		for(Character n : characters) {
			if (n.number == Settings.SWORDMAN_NUMBER) {
				game.batch.draw(Assets.swordman, n.position.x, n.position.y);
			} else if (n.number == Settings.WIZARD_NUMBER) {
				game.batch.draw(Assets.wizard, n.position.x, n.position.y);
			} else if (n.number == Settings.MEEP_NUMBER) {
				game.batch.draw(Assets.meep, n.position.x, n.position.y);
			} else if (n.number == Settings.SKULL_NUMBER) {
				game.batch.draw(Assets.skull, n.position.x, n.position.y);
			} else if (n.number == Settings.MANARESTORE_NUMBER) {
				game.batch.draw(Assets.manaRestore, n.position.x, n.position.y);
			} else if (n.number == Settings.HPRESTORE_NUMBER) {
				game.batch.draw(Assets.hpRestore, n.position.x, n.position.y);
			}
		}
	}
	
	public void renderBackGround() {
		game.batch.draw(Assets.pickitemscreen,0 , 0);
	}
	
	public void renderButton() {
		game.batch.draw(Assets.buttonSelect, Settings.BUTTON_SELECTP1_X, Settings.BUTTON_SELECT_Y);
		game.batch.draw(Assets.buttonSelect, Settings.BUTTON_SELECTP2_X, Settings.BUTTON_SELECT_Y);
		if (turn == 6) {
			game.batch.draw(Assets.buttonStartGame, Settings.BUTTON_STARTGAME_X, Settings.BUTTON_STARTGAME_Y);
		}
	}
	
	public void renderSlotBlock() {
		for (Character n : characterSelectedP1) {
			int i = 0;
			checkItemRender(n, 100,  560 - (i * 100));
			i++;
		}
		for (Character n : characterSelectedP2) {
			int i = 0;
			checkItemRender(n, 986,  560 - (i * 100));
			i++;
		}
	}
	
	public void checkItemRender(Character item, float x, float y) {
		if (item == null) {
			game.batch.draw(Assets.slotBlock, x, y);
		} else if (item.number == Settings.SWORDMAN_NUMBER) {
			game.batch.draw(Assets.swordman, x, y);
		} else if (item.number == Settings.WIZARD_NUMBER) {
			game.batch.draw(Assets.wizard, x, y);
		} else if (item.number == Settings.MEEP_NUMBER) {
			game.batch.draw(Assets.meep, x, y);
		} else if (item.number == Settings.SKULL_NUMBER) {
			game.batch.draw(Assets.skull, x, y);
		} else if (item.number == Settings.HPRESTORE_NUMBER) {
			game.batch.draw(Assets.hpRestore, x, y);
		} else if (item.number == Settings.MANARESTORE_NUMBER) {
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
}
