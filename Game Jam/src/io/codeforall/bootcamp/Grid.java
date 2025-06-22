package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {
	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1080;
	public static final int PADDING = 10;

	public Grid () {
		Rectangle grid = new Rectangle(PADDING,PADDING, WIDTH, HEIGHT);
		grid.fill();

		Picture backGround = new Picture(PADDING,PADDING,"resources/SniperRifle/Background/gameBackground.png");
		backGround.draw();
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

}
