package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PlayArea {

	private Picture playArea;

	public PlayArea(){
		playArea = new Picture(10, 10, "resources/Background/background-blueprint.png");
	}

	public void load(){
		playArea.draw();
	}

	public void delete(){
		playArea.delete();
	}
}
