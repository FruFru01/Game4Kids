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
	private TextButton button;
	private TextButtonStyle textButtonStyle;
	private BitmapFont font;
	private Skin skin;
	private TextureAtlas buttonAtlas;
	
	
	@Override
	public void create() {
		//Button
		stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont();
        skin = new Skin();
        //buttonAtlas = new TextureAtlas(Gdx.files.internal("buttons/buttons.pack"));
        //skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = font;/*
        textButtonStyle.up = skin.getDrawable("up-button");
        textButtonStyle.down = skin.getDrawable("down-button");
        textButtonStyle.checked = skin.getDrawable("checked-button");*/
        button = new TextButton("Button1", textButtonStyle);
	}

	@Override
	public void update() {
	}

	@Override
	public void render(SpriteBatch sb) {
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

}
