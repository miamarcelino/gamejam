package io.codeforall.bootcamp.shootable.enemies;

import io.codeforall.bootcamp.CollisionDetector;
import io.codeforall.bootcamp.shootable.Target;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy implements Target {

    protected Picture enemie;
    private boolean dead;
    private CollisionDetector collisionDetector;

    public Enemy(int x, int y, String src) {
        this.enemie = new Picture(x, y, src);
        dead = false;
    }


    @Override
    public void init() {
        enemie.draw();
    }

    @Override
    public void delete() {
        enemie.delete();
    }

    @Override
    public void die() {
        enemie.load("resources/Enemies/evil_hitler_dead.png");
        dead = true;
    }

    @Override
    public int getX() {
        return enemie.getX();
    }

    @Override
    public int getY() {
        return enemie.getY();
    }

    public boolean isDead() {
        return dead;
    }

    @Override
    public void setX(int x) {
        int dx = x - enemie.getX();
        enemie.translate(dx, 0);
    }

    @Override
    public void setY(int y) {
        int dy = y - enemie.getY();
        enemie.translate(0, dy);
    }

    @Override
    public int getWidth() {
        return enemie.getWidth();
    }

    @Override
    public int getHeight() {
        return enemie.getHeight();
    }

    @Override
    public void setCollisionDetector(CollisionDetector myCollisionDetector) {
        this.collisionDetector = myCollisionDetector;
    }

}
