package at.fhj.itm13.projectwork.entity;

import at.fhj.itm13.projectwork.AssetManager;
import at.fhj.itm13.projectwork.ShooterGame;
import at.fhj.itm13.projectwork.screen.GameOverScreen;
import at.fhj.itm13.projectwork.screen.ScreenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class EntityManager {

	private final Array<Enemy> enemies = new Array<Enemy>();
	private final Array<Missile> missiles = new Array<Missile>();
	private final Player player = new Player(new Vector2(230, 10), new Vector2(0,0), this);
	private int enemyAmount;
	private long timestamp = 0;
	private boolean gameover = false;
	private int score;
	
	public EntityManager() {
		enemyAmount = 10;
		createEnemies();
	}
	
	public void update() {
		
		if(enemyAmount > enemies.size)
			createEnemies();
		
		player.update();
		for(Enemy e : enemies) {
			e.update();
			collisionDetection(e);
		}
		for(Missile m : missiles) {
			m.update();
			removeMissiles(m);
		}
		
		if(gameover) {
			ScreenManager.getCurrentScreen().dispose();
			ScreenManager.setCurrentScreen(new GameOverScreen());
		}
	}
	
	public void render(SpriteBatch sb) {
		player.render(sb);
		for(Enemy e : enemies) {
			e.render(sb);
		}
		for(Missile m : missiles) {
			m.render(sb);
		}
	}
	
	public void addEnemy(Enemy e) {
		enemies.add(e);	
	}
	
	public void addMissile(Missile m) {
		if(System.currentTimeMillis() >= timestamp + 300) {
			missiles.add(m);
			timestamp = System.currentTimeMillis();
			if(AssetManager.sound)
				AssetManager.SHOOT.play();
		}
	}
	
	public void setEnemyAmount(int amount) {
		enemyAmount = amount;
	}
	
	private void createEnemies() {
		for(int i=0; i<enemyAmount; i++) {
			float x = MathUtils.random(0, ShooterGame.WIDTH - AssetManager.ENEMY.getWidth()); 
			float y = MathUtils.random(ShooterGame.HEIGHT*2, ShooterGame.HEIGHT*3);
			float speed = MathUtils.random(2,5);
			addEnemy((new Enemy(new Vector2(x,y), new Vector2(0, -speed))));
		}
	}
	
	private void collisionDetection(Enemy e) {
		for(Missile m : missiles) {
			if(e.getBounds().overlaps(m.getBounds())) {
				enemies.removeValue(e, false);
				missiles.removeValue(m, false);
				if(AssetManager.sound)
					AssetManager.EXPLOSE.play();
				score += 10;
			}
		}
		if(e.getBounds().overlaps(player.getBounds())) {
			gameover = true;
			if(AssetManager.sound)
				AssetManager.EXPLOSE.play();
			saveScore();
		}
	}
	
	private void removeMissiles(Missile m) {
		if(m.pos.y > ShooterGame.HEIGHT)
			missiles.removeValue(m, false);
	}
	
	public int getScore() {
		return score;
	}
	
	private void saveScore() {
		FileHandle scoreFile = Gdx.files.local("score.txt");	
		FileHandle hscoreFile = Gdx.files.local("highscore.txt");
		if(!hscoreFile.exists())
			hscoreFile.writeString("0", false);
		
		if(score > Integer.parseInt(hscoreFile.readString()))
			hscoreFile.writeString("" + score, false);
		
		scoreFile.writeString("" + score, false);
	}
	
}
