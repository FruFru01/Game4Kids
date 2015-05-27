package at.fhj.itm13.projectwork.entity;

import at.fhj.itm13.projectwork.AssetManager;

import com.badlogic.gdx.math.Vector2;

public class Missile extends Entity{

	public Missile(Vector2 pos, Vector2 direction) {
		super(AssetManager.MISSILE, pos, direction);
	}

	@Override
	public void update() {
		pos.add(direction);
		
	}

}
