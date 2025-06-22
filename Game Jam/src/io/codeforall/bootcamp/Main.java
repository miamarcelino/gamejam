package io.codeforall.bootcamp;

public class Main {
	public static void main(String[] args) {
		Grid grid = new Grid();
		Player p1 = new Player();
		EvilHitler enemy = new EvilHitler();
		Bullet b1 = new Bullet();

		//Rifle r1 = new Rifle();

		MyKeyboardHandler keyboardHandler = new MyKeyboardHandler();
		keyboardHandler.setMyBullet(b1);
		keyboardHandler.setMyEnemie(enemy);
		keyboardHandler.setMyPlayer(p1);
		keyboardHandler.init();
	}
}
