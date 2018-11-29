package io.github.armenari.game;

import io.github.armenari.renderer.Renderer;
import io.github.armenari.renderer.Texture;
import io.github.armenari.utils.Constants;
import io.github.armenari.utils.Methods;

public class Entity {

	protected int ID;
	protected float x;
	protected float y;
	protected boolean isSolid;

	protected Texture texture;
	private boolean isAbleToMove;

	public Entity(int ID, float x, float y, boolean isSolid) {
		this.ID = ID;
		this.x = x;
		this.y = y;
	}

	/**
	 * Update the entity
	 */
	public void update() {

	}

	/**
	 * Render the entity
	 */
	public void render() {
		if (texture != null) {
			Renderer.renderOffsetImage(texture, x, y, Constants.ENTITY_SIZE, Constants.ENTITY_SIZE, texture.getWidth(),
					texture.getHeight(), Constants.WHITE, (ID % 6) * 16, (int) (ID / 6) * 16, 16, 16);
		} else {
			texture = Texture.assets;
		}
	}

	/**
	 * @param Entity e
	 * @return true if e collide with this, false otherwise
	 */
	public boolean hasCollision(Entity e) {
		if (Methods.distance(getX() + Constants.ENTITY_SIZE, getY() + Constants.ENTITY_SIZE,
				e.getX() + Constants.ENTITY_SIZE, e.getY() + Constants.ENTITY_SIZE) <= Constants.ENTITY_SIZE) {
			return true;
		}
		return false;
	}

	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the isSolid
	 */
	public boolean isSolid() {
		return isSolid;
	}

	/**
	 * @param isSolid the isSolid to set
	 */
	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}

	/**
	 * @return the texture
	 */
	public Texture getTexture() {
		return texture;
	}

	/**
	 * @param texture the texture to set
	 */
	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	/**
	 * @return the canMove
	 */
	public boolean isAbleToMove() {
		return isAbleToMove;
	}

	/**
	 * @param canMove the canMove to set
	 */
	public void setAbleToMove(boolean canMove) {
		this.isAbleToMove = canMove;
	}

}
