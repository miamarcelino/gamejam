package io.codeforall.bootcamp.screens;

import io.codeforall.bootcamp.shootable.bonus.Elias;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class StartingScreen {

	private Picture startingScreen;
	private Picture pressStart;
	private Elias elias;

	public StartingScreen(){
		startingScreen = new Picture(10,10, "resources/Background/starting-screen.png");
		pressStart = new Picture(430, 550, "resources/Buttons/press-start.png");


	}

	public void load(){
		startingScreen.draw();
		pressStart.draw();
	}

	public void delete(){
		startingScreen.delete();
		pressStart.delete();
	}




}
