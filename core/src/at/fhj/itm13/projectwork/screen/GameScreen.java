package at.fhj.itm13.projectwork.screen;

import at.fhj.itm13.projectwork.AssetManager;
import at.fhj.itm13.projectwork.ShooterGame;
import at.fhj.itm13.projectwork.entity.EntityManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameScreen extends Screen{

	private OrthographicCamera camera;
	private EntityManager entityManager;
	private Music bgmusic = Gdx.audio.newMusic(Gdx.files.internal("music/bg_music.wav"));
	private Label score;
	private Skin skin;
	
	@Override
	public void create() {
		entityManager = new EntityManager();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, ShooterGame.WIDTH, ShooterGame.HEIGHT);
		
		skin = new Skin(Gdx.files.internal("skins/skin.json"), new TextureAtlas(Gdx.files.internal("skins/button.pack")));
		score = new Label("Score: 0", skin.get("white", LabelStyle.class));
		
		if(AssetManager.sound) {
			if(!bgmusic.isLooping())
				bgmusic.setLooping(true);
			bgmusic.play();
		}
	}

	@Override
	public void update() {
		camera.update();
		score.setText("Score: " + entityManager.getScore());
		entityManager.update();
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		score.draw(sb, 1);
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
