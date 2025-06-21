package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player {
	private Rectangle player;

	public Player() {
		player = new Rectangle(50, 950, 100,100);
		player.setColor(Color.BLUE);
		player.draw();
	}
}
