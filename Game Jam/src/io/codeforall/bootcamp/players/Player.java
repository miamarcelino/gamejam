package io.codeforall.bootcamp.players;

import io.codeforall.bootcamp.bullets.Bullet;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Player {

    protected int x;
    protected int y;
    protected Bullet bullet;
    protected Picture normalFace;
    protected Picture shootingFace;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public abstract void init();

    public abstract void moveUp();
    public abstract void moveDown();

    public abstract void shootingFace();

    public abstract boolean canMoveUp();

    public abstract boolean canMoveDown();

    public abstract int getX();
    public abstract int getY();

    public void delete() {
        normalFace.delete();
        shootingFace.delete();
    }

    public Bullet getBullet() {
        return bullet;
    }

    public Picture getPicture() {
        return normalFace;
    }

    public Bullet createBullet() {
        throw new UnsupportedOperationException("This player cannot shoot!");
    }
}
