package io.codeforall.bootcamp.screens;


import io.codeforall.bootcamp.CollisionDetector;
import io.codeforall.bootcamp.MyKeyboardHandler;
import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.factories.TargetFactory;
import io.codeforall.bootcamp.players.Daniel;
import io.codeforall.bootcamp.players.Player;
import io.codeforall.bootcamp.shootable.Target;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PlayArea {

    private Picture playArea;
    private Player myPlayer;
    private Target myTarget;
    private Bullet myBullet;

    private Target[] targets;                           // Container of Targets
    private CollisionDetector myCollisionDetector;      // The Collision detector
    private int manufacturedTargets = 20;               // We start with 20 Targets

    private Thread shootingThread;
    private MyKeyboardHandler myKeyboardHandler;

    public PlayArea(MyKeyboardHandler myKeyboardHandler) {
        this.myKeyboardHandler = myKeyboardHandler;
        playArea = new Picture(10, 10, "resources/Background/background-blueprint.png");

    }

    public void setMyPlayer(Player player) {
        this.myPlayer = player;
    }

    public void show() {
        System.out.println("Drawing PlayArea and Player...");
        playArea.draw();

        if(myPlayer != null) {
            myPlayer.init();
        }
    }

    public void load() {
        // Prepares everything but doesn't draw

        targets = new Target[manufacturedTargets];
        myKeyboardHandler.setMyPlayer(myPlayer);
        spawnEnemies();
        myKeyboardHandler.setMyTarget(myTarget);
    }

    public void delete() {
        playArea.delete();
    }

    public void keepShooting() {
        stopShootingThread();           // Prevents multiple threads

        shootingThread = new Thread(() -> {

            if(myBullet == null) {
                System.out.println("myBullet is null in keepShooting()");
                return;
            }
           myBullet.setStartingX(myPlayer.getX() + 40);
           myBullet.setStartingY(myPlayer.getY() + 100);

            myBullet.initBullet();
            myPlayer.shootingFace();
            System.out.println("Started shooting...");

            for (int i = 0; i < myBullet.getMaxAmmo(); i++) {
                myBullet.shootBullet();

                try {
                    Thread.sleep(50);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            myBullet.deleteBullet();
            System.out.println("Finished shooting...");
        });
        shootingThread.start();
    }

    public void stopShootingThread() {
        if (shootingThread != null && shootingThread.isAlive()) {
            shootingThread.interrupt();
            myBullet.deleteBullet();
        }
    }

    public void spawnEnemies() {
        for (int i = 0; i < manufacturedTargets; i++) {
            System.out.println("Spawning enemy #" + i);

            Target t = TargetFactory.getNewTarget();

            if(t != null) {
                t.setCollisionDetector(myCollisionDetector);
                System.out.println("Initializing target " + i + ": " + t.getClass().getSimpleName());
                t.init();
                targets[i] = t;

            } else {
                System.out.println("TargetFactory returned null at index " + i);
            }
        }
    }

    public void spawnAllEnemies() {
        for (Target t : targets) {
            spawnEnemies();
            myCollisionDetector.check();
        }
    }

    public void setMyBullet(Bullet bullet) {
        this.myBullet = bullet;
    }

    public void setMyCollisionDetector(Bullet bullet, MyKeyboardHandler keyboardHandler) {
        this.myBullet = bullet;
        this.myCollisionDetector = new CollisionDetector(bullet, targets, keyboardHandler);

        for(Target t: targets) {
            if(t != null) {
                t.setCollisionDetector(myCollisionDetector);
            }
        }
    }

    public void startGameLoop() {
        new Thread(() -> {
            while(true) {
                if(myCollisionDetector != null) {
                    myCollisionDetector.check();
                }

                try {
                    Thread.sleep(50); // Checks collisions every 50ms

                } catch (InterruptedException e) {
                    break;
                }
            }
        }).start();
    }
}
