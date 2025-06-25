package io.codeforall.bootcamp.shootable.pedestrians;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Manel extends Pedestrian {

    private Picture manel;
    private boolean dead;

    public Manel() {
        manel = new Picture(800, 50, "resources/Pedestrians/Manel/manel-alive.png");
        dead = false;
    }

    public void init() {
        manel.draw();
    }

    public boolean isDead() {
        return dead;
    }

    @Override
    public void die() {
        manel.load("resources/Pedestrians/Manel/manel-dead.png");
    }
}
