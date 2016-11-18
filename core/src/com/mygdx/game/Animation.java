package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Animation {
	public long time;
	public long outTime;
	public int picture;
	public final Vector2 position;
	
	public Animation(float x, float y, long outTime, int picture) {
		this.position = new Vector2(x, y);
		time = System.currentTimeMillis();
		this.outTime = outTime + time;
		this.picture = picture;
	}
	
	public void updateTime() {
		time = System.currentTimeMillis();
		if (outTime - time <= 0) {
			World.animations.remove(this);
		}
	}

}
