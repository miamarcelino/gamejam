package io.codeforall.bootcamp.screens;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartingScreen {

	private Picture startingScreen;
	private Picture pressStart;

	public StartingScreen(){
		startingScreen = new Picture(10,10, "resources/Background/starting-screen.png");

	}

	public void load(){
		startingScreen.draw();

		pressStart = new Picture()

	}

	public void delete(){
		startingScreen.delete();
	}




}
