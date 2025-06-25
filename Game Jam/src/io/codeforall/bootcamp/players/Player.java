package io.codeforall.bootcamp.players;

import io.codeforall.bootcamp.bullets.Bullet;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Player {

    protected int x;
    protected int y;
    protected int moveAmount = 320;
    protected Bullet bullet;
    protected Picture normalFace;
    protected Picture shootingFace;

    public Player(int x, int y, String normalFacePath, String shootingFacePath, Bullet bullet) {
        this.x = x;
        this.y = y;
        this.normalFace = new Picture(x, y, normalFacePath);
        this.shootingFace = new Picture(x, y, shootingFacePath);
        this.bullet = bullet;
    }

    public void standardFace() {
    }

    public void shootingFace() {
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public void init() {
        System.out.println("Drawing Player at: " + getX() + ", " + getY());
        normalFace.draw();
    }

    public void moveUp() {
        if (!canMoveUp()) {
            return;
        }
        normalFace.translate(0, -moveAmount);
        shootingFace.translate(0, -moveAmount);
        y -= moveAmount;
        bullet.moveUp();
    }

    public void moveDown() {
        if (!canMoveDown()) {
            return;
        }
        normalFace.translate(0, moveAmount);
        shootingFace.translate(0, moveAmount);
        y += moveAmount;
        bullet.moveDown();
    }

    public void setShootingFace() {
        normalFace.delete();
        shootingFace = new Picture(x, y, "resources/Player/Daniel/daniel-shooting.png");
        shootingFace.draw();

        new Thread(() -> {

            try {
                Thread.sleep(200);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            shootingFace.delete();
            normalFace = new Picture(x, y, "resources/Player/Daniel/daniel-still.png");
            normalFace.draw();

        }).start();
    }

    public boolean canMoveUp() {
       return y - moveAmount >= 10;
    }

    public boolean canMoveDown() {
       return y + moveAmount <= 700;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void delete() {
        normalFace.delete();
        shootingFace.delete();
    }

    public Bullet getBullet() {
        return bullet;
    }
}
