package at.fhj.itm13.projectwork.screen;

import at.fhj.itm13.projectwork.AssetManager;
import at.fhj.itm13.projectwork.ShooterGame;
import at.fhj.itm13.projectwork.entity.EntityManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends Screen{

	private OrthographicCamera camera;
	private EntityManager entityManager;
	public Music bgmusic = Gdx.audio.newMusic(Gdx.files.internal("music/bg_music.wav"));
	
	@Override
	public void create() {
		entityManager = new EntityManager();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, ShooterGame.WIDTH, ShooterGame.HEIGHT);
		if(AssetManager.sound) {
			if(!bgmusic.isLooping())
				bgmusic.setLooping(true);
			bgmusic.play();
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
			bgmusic.dispose();
		
	}

	@Override
	public void pause() {
		if(AssetManager.sound)
			bgmusic.pause();
		
	}

	@Override
	public void resume() {
		if(AssetManager.sound)
			bgmusic.play();
		
	}

}
