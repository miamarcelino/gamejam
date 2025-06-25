package io.codeforall.bootcamp.shootable.enemies;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Rolo extends Enemy {

    private boolean dead;

    public Rolo() {
        super(1000, (int) (Math.random()) * 700, "resources/Enemies/Rolo/rolo-alive.png");
        dead = false;
    }

    @Override
    public void die() {
        enemie.load("resources/Enemies/Rolo/rolo-dead.png");
        super.die();
    }
}
