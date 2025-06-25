package io.codeforall.bootcamp.players;

import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.bullets.GustavoBullet;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Gustavo extends Player {

    private Picture normalFace;
    private Picture shootingFace;
    private Bullet bullet;
    private boolean canMoveUp = true;
    private boolean canMoveDown = false;

    public Gustavo() {
        super(20, 650, "resources/Player/Gustavo/gustavo-still.png"
                , "resources/Player/Gustavo/gustavo-shooting.png"
                , new GustavoBullet(20 + 40, 650 + 100));

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

