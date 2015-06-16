package at.fhj.itm13.projectwork;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class AssetManager {
	
	public static Texture PLAYER = new Texture(Gdx.files.internal("images/spaceship0.png"));
	public static Texture ENEMY = new Texture(Gdx.files.internal("images/enemy0.png"));
	public static Texture MISSILE = new Texture(Gdx.files.internal("images/missile.png"));
	
	//public static Texture GAMEOVER = new Texture(Gdx.files.internal("gameover.png"));
	
	public static boolean sound = true;
	
	public static Sound EXPLOSE = Gdx.audio.newSound(Gdx.files.internal("music/explosion.wav"));	//music
	public static Sound SHOOT = Gdx.audio.newSound(Gdx.files.internal("music/laser2.wav"));	//music
	
	public static void setPlayer(Texture texture) {
		PLAYER = texture;
	}
	
	public static void setEnemy(Texture texture) {
		ENEMY = texture;
	}
	

}
