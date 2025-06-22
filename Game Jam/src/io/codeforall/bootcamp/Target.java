package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public interface Target {

    public void init();

    public void delete();

    public void die();

    public int getX();

    public int getY();

    boolean isDead();
}

