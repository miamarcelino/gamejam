package io.codeforall.bootcamp;

public interface Target {

    public void init();

    public void delete();

    public void die();

    public int getX();

    public int getY();

    boolean isDead();
}

