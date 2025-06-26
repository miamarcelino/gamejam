package io.codeforall.bootcamp.shootable.enemies;

public class Andreia extends Enemy {

    private boolean dead;

    public Andreia() {
        super(1000, (int) (Math.random() * 700), "resources/Enemies/Andreia/andreia-alive.png");
        dead = false;
    }

    @Override
    public void die() {
        enemie.load("resources/Enemies/Andreia/andreia-dead.png");
        super.die();
    }
}
