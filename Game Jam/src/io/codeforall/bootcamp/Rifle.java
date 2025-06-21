package io.codeforall.bootcamp;

public class Rifle {

	private Bullet myBullet;
	private int ammo = 0;
	private final int MAX_AMMO = 8;

//	public Rifle () {
//		myBullet = new Bullet();
//		myBullet.initBullet();
//	}

	public void keepShooting() {


		if (ammo < MAX_AMMO) {
			//delayMethod(1000);
			myBullet.shootBullet();
			ammo++;

		} else {
			myBullet.deleteBullet();
		}
	}

	public int getMaxAmmo() {
		return MAX_AMMO;
	}

	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}

	public boolean hasAmmo() {
		return ammo == MAX_AMMO;
	}

	private void delayMethod(int ms) {

		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
