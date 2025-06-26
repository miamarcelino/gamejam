package io.codeforall.bootcamp.shootable.pedestrians;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Otavio extends Pedestrian{

    private boolean dead;

    public Otavio() {
        pedestrian = new Picture(800, 50, "resources/Pedestrians/Otavio/otavio-alive.png");
        dead = false;
    }

    @Override
    public void die() {
        pedestrian.load("resources/Pedestrians/Otavio/otavio-dead.png");
    }
}
