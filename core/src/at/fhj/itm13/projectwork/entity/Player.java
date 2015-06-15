package at.fhj.itm13.projectwork.entity;

import at.fhj.itm13.projectwork.AssetManager;
import at.fhj.itm13.projectwork.ShooterGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity {
	
	private EntityManager entityManager;

	public Player(Vector2 pos, Vector2 direction, EntityManager entityManager) {
		super(AssetManager.PLAYER, pos, direction);
		this.entityManager = entityManager;
	}

	@Override
	public void update() {
		if(pos.x + direction.x > 0 && pos.x + direction.x < ShooterGame.WIDTH - AssetManager.PLAYER.getWidth())
			pos.add(direction);
		
		int dir = 0;
		if(Gdx.input.getAccelerometerX() > 0.5)
			dir=1;
		if(Gdx.input.getAccelerometerX() < -0.5)
			dir=2;
		
		if(Gdx.input.isTouched() || Gdx.input.isKeyPressed(Keys.SPACE)) 
			entityManager.addMissile(new Missile(new Vector2(pos.x + texture.getWidth()/2-10, pos.y + texture.getHeight()), new Vector2(0, 5))); //-10 = half missile width
		
		
		if(Gdx.input.isKeyPressed(Keys.A) || dir == 1) 
			setDirection(-300, 0);
		else if(Gdx.input.isKeyPressed(Keys.D) || dir == 2)
			setDirection(300, 0);
		else
			setDirection(0, 0);
		
			 
	}

}
