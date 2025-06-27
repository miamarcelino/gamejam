package io.codeforall.bootcamp.shootable.enemies;

import io.codeforall.bootcamp.CollisionDetector;

public class Andreia extends Enemy {

    public Andreia() {
        super(1000, (int) (Math.random() * 700), "resources/Enemies/Andreia/andreia-alive.png");
    }

    @Override
    public void die() {
        if(isDead()) {
            return;
        }

        setDead(true);

        enemie.load("resources/Enemies/Andreia/andreia-dead.png");
        enemie.draw();

        new Thread(() -> {

            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                System.out.println("Andreia is dead...");
                e.printStackTrace();
                return;
            }

            enemie.delete();

            // Notify via CollisionDetector -> PlayArea
            if(getCollisionDetector() != null) {
                getCollisionDetector().notifyPlayAreaEnemyDied();
            }

        }).start();


    }
}
