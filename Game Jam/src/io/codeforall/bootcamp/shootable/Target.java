package io.codeforall.bootcamp.shootable;

import io.codeforall.bootcamp.CollisionDetector;

public interface Target {

    void init();

    void delete();

    void die();

    int getX();

    int getY();

    boolean isDead();

    void setX(int x);

    void setY(int y);

    int getWidth();

    int getHeight();

    void setCollisionDetector(CollisionDetector myCollisionDetector);

    void setSpawnTime(long time);

    long getSpawnTime();

}

