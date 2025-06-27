package io.codeforall.bootcamp.shootable.enemies;

import io.codeforall.bootcamp.CollisionDetector;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Rolo extends Enemy {

    public Rolo() {
        super(1000, (int) (Math.random()) * 700, "resources/Enemies/Rolo/rolo-alive.png");
    }

    @Override
    public void die() {

        if(isDead()) {
            return;
        }

        setDead(true);

        enemie.load("resources/Enemies/Rolo/rolo-dead.png");
        enemie.draw();

        new Thread(() -> {

            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                System.out.println("Rolo is dead...");
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
