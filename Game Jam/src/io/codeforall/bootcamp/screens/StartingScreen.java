package io.codeforall.bootcamp.screens;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.swing.*;
import java.awt.*;

public class StartingScreen {

	private Picture startingScreen;
	private Picture pressStart;

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
