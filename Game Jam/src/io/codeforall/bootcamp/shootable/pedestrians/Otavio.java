package io.codeforall.bootcamp.shootable.pedestrians;

import io.codeforall.bootcamp.CollisionDetector;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Otavio extends Pedestrian{

    private boolean dead;
    private CollisionDetector collisionDetector;

    public Otavio() {
        pedestrian = new Picture(500, 50, "resources/Pedestrians/Otavio/otavio-alive.png");
        dead = false;
    }

    @Override
    public void die() {
        if(dead) {
            return;
        }

        dead = true;

        pedestrian.load("resources/Pedestrians/Otavio/otavio-dead.png");
        pedestrian.draw();

        new Thread(() -> {

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println("Otavio is dead...");
                e.printStackTrace();
                return;
            }

            pedestrian.delete();

            // Notify via CollisionDetector -> PlayArea
            if(collisionDetector != null) {
                collisionDetector.notifyPlayAreaEnemyDied();
            }
        }).start();
    }
}
