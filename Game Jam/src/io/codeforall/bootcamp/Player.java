package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {
	private Picture player;
	private Bullet bullet;


	public Player(Bullet bullet) {

		player = new Picture(30,780,"resources/Player/daniel-still.png");
		this.bullet = bullet;

		init();
	}
	public void standardFace(){
		player.load("resources/Player/daniel-still.png");
	}
	public void shootingFace(){
		player.load("resources/Player/daniel-shooting.png");
	}
	public void init(){
		player.draw();
	}

	public void moveUp(){
		player.translate(0, -400);
		bullet.moveUp();
	}

	public void moveDown(){
		player.translate(0, 400);
		bullet.moveDown();
	}

	public void stayPut(){
		player.translate(player.getX(), player.getY());
	}


	public int getX(){
		return player.getX();
	}

	public int getY() {
		return player.getY();
	}
}
