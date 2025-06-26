package io.codeforall.bootcamp.shootable.pedestrians;

import io.codeforall.bootcamp.CollisionDetector;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Manel extends Pedestrian {

    private boolean dead;
    private CollisionDetector collisionDetector;

    public Manel() {
        pedestrian = new Picture(800, 50, "resources/Pedestrians/Manel/manel-alive.png");
        dead = false;
    }

    @Override
    public void die() {

        if(dead) {
            return;
        }

        dead = true;

        pedestrian.load("resources/Pedestrians/Manel/manel-dead.png");
        pedestrian.draw();

        new Thread(() -> {

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println("Manel is dead...");
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
