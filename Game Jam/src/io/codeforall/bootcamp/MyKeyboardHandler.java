package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.*;


public class MyKeyboardHandler implements KeyboardHandler {

	private Keyboard keyboard;
	private Bullet myBullet;
	private Rifle myRifle;
	private int counter = 0;

	public void init() {

		keyboard = new Keyboard(this);
		KeyboardEvent sKey = new KeyboardEvent();

		sKey.setKey(KeyboardEvent.KEY_S);
		sKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
		sKey.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);


		keyboard.addEventListener(sKey);

	}


	@Override
	public void keyPressed(KeyboardEvent keyboardEvent) {
		if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {

			myBullet.initBullet();


		}
	}

	@Override
	public void keyReleased(KeyboardEvent keyboardEvent) {
		if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {

			for (int i = 0; i < 9; i++) {
				delayMethod(1000);
				if (myBullet.getAmmo() < myBullet.getMaxAmmo()) {
					myBullet.initBullet();
					myBullet.shootBullet();

				} else if (myBullet.getAmmo() == myBullet.getMaxAmmo()) {
					myBullet.deleteBullet();
					myBullet = new Bullet();
				}
			}
		}
	}

	public void setMyBullet(Bullet myBullet) {
		this.myBullet = myBullet;
	}

	public void setMyRifle(Rifle rifle) {
		this.myRifle = rifle;
	}


	private void delayMethod(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
