package io.github.armenari.game;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;

import io.github.armenari.fx.Particle;
import io.github.armenari.renderer.Renderer;
import io.github.armenari.utils.Constants;

public class Player extends Entity {

	private String name;
	private float dx;
	private float dy;

	private float speed = 0.5f;
	private float drag = 0.90f;
	private float bounce = 1.5f;

	public Player(String name, int ID, float x, float y) {
		super(ID, x, y, true);
		this.name = name;
	}

	@Override
	public void update() {
		Renderer.renderText(this.getName(), x - 2, y - 10, 8);
		if (isAbleToMove()) {
			if (getName().equals("Player 0")) {
				if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
					dy -= speed;
				}

				if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
					dx -= speed;
				}

				if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
					dy += speed;
				}

				if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
					dx += speed;
				}
			} else {

				if (Keyboard.isKeyDown(Keyboard.KEY_I)) {
					dy -= speed;
				}
				if (Keyboard.isKeyDown(Keyboard.KEY_J)) {
					dx -= speed;
				}
				if (Keyboard.isKeyDown(Keyboard.KEY_K)) {
					dy += speed;
				}
				if (Keyboard.isKeyDown(Keyboard.KEY_L)) {
					dx += speed;
				}
			}

		} else {

			dx *= -bounce;
			dy *= -bounce;

		}

		if (x < 0 || x + Constants.ENTITY_SIZE > Constants.WIDTH || y < 0
				|| y + Constants.ENTITY_SIZE > Constants.HEIGHT) {
			dx *= -bounce;
			dy *= -bounce;
		}

		x += dx;
		y += dy;

		if (Math.abs(dx) > 0.01f || Math.abs(dy) > 0.01f) {
			for (int i = 0; i < 2; i++) {
				Game.particles.add(new Particle(35, x, y, new Vector2f(-dx, -dy)));
			}
		}

		dx *= drag;
		dy *= drag;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
