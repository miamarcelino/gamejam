package io.codeforall.bootcamp.screens;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartingScreen {

	private Picture startingScreen;
	private Rectangle textBox;
	private Text instructions;

	public StartingScreen(){
		startingScreen = new Picture(10,10, "resources/Background/starting-screen.png");

	}

	public void load(){
		startingScreen.draw();
		textBox();
	}

	public void delete(){
		startingScreen.delete();
	}

	public void textBox(){
		textBox = new Rectangle(490, 740, 400, 40);
		textBox.fill();
		textBox.setColor(Color.LIGHT_GRAY);
		instructions = new Text(620, 750, "PRESS <SPACE> TO START");
		instructions.draw();
	}

	public void deleteTextBox(){
		textBox.delete();
		instructions.delete();
	}
}
