package io.codeforall.bootcamp.shootable.pedestrians;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Otavio extends Pedestrian{

    private Picture otavio;
    private boolean dead;

    public Otavio() {
        otavio = new Picture(800, 50, "resources/Pedestrians/Otavio/otavio-alive.png");
        dead = false;
    }

    public void init() {
        otavio.draw();
    }

    public boolean isDead() {
        return dead;
    }

    @Override
    public void die() {
        otavio.load("resources/Pedestrians/Otavio/otavio-dead.png");
    }
}
