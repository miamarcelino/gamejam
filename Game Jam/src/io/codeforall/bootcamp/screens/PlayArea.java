package io.codeforall.bootcamp.screens;


import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.players.Player;
import io.codeforall.bootcamp.shootable.enemies.Enemy;
import io.codeforall.bootcamp.shootable.enemies.EvilHitler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PlayArea {

    private Picture playArea;
    private Player myPlayer;
    private Enemy myEnemy;
    private Bullet myBullet;

    private Thread shootingThread;

    public PlayArea() {
        playArea = new Picture(10, 10, "resources/Background/background-blueprint.png");
    }

    public void load() {
        myPlayer = new Player();
        myEnemy = new EvilHitler();
        myEnemy.init();

        playArea.draw();
    }

    public void delete() {
        playArea.delete();
    }

    public void keepShooting() {
        shootingThread = new Thread(() -> {

            myBullet = new Bullet(myPlayer.getX() + 40, myPlayer.getY() + 100,
                    "resources/Bullets/daniel-bullet.png");

            myBullet.initBullet();
            myPlayer.shootingFace();

            for (int i = 0; i < myBullet.getMaxAmmo(); i++) {
                myBullet.shootBullet();

                try {
                    Thread.sleep(50);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            myBullet.deleteBullet();
            myEnemy.die();
            myPlayer.standardFace();
        });
        shootingThread.start();
    }

    public void stopShootingThread() {
        if(shootingThread != null && shootingThread.isAlive()){
            shootingThread.interrupt();
            myBullet.deleteBullet();
        }
    }
}
