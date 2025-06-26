package io.codeforall.bootcamp.shootable.enemies;

import io.codeforall.bootcamp.CollisionDetector;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Rolo extends Enemy {

    private boolean dead;
    private CollisionDetector collisionDetector;

    public Rolo() {
        super(1000, (int) (Math.random()) * 700, "resources/Enemies/Rolo/rolo-alive.png");
        dead = false;
    }

    @Override
    public void die() {

        if(dead) {
            return;
        }

        dead = true;

        enemie.load("resources/Enemies/Rolo/rolo-dead.png");
        enemie.draw();

        new Thread(() -> {

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println("Rolo is dead...");
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
