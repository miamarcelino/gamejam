package io.codeforall.bootcamp.shootable.pedestrians;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Afonso extends Pedestrian {

    private Picture afonso;
    private boolean dead;

    public Afonso() {
        afonso = new Picture(800, 50, "resources/Pedestrians/Afonso/afonso-alive.png");
        dead = false;
    }

    public void init() {
        afonso.draw();
    }

    public boolean isDead() {
        return dead;
    }

    @Override
    public void die() {
        afonso.load("resources/Pedestrians/Afonso/afonso-dead.png");
    }
}
