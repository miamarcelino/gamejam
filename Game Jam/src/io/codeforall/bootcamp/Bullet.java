package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Bullet {

	private Picture bullet;
	private int ammo = 0;
	private final int MAX_AMMO = 6;

	public Bullet(){

		bullet = new Picture(-40, 780, "resources/Bullets/flyingBullet.png");
	}

	public void initBullet(){
		bullet.draw();
	}

	public int getMaxAmmo(){
		return MAX_AMMO;
	}

	public int getAmmo(){
		return ammo;
	}

	public void setAmmo(int ammo){
		this.ammo = ammo;
	}

	public boolean hasAmmo(){
		return ammo == MAX_AMMO;
	}

	public void shootBullet(){
		if (getAmmo() < getMaxAmmo()) {
			bullet.translate(300, 0);

			setAmmo(getAmmo()+1);
		}

		System.out.println("Disparei " + getAmmo() + " vezes");
	}

	public void deleteBullet(){
		bullet.delete();
		setAmmo(-1);
	}

	public void moveUp(){
		bullet.translate(0, -400);
	}

	public void moveDown(){
		bullet.translate(0, 400);
	}

}
