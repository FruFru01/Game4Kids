package at.fhj.itm13.projectwork.entity;

import at.fhj.itm13.projectwork.AssetManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity {

	public Player(Vector2 pos, Vector2 direction) {
		super(AssetManager.PLAYER, pos, direction);
	}

	@Override
	public void update() {
		pos.add(direction);
		
		if(Gdx.input.isKeyPressed(Keys.A) || Gdx.input.getX()+10 < pos.x) 
			setDirection(-300, 0);
		else if(Gdx.input.isKeyPressed(Keys.D) || Gdx.input.getX() > pos.x + AssetManager.PLAYER.getWidth()+10)
			setDirection(300, 0);
		else
			setDirection(0, 0);
	}

}
