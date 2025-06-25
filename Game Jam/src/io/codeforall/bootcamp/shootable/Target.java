package io.codeforall.bootcamp.shootable;

import io.codeforall.bootcamp.CollisionDetector;

public interface Target {

    public void init();

    public void delete();

    public void die();

    public int getX();

    public int getY();

    boolean isDead();

    void setCollisionDetector(CollisionDetector myCollisionDetector);
}

