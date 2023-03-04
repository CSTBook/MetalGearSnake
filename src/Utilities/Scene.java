package Utilities;

import java.awt.Graphics2D;

public abstract class Scene {
	public String title;
	public abstract void update();
	public abstract void draw(Graphics2D win);
	public abstract void setup();
	public abstract Scene nextScene();
}
