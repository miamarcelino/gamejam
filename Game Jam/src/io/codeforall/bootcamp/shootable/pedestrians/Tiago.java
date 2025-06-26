package io.codeforall.bootcamp.shootable.pedestrians;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Tiago extends Pedestrian {

    private boolean dead;

    public Tiago() {
        pedestrian = new Picture(800, 50, "resources/Pedestrians/Tiago/tiago-alive.png");
        dead = false;
    }

    @Override
    public void die() {
        if (dead) {
            return;
        }

        dead = true;

        pedestrian.load("resources/Pedestrians/Tiago/tiago-dead.png");
        pedestrian.draw();

        new Thread(() -> {

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println("Tiago is dead...");
                e.printStackTrace();
                return;
            }

            pedestrian.delete();

        }).start();
    }
}
