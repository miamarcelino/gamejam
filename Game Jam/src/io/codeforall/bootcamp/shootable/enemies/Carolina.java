package io.codeforall.bootcamp.shootable.enemies;

import io.codeforall.bootcamp.CollisionDetector;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Carolina extends Enemy {

    private boolean dead;
    private CollisionDetector collisionDetector;

    public Carolina() {
        super(1000, (int) (Math.random() * 700), "resources/Enemies/Carolina/carolina-alive.png");
        dead = false;
    }

    @Override
    public void die() {

        if(dead) {
            return;
        }

        dead = true;

        enemie.load("resources/Enemies/Carolina/carolina-dead.png");
        enemie.draw();

        new Thread(() -> {

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println("Carolina is dead...");
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
