package io.codeforall.bootcamp.shootable.pedestrians;

import io.codeforall.bootcamp.CollisionDetector;
import io.codeforall.bootcamp.shootable.Target;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Pedestrian implements Target {

    private Picture pedestrian;
    private boolean dead;
    private CollisionDetector collisionDetector;

    public Pedestrian() {
        super();
        dead = false;
    }
    @Override
    public void init() {
        pedestrian.draw();
    }

    @Override
    public void delete() {
        pedestrian.delete();
    }

    @Override
    public void die() {
        dead = true;
    }

    @Override
    public int getX() {
        return pedestrian.getX();
    }

    @Override
    public int getY() {
        return pedestrian.getY();
    }

    @Override
    public boolean isDead() {
        return dead;
    }

    @Override
    public void setCollisionDetector(CollisionDetector myCollisionDetector) {
        this.collisionDetector = myCollisionDetector;
    }
}
