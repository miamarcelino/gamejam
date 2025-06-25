package io.codeforall.bootcamp.shootable.enemies;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Carolina extends Enemy {

    private Picture carolina;
    private boolean dead;

    public Carolina() {
        carolina = new Picture(1000, 350, "resources/Enemies/Carolina/carolina-alive.png");
        dead = false;
    }

    public void init() {
        carolina.draw();
    }

    public boolean isDead() {
        return dead;
    }

    @Override
    public void die() {
        carolina.load("resources/Enemies/Carolina/carolina-dead.png");
        dead = true;
    }
}
