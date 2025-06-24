package io.codeforall.bootcamp.screens;

import io.codeforall.bootcamp.players.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ChoosePlayer {

	private Picture cp;
	private Picture daniel;
	private Player maria;
	private Player gustavo;

	private Picture press1;
	private Picture press2;
	private Picture press3;

	public ChoosePlayer(){
		cp = new Picture(10,10, "resources/Background/choose-player-screen.png");
		daniel = new Picture(100, 280, "resources/Player/Daniel/daniel-still-choose.png");

	}

	public void load(){
		cp.draw();

		press1 = new Picture(120, 200, "resources/Buttons/press-1.png");
		press2 = new Picture(540, 200, "resources/Buttons/press-2.png");
		press3 = new Picture(870, 200, "resources/Buttons/press-3.png");

		press1.draw();
		press2.draw();
		press3.draw();

		daniel.draw();
	}

	public void delete(){
		cp.delete();

		press1.delete();
		press2.delete();
		press3.delete();

		daniel.delete();
	}
}
