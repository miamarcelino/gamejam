package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {
	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1080;
	public static final int PADDING = 10;

	public Grid () {
		Rectangle grid = new Rectangle(PADDING,PADDING, WIDTH, HEIGHT);
		grid.fill();
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

}
