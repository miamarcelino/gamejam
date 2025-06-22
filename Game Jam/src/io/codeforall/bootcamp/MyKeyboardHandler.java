package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class MyKeyboardHandler implements KeyboardHandler {

	private Keyboard keyboard;
	private Bullet myBullet;
	private Enemy myEnemy;
	private Player myPlayer;
	private StartingScreen mySC;
	private ChoosePlayer myCP;

	public void init() {

		keyboard = new Keyboard(this);
		KeyboardEvent spaceKey = new KeyboardEvent();
		KeyboardEvent sKey = new KeyboardEvent();
		KeyboardEvent upKey = new KeyboardEvent();
		KeyboardEvent downKey = new KeyboardEvent();

		spaceKey.setKey(KeyboardEvent.KEY_SPACE);
		spaceKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

		sKey.setKey(KeyboardEvent.KEY_S);
		sKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

		upKey.setKey(KeyboardEvent.KEY_UP);
		upKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

		downKey.setKey(KeyboardEvent.KEY_DOWN);
		downKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

		keyboard.addEventListener(spaceKey);
		keyboard.addEventListener(sKey);
		keyboard.addEventListener(upKey);
		keyboard.addEventListener(downKey);
	}


	@Override
	public void keyPressed(KeyboardEvent keyboardEvent) {

		switch (keyboardEvent.getKey()) {

			case KeyboardEvent.KEY_SPACE:
				mySC.delete();
				myCP.load();
				break;

			case KeyboardEvent.KEY_S:
				new Thread(() -> {

					myBullet = new Bullet();
					myBullet.initBullet();
					myPlayer.shootingFace();

					for (int i = 0; i < myBullet.getMaxAmmo(); i++) {
						myBullet.shootBullet();


						try {
							Thread.sleep(60);

						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					myBullet.deleteBullet();
					myEnemy.die();
					myPlayer.standardFace();


				}).start();
				break;

			case KeyboardEvent.KEY_UP:
				myPlayer.moveUp();
				break;

			case KeyboardEvent.KEY_DOWN:
				myPlayer.moveDown();
				break;
		}

	}

	@Override
	public void keyReleased(KeyboardEvent keyboardEvent) {

	}

	public void setMyBullet(Bullet myBullet) {
		this.myBullet = myBullet;
	}

	public void setMyEnemy(Enemy enemy) {
		this.myEnemy = enemy;
	}

	public void setMyPlayer(Player player) {
		this.myPlayer = player;
	}

	public Bullet getMyBullet(){
		return myBullet;
	}

	public void setStartingScreen(StartingScreen sc){
		this.mySC = sc;
	}
}
