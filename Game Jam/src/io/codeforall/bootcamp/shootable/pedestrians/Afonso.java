package io.codeforall.bootcamp.shootable.pedestrians;

import io.codeforall.bootcamp.CollisionDetector;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Afonso extends Pedestrian {

    private boolean dead;
    private CollisionDetector collisionDetector;

    public Afonso() {
        pedestrian = new Picture(800, 50, "resources/Pedestrians/Afonso/afonso-alive.png");
        dead = false;
    }

    @Override
    public void die() {

        if(dead) {
            return;
        }

        dead = true;

        pedestrian.load("resources/Pedestrians/Afonso/afonso-dead.png");
        pedestrian.draw();

        new Thread(() -> {

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println("Afonso is dead...");
                e.printStackTrace();
                return;
            }

            pedestrian.delete();

        }).start();
    }
}
