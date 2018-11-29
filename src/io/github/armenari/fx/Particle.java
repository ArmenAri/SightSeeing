package io.github.armenari.fx;

import java.util.Random;

import org.lwjgl.util.vector.Vector2f;

import io.github.armenari.game.Entity;

public class Particle extends Entity {

	private int lifetime = 6;
	private Vector2f dir;

	public Particle(int ID, float x, float y, Vector2f dir) {
		super(ID, x, y, false);
		this.dir = dir;
	}

	@Override
	public void update() {
		this.setLifetime(this.getLifetime() - 1);

		double rx = new Random().nextGaussian();
		double ry = new Random().nextGaussian();

		this.x += this.dir.x + rx * 2;
		this.y += this.dir.y + ry * 2;
	}

	/**
	 * @return the lifetime
	 */
	public int getLifetime() {
		return lifetime;
	}

	/**
	 * @param lifetime the lifetime to set
	 */
	public void setLifetime(int lifetime) {
		this.lifetime = lifetime;
	}

}
