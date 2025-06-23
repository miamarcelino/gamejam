package io.codeforall.bootcamp.bullets;

import io.codeforall.bootcamp.players.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Bullet {

	private Picture bullet;
	private int ammo = 0;
	private final int MAX_AMMO = 6;

	public Bullet(int startX, int startY, String rsc){

		bullet = new Picture(startX, startY, rsc);
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
			bullet.translate(180, 0);

			setAmmo(getAmmo());
		}
	}

	public void deleteBullet(){
		bullet.delete();
		setAmmo(0);
	}

	public void moveUp(){
		bullet.translate(0, -400);
	}

	public void moveDown(){
		bullet.translate(0, 400);
	}

}
