package at.fhj.itm13.projectwork.entity;

import at.fhj.itm13.projectwork.AssetManager;
import at.fhj.itm13.projectwork.ShooterGame;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends Entity{

	public Enemy(Vector2 pos, Vector2 direction) {
		super(AssetManager.ENEMY, pos, direction);
	}

	@Override
	public void update() {
		pos.add(direction);
		
		if(pos.y < 0 - AssetManager.ENEMY.getHeight()) {
			float x = MathUtils.random(0, ShooterGame.WIDTH - AssetManager.ENEMY.getWidth());
			pos.set(x, ShooterGame.HEIGHT);  
		}
	}

}
