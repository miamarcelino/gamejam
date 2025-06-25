package io.codeforall.bootcamp.shootable.enemies;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Rolo extends Enemy {

    private Picture rolo;
    private boolean dead;

    public Rolo() {
        rolo = new Picture(1000, 650, "resources/Enemies/Rolo/rolo-alive.png");
        dead = false;
    }

    public void init() {
        rolo.draw();
    }

    @Override
    public boolean isDead() {
        return dead;
    }

    @Override
    public void die() {
        rolo.load("resources/Enemies/Rolo/rolo-dead.png");
        dead = true;
    }
}
