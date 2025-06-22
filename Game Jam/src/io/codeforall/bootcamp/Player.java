package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {
	private Picture player;

	public Player() {

		player = new Picture(30,780,"resources/SniperRifle/Player/player.png");

		init();
	}

	public void init(){
		player.draw();
	}
}
