package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.*;


public class MyKeyboardHandler implements KeyboardHandler {

	private Keyboard keyboard;
	private Bullet myBullet;
	private Rifle myRifle;
	private int counter = 0;
	private Enemie myEnemie;
	private Player myPlayer;

	public void init() {

		keyboard = new Keyboard(this);
		KeyboardEvent sKey = new KeyboardEvent();

		sKey.setKey(KeyboardEvent.KEY_S);
		sKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


		keyboard.addEventListener(sKey);

	}


	@Override
	public void keyPressed(KeyboardEvent keyboardEvent) {
		if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {

			new Thread(() -> {

				myBullet = new Bullet();
				myBullet.initBullet();

				for (int i = 0; i < myBullet.getMaxAmmo(); i++) {
					myBullet.shootBullet();

//					if (!myEnemie.isDead() && myBullet.getX() >= myEnemie.getX()
//							&& Math.abs(myBullet.getY() - myEnemie.getY()) < 300) {
//
//						myEnemie.delete();
//						break;
//					}

					try {
						Thread.sleep(100);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				myBullet.deleteBullet();
				myEnemie.die();


			}).start();
		}
	}

	@Override
	public void keyReleased(KeyboardEvent keyboardEvent) {

	}

	public void setMyBullet(Bullet myBullet) {
		this.myBullet = myBullet;
	}

	public void setMyRifle(Rifle rifle) {
		this.myRifle = rifle;
	}

	public void setMyEnemie(Enemie enemie){ this.myEnemie = enemie;}

	public void setMyPlayer(Player player) {
		this.myPlayer = player;
	}


	private void delayMethod(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
