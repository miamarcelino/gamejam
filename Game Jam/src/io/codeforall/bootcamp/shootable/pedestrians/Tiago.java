package io.codeforall.bootcamp.shootable.pedestrians;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Tiago extends Pedestrian {

    private Picture tiago;
    private boolean dead;

    public Tiago() {
        tiago = new Picture(800, 50, "resources/Pedestrians/Tiago/tiago-alive.png");
        dead = false;
    }

    public void init() {
        tiago.draw();
    }

    public boolean isDead() {
        return dead;
    }

    @Override
    public void die() {
        tiago.load("resources/Pedestrians/Tiago/tiago-dead.png");
    }
}
