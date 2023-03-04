package Utilities;

import java.awt.Graphics2D;
import java.lang.reflect.InvocationTargetException;

@SuppressWarnings({"serial"})
public class SceneManager extends GDV5{
	static SceneManager sm = new SceneManager();
	Scene currentScene;
	public static void main(String[] args) {
		sm.setup();
	}
	
	private void setup() {
		currentScene.setup();
		sm.setTitle("Breakout Bad");
		sm.start();
		
	}
	@Override
	public void update() {
		if (currentScene.nextScene().getClass() == currentScene.getClass()) {
			currentScene.update();
		} else {
			try {
				currentScene = currentScene.nextScene().getClass().getDeclaredConstructor(SceneManager.class).newInstance(sm);
				currentScene.setup();
			} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			} 
		}
		
	}

	@Override
	public void draw(Graphics2D win) {
		currentScene.draw(win);
	}

}
