package io.codeforall.bootcamp;

public class Game {
	StartingScreen sc;
	ChoosePlayer cp;
	PlayArea pa;
	Grid grid;
	Player p1;
	Enemy enemy;
	Bullet b1;
	MyKeyboardHandler keyboardHandler;

	public Game(){

		pa = new PlayArea();
		pa.load();
		cp = new ChoosePlayer();
		cp.load();
		sc = new StartingScreen();
		sc.load();




		//grid = new Grid();
		keyboardHandler = new MyKeyboardHandler();
		b1 = keyboardHandler.getMyBullet();
		p1 = new Player(b1);
		enemy = new EvilHitler();

//		switch(enemy){
//			case (enemy instanceof EvilHitler):
//				new EvilHitler();
//				break;
//		}
	}

	public void start() {
		keyboardHandler.setStartingScreen(sc);
		keyboardHandler.setChoosePlayer(cp);
		keyboardHandler.setMyPlayArea(pa);
		keyboardHandler.setMyBullet(b1);
		keyboardHandler.setMyEnemy(enemy);
		keyboardHandler.setMyPlayer(p1);
		keyboardHandler.init();
	}
}
