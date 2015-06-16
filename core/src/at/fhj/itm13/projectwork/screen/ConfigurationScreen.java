package at.fhj.itm13.projectwork.screen;

import java.util.HashMap;
import java.util.Map;

import at.fhj.itm13.projectwork.AssetManager;
import at.fhj.itm13.projectwork.ShooterGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class ConfigurationScreen extends Screen{

	private Stage stage;	
	private Skin skin;
	private Table table;
	private TextButton startButton;
	private TextButton backButton;
	private Label title;
	
	private Table shipTable;
	private Map<String, Image> ships;
	private int clickedShip = 100;
	
	private Table enemyTable;
	private Map<String, Image> enemies;
	private int clickedEnemy = 100;
	
	
	@Override
	public void create() {
		ships = new HashMap<String, Image>();
		enemies = new HashMap<String, Image>();
		
		// Add all images to Set
		for(int i=0; i<5; i++) {
			Image ship = new Image();
			ship.setDrawable(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("images/spaceship" + i + ".png")))));
			ships.put(""+i, ship);
		}
		// Add all enemies to Set
		for(int i=0; i<4; i++) {
			Image enemy = new Image();
			enemy.setDrawable(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("images/enemy" + i + ".png")))));
			enemies.put(""+i, enemy);
		}

		stage = new Stage(new StretchViewport(ShooterGame.WIDTH, ShooterGame.HEIGHT));
		table = new Table();
		
		//Create Label, and Buttons
		skin = new Skin(Gdx.files.internal("skins/skin.json"), new TextureAtlas(Gdx.files.internal("skins/button.pack")));
		
		title = new Label("Configure your Game!", skin.get("white", LabelStyle.class));
		
		startButton = new TextButton("Start Game!", skin);
		
		backButton = new TextButton("Back to main menu", skin);
		
		// Add Button functionality
		startButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				ScreenManager.getCurrentScreen().dispose();
				ScreenManager.setCurrentScreen(new GameScreen());
			}
		});
		backButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				ScreenManager.getCurrentScreen().dispose();
				ScreenManager.setCurrentScreen(new MenuScreen());
			}
		});
		
		//Ship Selection
		shipTable = new Table(skin);		
		for(final Map.Entry<String, Image> i: ships.entrySet()) {
			shipTable.add(i.getValue());
			i.getValue().addListener(new ClickListener(){
				@Override
				public void clicked(InputEvent event, float x, float y) {
					AssetManager.setPlayer(new Texture("images/spaceship" + i.getKey() + ".png"));
					i.getValue().moveBy(0, -10);
					if(clickedShip != 100) {
						ships.get(Integer.toString(clickedShip)).moveBy(0, 10);
					}
					clickedShip = Integer.parseInt(i.getKey());
				}
			});
		}
		
		//Enemy Selection
		enemyTable = new Table(skin);		
		for(final Map.Entry<String, Image> i: enemies.entrySet()) {
			enemyTable.add(i.getValue());
			i.getValue().addListener(new ClickListener(){
				@Override
				public void clicked(InputEvent event, float x, float y) {
					AssetManager.setEnemy(new Texture("images/enemy" + i.getKey() + ".png"));
					i.getValue().moveBy(0, -10);
					if(clickedEnemy != 100) {
						enemies.get(Integer.toString(clickedEnemy)).moveBy(0, 10);
					}
					clickedEnemy = Integer.parseInt(i.getKey());
				}
			});
		}
		
		// Add Objects into Table
		table.add(title).padBottom(60).row();
		
		table.add(shipTable).padBottom(20).row();
		table.add(enemyTable).padBottom(20).row();
		
		table.add(startButton).size(350,60).padBottom(20).row();
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
