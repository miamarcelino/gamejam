package io.codeforall.bootcamp.bullets;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet {

    private Picture bullet;
    private int startingX;
    private int startingY;

    private int ammo = 0;
    private final int MAX_AMMO = 6;
    private boolean collided = false;

    public Bullet(int startX, int startY, String rsc) {
        this.startingX = startX;
        this.startingY = startY;

        bullet = new Picture(startX, startY, rsc);
    }

    public Bullet createBullet() {
        throw new UnsupportedOperationException("This player cannot shoot!");
    }

    public void initBullet() {
        bullet.draw();
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

    public boolean isCollided() {
        return collided;
    }

    public void setCollided(boolean collided) {
        this.collided = collided;
    }


    public void shootBullet() {

        if (getAmmo() < getMaxAmmo()) {
            int nextX = bullet.getX() + 180;
            int screenLimit = 1024;

            if(nextX < screenLimit) {
                bullet.translate(180, 0);

            } else {
                deleteBullet();             // remove Bullet when out of bounds
            }


            ammo++;
        }
    }

    public void deleteBullet() {
        bullet.delete();
        setAmmo(0);
    }

    public void moveUp() {
        bullet.translate(0, -400);
    }

    public void moveDown() {
        bullet.translate(0, 400);
    }

    public int getMaxX() {
        return bullet.getMaxX();
    }

    public int getWidth() {
        return bullet.getWidth();
    }

    public int getHeight() {
        return bullet.getHeight();
    }

    public int getX() {
        return bullet.getX();
    }

    public int getY() {
        return bullet.getY();
    }

    public void setStartingX(int x) {
        int dx = x - this.startingX;        // Calculate horizontal shift
        bullet.translate(dx, 0);        // Move Bullet accordingly
        this.startingX = x;                 // Update internal X coordinate
    }

    public void setStartingY(int y) {
        int dy = y - this.startingY;        // Calculate vertical shift
        bullet.translate(0, dy);         // Move Bullet accordingly
        this.startingY = y;                 // Update internal Y coordinate
    }

    public void reset(int x, int y) {
        setCollided(false);
        setAmmo(0);
        setStartingX(x);
        setStartingY(y);
        initBullet();
    }

}
