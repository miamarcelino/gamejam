package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartingScreen {

	private Picture startingScreen;

	public StartingScreen(){
		startingScreen = new Picture(10,10, "resources/Background/starting-screen.png");
	}

	public void load(){
		startingScreen.draw();
	}

	public void delete(){
		startingScreen.delete();
	}
}
