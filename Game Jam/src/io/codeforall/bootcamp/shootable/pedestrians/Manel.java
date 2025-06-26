package io.codeforall.bootcamp.shootable.pedestrians;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Manel extends Pedestrian {

    private boolean dead;

    public Manel() {
        pedestrian = new Picture(800, 50, "resources/Pedestrians/Manel/manel-alive.png");
        dead = false;
    }

    @Override
    public void die() {
        pedestrian.load("resources/Pedestrians/Manel/manel-dead.png");
    }
}
