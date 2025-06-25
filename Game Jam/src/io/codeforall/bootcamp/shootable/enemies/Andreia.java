package io.codeforall.bootcamp.shootable.enemies;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Andreia extends Enemy{

    private Picture andreia;
    private boolean dead;

    public Andreia() {
        andreia = new Picture(1000, 50, "resources/Enemies/Andreia/andreia-alive.png");
        dead = false;
    }

    public void init() {
        andreia.draw();
    }

    public boolean isDead() {
        return dead;
    }

    @Override
    public void die() {
        andreia.load("resources/Enemies/Andreia/andreia-dead.png");
        dead = true;
    }
}
