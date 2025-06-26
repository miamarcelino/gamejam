package io.codeforall.bootcamp.shootable.pedestrians;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Afonso extends Pedestrian {

    private boolean dead;

    public Afonso() {
        pedestrian = new Picture(800, 50, "resources/Pedestrians/Afonso/afonso-alive.png");
        dead = false;
    }

    @Override
    public void die() {
        pedestrian.load("resources/Pedestrians/Afonso/afonso-dead.png");
    }
}
