package at.fhj.itm13.projectwork.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class GameOverScreen extends Screen{

	private Stage stage;	
	private Skin skin;
	
	@Override
	public void create() {
		stage = new Stage();
		skin = new Skin();
	}

	@Override
	public void update() {
	}

	@Override
	public void render(SpriteBatch sb) {
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

}
