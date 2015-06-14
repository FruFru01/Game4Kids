package at.fhj.itm13.projectwork;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class AssetManager {
	
	public static Texture PLAYER = new Texture(Gdx.files.internal("spaceship.png"));
	public static Texture ENEMY = new Texture(Gdx.files.internal("enemy.png"));
	public static Texture MISSILE = new Texture(Gdx.files.internal("missile.png"));
	
	//public static Texture GAMEOVER = new Texture(Gdx.files.internal("gameover.png"));
	
	public static Music BGMUSIC = Gdx.audio.newMusic(Gdx.files.internal("bg_music.wav"));	//music
	public static Sound EXPLOSE = Gdx.audio.newSound(Gdx.files.internal("explosion.wav"));	//music
	public static Sound SHOOT = Gdx.audio.newSound(Gdx.files.internal("laser2.wav"));	//music

}
