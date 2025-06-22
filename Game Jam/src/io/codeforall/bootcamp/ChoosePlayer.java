package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ChoosePlayer {

	private Picture cp;

	public ChoosePlayer(){
		cp = new Picture(10,10, "resources/Background/choose-player-screen.png");
	}

	public void load(){
		cp.draw();
	}

	public void delete(){
		cp.delete();
	}
}
