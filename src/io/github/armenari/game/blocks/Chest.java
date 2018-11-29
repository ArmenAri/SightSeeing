package io.github.armenari.game.blocks;

import io.github.armenari.game.Entity;
import io.github.armenari.game.Game;
import io.github.armenari.renderer.Renderer;
import io.github.armenari.utils.Constants;
import io.github.armenari.utils.Methods;

public class Chest extends Entity{

	public Chest(int ID, float x, float y) {
		super(ID, x, y, true);
	}
	
	@Override
	public void update() {
		float d = (float) Methods.distance(x, y, Game.players.get(0).getX(), Game.players.get(0).getY());
		if(d < 128) {
			Renderer.renderText("Press E", x - 6, y - 10, 10, Constants.WHITE);
		}
	}

}
