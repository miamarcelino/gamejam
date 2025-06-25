package io.codeforall.bootcamp.shootable.enemies;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Carolina extends Enemy {

    private boolean dead;

    public Carolina() {
        super(1000, (int) (Math.random() * 700), "resources/Enemies/Carolina/carolina-alive.png");
        dead = false;
    }

    @Override
    public void die() {
        enemie.load("resources/Enemies/Carolina/carolina-dead.png");
        super.die();
    }
}
