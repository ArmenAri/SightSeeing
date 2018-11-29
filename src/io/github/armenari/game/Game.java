package io.github.armenari.game;

import java.util.ArrayList;

import io.github.armenari.fx.Particle;
import io.github.armenari.game.blocks.Chest;

public class Game {

	public int playerNumber;

	public static ArrayList<Particle> particles = new ArrayList<>();;
	private ArrayList<Entity> entities;
	public static ArrayList<Player> players;

	Chest chest;
	Entity potion;

	public Game(int playerNumber) {
		this.playerNumber = playerNumber;
		entities = new ArrayList<>();
		players = new ArrayList<>();

		chest = new Chest(15, 500, 500);
		potion = new Entity(3, 100, 500, true);

		for (int i = 0; i < this.playerNumber; i++) {
			players.add(new Player("Player " + i, 15 + i, 200 * i + 64, 200 * i + 64));
		}

		entities.add(chest);
		entities.add(potion);
	}

	public void update() {
		checkCollisions();

		for (int i = 0; i < particles.size(); i++) {
			if (particles.get(i).getLifetime() > 0) {
				particles.get(i).update();
			} else {
				particles.remove(i);
			}
		}

		/**
		 * Updating all the entities in the level
		 */
		for (int i = 0; i < this.entities.size(); i++) {
			entities.get(i).update();
		}

		for (int i = 0; i < players.size(); i++) {
			players.get(i).update();
		}

	}

	public void render() {

		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).render();
		}

		/**
		 * Rendering all the entities in the level
		 */
		for (int i = 0; i < this.entities.size(); i++) {
			entities.get(i).render();
		}
		for (int i = 0; i < playerNumber; i++) {
			players.get(i).render();
		}
	}

	private void checkCollisions() {
		for (Player p : players) {
			for (Player e : players) {
				if (e != p) {
					p.setAbleToMove(!p.hasCollision(e));
					if (!p.isAbleToMove()) {
						break;
					}
				}
			}
			if (p.isAbleToMove()) {
				for (Entity e : entities) {
					p.setAbleToMove(!p.hasCollision(e));
					if (!p.isAbleToMove()) {
						break;
					}
				}
			}
		}
	}
}
