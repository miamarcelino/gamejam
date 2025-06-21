package io.codeforall.bootcamp;

public class Main {
	public static void main(String[] args) {
		Grid grid = new Grid();
		Player p1 = new Player();
		Target t1 = new Target();
		Bullet b1 = new Bullet();

		//Rifle r1 = new Rifle();

		MyKeyboardHandler keyboardHandler = new MyKeyboardHandler();
		keyboardHandler.setMyBullet(b1);
		keyboardHandler.init();
	}
}
