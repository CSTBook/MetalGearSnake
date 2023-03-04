package Utilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Misc {
	private static AudioInputStream audioIn;
	private static Clip clip;
	/*
	 * Draws a hitbox surrounding an object, used for debug purposes
	 * Currently only works for objects extending Rectangle
	 */
	public static <T extends Rectangle> void drawHitbox(Graphics2D win, T obj, int sp) {
		Color tc = win.getColor();
		win.setColor(Color.yellow);
		win.drawRect((int)obj.getX()-sp, (int)obj.getY()-sp, obj.width + 2*sp, obj.height+2*sp);
		win.setColor(tc);
	}
	public static <T extends Rectangle> void drawHitbox(Graphics2D win, T obj, int sp, Color cl) {
		Color tc = win.getColor();
		win.setColor(cl);
		win.drawRect((int)obj.getX()-sp, (int)obj.getY()-sp, obj.width + 2*sp, obj.height+2*sp);
		win.setColor(tc);
	}
	
	//check for collision between two objects
	public static <T extends Rectangle,U extends Rectangle> int checkHitbox(T obj1, U obj2, int error, int dX, int dY) {
		if ((new Rectangle((int)obj1.getX()-error, (int)obj1.getY()-error, obj1.width+error, obj1.height+error)).intersects((new Rectangle((int)obj2.getX()-error, (int)obj2.getY()-error, obj2.width+error, obj2.height+error)))) {
			return SceneManager.collisionDirection(obj1, obj2, dX, dY);
		}
		
		return -1;
	}
	
	public static void playSound(String soundFile){
		File f = new File("src/resources/" + soundFile);
		try {
			audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void stopSounds() {
		clip.stop();
		clip.close();
		
	}
	public static void drawImage(String name, double size, int x, int y, Graphics2D win, SceneManager sm) {
		try {
		BufferedImage outImage = sm.addImage("src/resources/"+name);
		Image resImage = outImage.getScaledInstance((int)(outImage.getWidth()*size), (int)(outImage.getHeight()*size), Image.SCALE_DEFAULT);
		win.drawImage(resImage, x, y, sm);
		} catch (IllegalArgumentException e) {
			//dw about it
		} catch (NullPointerException e) {
			//dw about it
		}
	}
	//return if mouse is hovering on area
	public static boolean isHovering(int x1, int y1, int x2, int y2, SceneManager sm) {
		return (sm.getMousePosition()!=null) && (sm.getMousePosition().x <= x2 && sm.getMousePosition().x >= x1 && sm.getMousePosition().y <= y2 && sm.getMousePosition().y >= y1);
	}
	
	//add custom font
	public static Font addFont(String fontFile) {
		Font newFont = null;
		try {
			newFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontFile)).deriveFont(30f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(newFont);
		} catch (IOException | FontFormatException e) {
			System.out.println("couldnt load font");
		}
		return newFont;
	}
}
