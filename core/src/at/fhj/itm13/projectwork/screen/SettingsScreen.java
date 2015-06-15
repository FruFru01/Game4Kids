package at.fhj.itm13.projectwork.screen;

import at.fhj.itm13.projectwork.AssetManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class SettingsScreen extends Screen{

	private Stage stage;	
	private Skin skin;
	private Table table;
	private TextButton soundButton;
	private TextButton languageButton;
	private TextButton backButton;
	private Label title;
	
	@Override
	public void create() {
		
		stage = new Stage();
		table = new Table();
		
		//Create Label, and Buttons
		skin = new Skin(Gdx.files.internal("skins/skin.json"), new TextureAtlas(Gdx.files.internal("skins/button.pack")));
		
		title = new Label("Settings", skin.get("white", LabelStyle.class));
		
		if(AssetManager.sound)
			soundButton = new TextButton("Sound: activated", skin);
		if(!AssetManager.sound)
			soundButton = new TextButton("Sound: deactivated", skin);
		
		languageButton = new TextButton("Language: English", skin);
		
		backButton = new TextButton("Back to main menu", skin);
		
		// Add Button functionality
		soundButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				AssetManager.sound = !AssetManager.sound;
				if(AssetManager.sound) 
					soundButton.setText("Sound: activated");
				if(!AssetManager.sound) 
					soundButton.setText("Sound: deactivated");
			}
		
		});
		languageButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// ToDo: Language switcher
			}
		
		});
		backButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				ScreenManager.getCurrentScreen().dispose();
				ScreenManager.setCurrentScreen(new MenuScreen());
			}
		
		});
		
		
		// Add Objects into Table
		table.add(title).padBottom(60).row();
		
		table.add(soundButton).size(350,60).padBottom(20).row();
		table.add(languageButton).size(350,60).padBottom(20).row();
		table.add(backButton).size(350,60).padBottom(20).row();
		
		table.setFillParent(true);
		stage.addActor(table);
		
		Gdx.input.setInputProcessor(stage);
		
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
