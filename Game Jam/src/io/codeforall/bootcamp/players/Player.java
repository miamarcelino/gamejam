package io.codeforall.bootcamp.players;

import io.codeforall.bootcamp.bullets.Bullet;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Player {
    private Picture player;
    protected Bullet bullet;
    private boolean canMoveUp = true;
    private boolean canMoveDown = false;

    public Player(Picture picture) {
        this.player = picture;
    }

    public void standardFace() {
    }

    public void shootingFace() {
    }

    public void init() {
        System.out.println("Drawing Player at: " + getX() + ", " + getY());
        player.draw();
    }

    public void moveUp() {
        player.translate(0, -320);
        bullet.moveUp();
    }

    public void moveDown() {
        player.translate(0, 320);
        bullet.moveDown();
    }

    public void stayPut() {
        player.translate(player.getX(), player.getY());
    }

    public boolean canMoveUp() {
        if (player.getY() < 150) {
            canMoveUp = false;
        } else {
            canMoveUp = true;
        }

        return canMoveUp;
    }

    public boolean canMoveDown() {
        if (player.getY() > 550) {
            canMoveDown = false;
        } else {
            return canMoveDown = true;
        }
        return canMoveDown;
    }

    public int getX() {
        return player.getX();
    }

    public int getY() {
        return player.getY();
    }

    public void setPosition(int x, int y) {
        player.translate(x, y);
    }

    public void delete() {
        player.delete();
    }

    public Bullet getBullet(){
        return bullet;
    }
}
