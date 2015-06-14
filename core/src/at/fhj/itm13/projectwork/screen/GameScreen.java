package at.fhj.itm13.projectwork.screen;

import at.fhj.itm13.projectwork.AssetManager;
import at.fhj.itm13.projectwork.ShooterGame;
import at.fhj.itm13.projectwork.entity.EntityManager;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends Screen{

	private OrthographicCamera camera;
	private EntityManager entityManager;
	
	@Override
	public void create() {
		entityManager = new EntityManager();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, ShooterGame.WIDTH, ShooterGame.HEIGHT);
		AssetManager.BGMUSIC.setLooping(true);
		AssetManager.BGMUSIC.play();
	}

	@Override
	public void update() {
		camera.update();
		entityManager.update();
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		entityManager.render(sb);
		sb.end();
		
	}

	@Override
	public void resize(int width, int height) {
		//camera.resize		
	}

	@Override
	public void dispose() {
		AssetManager.BGMUSIC.dispose();
		
	}

	@Override
	public void pause() {
		AssetManager.BGMUSIC.pause();
		
	}

	@Override
	public void resume() {
		AssetManager.BGMUSIC.play();
		
	}

}
