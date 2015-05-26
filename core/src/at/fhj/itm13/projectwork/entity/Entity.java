package at.fhj.itm13.projectwork.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
	
	protected Texture texture;
	protected Vector2 pos, direction;
	
	public Entity(Texture texture, Vector2 pos, Vector2 direction) {
		this.texture = texture;
		this.pos = pos;
		this.direction = direction;
	}
	
	public abstract void update();
	
	public void render(SpriteBatch sb) {
		
	}
	
	public Vector2 getPosition() {
		return pos;
	}
	
}
