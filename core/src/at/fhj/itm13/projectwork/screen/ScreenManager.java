package at.fhj.itm13.projectwork.screen;

public class ScreenManager {
	
	private static Screen currentScreen;

	public static Screen getCurrentScreen() {
		return currentScreen;
	}

	public static void setCurrentScreen(Screen currentScreen) {
		ScreenManager.currentScreen = currentScreen;
		currentScreen.create();
	}
	

}
