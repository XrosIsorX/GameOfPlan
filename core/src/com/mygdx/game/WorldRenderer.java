package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {
	public SpriteBatch batch;
	public BitmapFont font;
	
	BoardRenderer boardrenderer;
	World world;
	
	public WorldRenderer(GameOfPlan game, World world){
		this.batch = game.batch;
		this.font = game.font;
		boardrenderer = new BoardRenderer(game,world.getBoard());
		this.world = world;
		
	}
	
	public void renderMousePick() {
		batch.setColor(1, 1, 1, 0.5f);
		batch.draw(Assets.pickBoard,world.mouse.getColX(), world.mouse.getRowY());
		batch.setColor(1,1,1,1);
	}
	
	public void pickCharacterrender() {
		if (world.state == Settings.STATE_ACTION) {
			batch.setColor(1, 1, 1, 0.5f);
			batch.draw(Assets.pickCharacter, world.pick.position.x, world.pick.position.y);
			batch.setColor(1,1,1,1);
		}
	}
	
	public void renderBackGround() {
		if (world.turn == Settings.TURN_P1) {
			batch.draw(Assets.turnP1Screen , 0 , 0);
		} 
		if (world.turn == Settings.TURN_P2) {
			batch.draw(Assets.turnP2Screen , 0 , 0);
		}
	}
	
	public void renderItem() {
		for (Character n : world.player1.selectedCharacters) {
			checkItemRender(n.number, n.position.x, n.position.y);
		}
		for (PassiveSkill n : world.player1.selectedPassiveSkills) {
			checkItemRender(n.number, n.position.x, n.position.y);
		}
		
		for (Character n : world.player2.selectedCharacters) {
			checkItemRender(n.number, n.position.x, n.position.y);
		}
		for (PassiveSkill n : world.player2.selectedPassiveSkills) {
			checkItemRender(n.number, n.position.x, n.position.y);
		}
	}

	public void checkItemRender(int number, float x, float y) {
		if (number == Settings.SWORDMAN_NUMBER) {
			batch.draw(Assets.swordman , x, y);
		} else if (number == Settings.WIZARD_NUMBER) {
			batch.draw(Assets.wizard , x, y );
		} else if (number == Settings.MEEP_NUMBER) {
			batch.draw(Assets.meep , x, y );
		} else if (number == Settings.SKULL_NUMBER) {
			batch.draw(Assets.skull, x, y );
		} else if (number == Settings.HPRESTORE_NUMBER) {
			batch.draw(Assets.hpRestore, x, y );
		} else if (number == Settings.MANARESTORE_NUMBER) {
			batch.draw(Assets.manaRestore, x, y );
		} else if (number == Settings.NEXUSP1_NUMBER) {
			batch.draw(Assets.nexusP1, x, y );
		} else if (number == Settings.NEXUSP2_NUMBER) {
			batch.draw(Assets.nexusP2, x, y );
		}
	}
	
	public void renderSpawnMouse() {
		if (world.state == Settings.STATE_SPAWN) {
			checkItemRender(world.pick.number , world.mouse.getX() - (Settings.BLOCK_SIZE / 2) , world.mouse.getY() - (Settings.BLOCK_SIZE / 2));
		}
	}
	
	public void renderAllCharacter() {
		for (Character n : world.player1.characters) {
			checkItemRender(n.number, n.position.x, n.position.y);
		} 
		for (Character n : world.player2.characters) {
			checkItemRender(n.number, n.position.x, n.position.y);
		}
	}
	
	public void renderButton() {
		batch.draw(Assets.buttonEndTurn, Settings.BUTTON_ENDTURNP1_X, Settings.BUTTON_ENDTURN_Y);
		batch.draw(Assets.buttonEndTurn, Settings.BUTTON_ENDTURNP2_X, Settings.BUTTON_ENDTURN_Y);
		if (world.renderFont == Settings.FONT_RENDER_CHARACTER) {
			if (world.turn == Settings.TURN_P1) {
				batch.draw(Assets.buttonSkill, Settings.BUTTON_SKILLP1_X, Settings.BUTTON_SKILL_Y);
			} else if (world.turn == Settings.TURN_P2) {
				batch.draw(Assets.buttonSkill, Settings.BUTTON_SKILLP2_X, Settings.BUTTON_SKILL_Y);
			}
		}
	}

	public void checkCharacterFontRender(Character pick) {
		int x=0;
		if (world.turn == Settings.TURN_P1) {
			x = 20;
		} else if (world.turn == Settings.TURN_P2) {
			x = 916;
		}
		renderCharacterFont(pick.name , pick.cost , pick.hp, pick.mana, pick.atk , pick.atkRange , pick.walk , pick.skillDetail , x , Settings.BOARD_HEIGHT - (2.5f * Settings.BLOCK_SIZE));
	}
	
	public void renderCharacterFont(String name , int cost , int hp, int mana, int atk , int atkRange , int walk , String skill , float x , float y) {
		font.draw(batch , "Name : " + name, x , y);
		font.draw(batch , "Cost : " + cost , x , y - (0.5f * Settings.BLOCK_SIZE));
		font.draw(batch , "Hp : " + hp , x , y - (1f * Settings.BLOCK_SIZE));
		font.draw(batch , "Mana : " + mana , x , y - (1.5f * Settings.BLOCK_SIZE));
		font.draw(batch , "Atk : " + atk , x , y - (2f * Settings.BLOCK_SIZE));
		font.draw(batch , "Atk range : " + atkRange, x , y - (2.5f * Settings.BLOCK_SIZE));
		font.draw(batch , "Walk : " + walk , x , y - (3f * Settings.BLOCK_SIZE));
		font.draw(batch , skill , x , y - (4.0f * Settings.BLOCK_SIZE));
	}
	
	public void checkPassiveSkillFontRender(PassiveSkill passiveSkill) {
		int x=0;
		if (world.turn == Settings.TURN_P1) {
			x = 20;
		} else if (world.turn == Settings.TURN_P2) {
			x = 916;
		}
		renderPassiveSkillFont(passiveSkill.skillDetail, x, Settings.BOARD_HEIGHT - (2.5f * Settings.BLOCK_SIZE));
	}
	
	public void renderPassiveSkillFont(String skillDetail, float x, float y) {
		font.draw(batch , skillDetail, x , y);
	}
	
	public void renderResource() {
		batch.draw(Assets.grass , 20 , 100 , 30 ,30);
		font.draw(batch , "  X     " + world.player1.resource, 60 , 115);
		batch.draw(Assets.grass , 916 , 100 , 30 ,30);
		font.draw(batch , "  X     " + world.player2.resource, 956 , 115);
	}
	
	public void renderSkillSpawn() {
		if (world.state == Settings.STATE_SKILLSPAWN) {
			checkItemRender(world.skillSpawn , world.mouse.getX() - (Settings.BLOCK_SIZE / 2) , world.mouse.getY() - (Settings.BLOCK_SIZE / 2));
		}
	}
	
	public void renderHp() {
		for (Character n : world.player1.characters) {
			font.draw(batch , "" + n.hp, n.position.x + (Settings.BLOCK_SIZE / 2) , n.position.y + (Settings.BLOCK_SIZE / 2));
		}
		for (Character n : world.player2.characters) {
			font.draw(batch , "" + n.hp, n.position.x + (Settings.BLOCK_SIZE / 2) , n.position.y + (Settings.BLOCK_SIZE / 2));
		}
	}
	
	public void renderAction() {
		for (Animation n : world.animations) {
			checkAnimationRender(n.picture, n.position.x, n.position.y);
		}
	}
	
	public void checkAnimationRender(int picture, float x, float y) {
		if (picture == Settings.ANIMATION_ATTACK) {
			batch.draw(Assets.attack, x, y);
		} else if (picture == Settings.ANIMATION_SLASH) {
			batch.draw(Assets.slash, x, y);
		}
	}
	
	public void render()
	{
		batch.begin();
		renderBackGround();
		boardrenderer.render();
		renderButton();
		renderMousePick();
		pickCharacterrender();
		renderSkillSpawn();
		renderItem();
		renderAllCharacter();
		if (world.renderFont == Settings.FONT_RENDER_CHARACTER) {
			checkCharacterFontRender(world.pick);
			renderSpawnMouse();
		} else if (world.renderFont == Settings.FONT_RENDER_PASSIVESKILL) {
			checkPassiveSkillFontRender(world.pickPassiveSkill);
		}
		renderHp();
		renderResource();
		renderAction();
		batch.end();
	}
}
