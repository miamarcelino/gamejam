package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Target {

	public Target(){
		Rectangle target = new Rectangle(1790, 950, 100, 100);

		target.setColor(Color.RED);
		target.fill();

	}
}
