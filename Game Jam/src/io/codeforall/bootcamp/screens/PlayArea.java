package io.codeforall.bootcamp.screens;


import io.codeforall.bootcamp.CollisionDetector;
import io.codeforall.bootcamp.MyKeyboardHandler;
import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.factories.TargetFactory;
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

    private MyKeyboardHandler myKeyboardHandler;

    private boolean readyToSpawnNext = false;           // Flag to spawn next Target

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

        for(Target t: targets) {
            if(t != null && !t.isDead()) {
                t.init();
                System.out.println("FORCE redraw: "  + t.getClass().getSimpleName() +
                        " at X=" + t.getX() + " Y=" + t.getY());
            }
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

        Bullet bullet = myPlayer.createBullet();  // Player decides what bullet it fires
        bullet.setStartingX(myPlayer.getX() + 40);
        bullet.setStartingY(myPlayer.getY() + 100);
        bullet.initBullet();
        myPlayer.shootingFace();

        new Thread(() -> {
            for (int i = 0; i < bullet.getMaxAmmo(); i++) {
                bullet.shootBullet();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    break;
                }
            }
          //  bullet.deleteBullet();
        }).start();
    }

    public void stopShootingThread() {
        if (shootingThread != null && shootingThread.isAlive()) {
            shootingThread.interrupt();
            myBullet.deleteBullet();
        }
    }

    public void spawnEnemies() {

        int[] yPositions = {10, 330, 650};

        for (int i = 0; i < manufacturedTargets; i++) {
            System.out.println("Spawning enemy #" + i);

            Target t = TargetFactory.getNewTarget();

            if (t != null) {
                int y = yPositions[(int) (Math.random() * yPositions.length)];
                t.setY(y);
                t.setX(1024);

                t.setCollisionDetector(myCollisionDetector);
                System.out.println("Initializing target " + i + ": " + t.getClass().getSimpleName());

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
