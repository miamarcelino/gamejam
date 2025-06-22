package io.codeforall.bootcamp.screens;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {
	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1080;
	public static final int PADDING = 10;

	private Picture backGround;

	public Grid () {
		Rectangle grid = new Rectangle(PADDING,PADDING, WIDTH, HEIGHT);
		grid.fill();

		//backGround = new Picture(PADDING,PADDING,"resources/Background/background-blueprint.jpg");
	}

	public void load(){
		backGround.draw();
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

}
