package at.fhj.itm13.projectwork;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

public class AssetManager {
	
	public static Texture PLAYER = new Texture(Gdx.files.internal("spaceship.png"));
	public static Texture ENEMY = new Texture(Gdx.files.internal("enemy.png"));
	public static Texture MISSILE = new Texture(Gdx.files.internal("missile.png"));
	
	//public static Music bgmusic = Gdx.audio.newMusic("");	//music
	//bgmusic.setLooping(true);
	//bgmusic.play();

}
