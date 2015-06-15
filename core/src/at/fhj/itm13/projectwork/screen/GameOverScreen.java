package at.fhj.itm13.projectwork.screen;

import at.fhj.itm13.projectwork.ShooterGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class GameOverScreen extends Screen{

	private Stage stage;	
	private Skin skin;
	private Table table;
	private TextButton againButton;
	private TextButton exitButton;
	private TextButton menuButton;
	private Label title;
	
	@Override
	public void create() {
		stage = new Stage(new StretchViewport(ShooterGame.WIDTH, ShooterGame.HEIGHT));
		table = new Table();
		
		//Create Label, and Buttons
		skin = new Skin(Gdx.files.internal("skins/skin.json"), new TextureAtlas(Gdx.files.internal("skins/button.pack")));
		
		title = new Label("Game Over", skin.get("white", LabelStyle.class));
		
		againButton = new TextButton("Try again!", skin);
		
		exitButton = new TextButton("Exit", skin);
		
		menuButton = new TextButton("Back to menu", skin);
		
		// Add Button functionality
		againButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				ScreenManager.getCurrentScreen().dispose();
				ScreenManager.setCurrentScreen(new GameScreen());
			}
		
		});
		exitButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		
		});
		menuButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				ScreenManager.getCurrentScreen().dispose();
				ScreenManager.setCurrentScreen(new MenuScreen());
			}
		
		});
		
		
		// Add Objects into Table
		table.add(title).padBottom(60).row();
		
		table.add(againButton).size(300,60).padBottom(20).row();
		table.add(exitButton).size(300,60).padBottom(20).row();
		table.add(menuButton).size(300,60).padBottom(20).row();
		
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
		stage.getViewport().update(width, height, true);
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
