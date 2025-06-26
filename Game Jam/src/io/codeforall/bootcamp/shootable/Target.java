package io.codeforall.bootcamp.shootable;

import io.codeforall.bootcamp.CollisionDetector;

public interface Target {

    public void init();

    public void delete();

    public void die();

    public int getX();

    public int getY();

    boolean isDead();

    public void setX(int x);

    public void setY(int y);

    public int getWidth();

    public int getHeight();

    void setCollisionDetector(CollisionDetector myCollisionDetector);
}

