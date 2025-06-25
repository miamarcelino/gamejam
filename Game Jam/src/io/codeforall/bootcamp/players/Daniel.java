package io.codeforall.bootcamp.players;

import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.bullets.DanielBullet;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Daniel extends Player {

    private Picture normalFace;
    private Picture shootingFace;
    private Bullet bullet;
    private boolean canMoveUp = true;
    private boolean canMoveDown = false;

    public Daniel() {
        super(20, 650, "resources/Player/Daniel/daniel-still.png"
                , "resources/Player/Daniel/daniel-shooting.png"
                , new DanielBullet(20 + 40, 650 + 100));

    }

    @Override
    public void init() {
        normalFace.draw();
    }

    @Override
    public void moveUp() {
        normalFace.translate(0, 320);
        shootingFace.translate(0, 320);
    }

    @Override
    public void moveDown() {
        normalFace.translate(0, 320);
        shootingFace.translate(0, 320);
    }

    @Override
    public void shootingFace() {
        normalFace.delete();
        shootingFace.translate(normalFace.getX(), normalFace.getY());
        shootingFace.draw();

        new Thread(() -> {

            try {
                Thread.sleep(200);

            } catch (InterruptedException e) {

            }

            shootingFace.delete();
            normalFace.delete();

        }).start();
    }

    @Override
    public int getX() {
        return normalFace.getX();
    }

    @Override
    public int getY() {
        return normalFace.getY();
    }

    @Override
    public void delete() {
        normalFace.delete();
        shootingFace.delete();
    }
}
