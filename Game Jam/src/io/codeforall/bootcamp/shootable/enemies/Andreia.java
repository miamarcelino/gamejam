package io.codeforall.bootcamp.shootable.enemies;

import io.codeforall.bootcamp.CollisionDetector;

public class Andreia extends Enemy {

    private boolean dead;
    private CollisionDetector collisionDetector;

    public Andreia() {
        super(1000, (int) (Math.random() * 700), "resources/Enemies/Andreia/andreia-alive.png");
        dead = false;
    }

    @Override
    public void die() {
        if(dead) {
            return;
        }

        dead = true;

        enemie.load("resources/Enemies/Andreia/andreia-dead.png");
        enemie.draw();

        new Thread(() -> {

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println("Andreia is dead...");
                e.printStackTrace();
                return;
            }

            enemie.delete();

            // Notify via CollisionDetector -> PlayArea
            if(collisionDetector != null) {
                collisionDetector.notifyPlayAreaEnemyDied();
            }

        }).start();


    }
}
