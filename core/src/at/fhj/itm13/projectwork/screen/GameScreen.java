package at.fhj.itm13.projectwork.screen;

import at.fhj.itm13.projectwork.AssetManager;
import at.fhj.itm13.projectwork.ShooterGame;
import at.fhj.itm13.projectwork.entity.EntityManager;

import com.badlogic.gdx.Gdx;
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
		//Gdx.app.debug("DEBUG!", "Game has started");
		if(AssetManager.sound) {
			//Gdx.app.error("DEBUG!", "Music is on!");
			AssetManager.BGMUSIC.setLooping(true);
			AssetManager.BGMUSIC.play();
		}
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

	}

	@Override
	public void dispose() {
		if(AssetManager.sound)
			AssetManager.BGMUSIC.dispose();
		
	}

	@Override
	public void pause() {
		if(AssetManager.sound)
			AssetManager.BGMUSIC.pause();
		
	}

	@Override
	public void resume() {
		if(AssetManager.sound)
			AssetManager.BGMUSIC.play();
		
	}

}
