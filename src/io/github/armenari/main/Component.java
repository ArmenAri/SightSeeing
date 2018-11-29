package io.github.armenari.main;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import io.github.armenari.game.Game;
import io.github.armenari.renderer.Renderer;
import io.github.armenari.utils.Constants;

public class Component {

	Game game;

	public Component(int playerNumber) {
		game = new Game(playerNumber);
	}

	private void createDisplay(String title, int width, int height) {
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(title);
			Display.setVSyncEnabled(true);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		Renderer.init();
	}

	public void update() {
		game.update();
	}

	public void render() {
		game.render();
	}

	private void start() {
		while (!Display.isCloseRequested()) {
			Renderer.clear();
			update();
			render();
			Display.update();
			Display.sync(Constants.FPS);
		}
		Display.destroy();
		System.exit(0);
	}

	public static void main(String[] args) {
		if(Integer.parseInt(args[0]) != 2) {
			System.err.println("Player number must be 2 !");
		} else {
			Component main = new Component(Integer.parseInt(args[0]));
			main.createDisplay(Constants.TITLE, Constants.WIDTH, Constants.HEIGHT);
			main.start();
		}
	}
}
