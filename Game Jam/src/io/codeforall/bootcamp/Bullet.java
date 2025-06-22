package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet extends Rifle{

	private Picture bullet;

	public Bullet(){
		bullet = new Picture(-40, 830, "resources/SniperRifle/Bullets/flyingBullet.png");
	}

	public void initBullet(){
		bullet.draw();
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

	public int getX(){
		return bullet.getX();
	}

	public int getY(){
		return bullet.getY();
	}


}
