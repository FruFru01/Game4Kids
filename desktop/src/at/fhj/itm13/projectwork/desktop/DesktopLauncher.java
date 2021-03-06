package at.fhj.itm13.projectwork.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import at.fhj.itm13.projectwork.ShooterGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "ShooterGame";
		config.height = ShooterGame.HEIGHT;
		config.width = ShooterGame.WIDTH;
		new LwjglApplication(new ShooterGame(), config);
	}
}
