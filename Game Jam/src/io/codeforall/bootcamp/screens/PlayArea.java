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
    private Thread shootingThread;

    private boolean readyToSpawnNext = false;           // Flag to spawn next Target
    private int currentTargetIndex = 0;                 // Counter for targets killed

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

        if (myPlayer != null) {
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

    public void notifyEnemyDied() {
        readyToSpawnNext = true;
        currentTargetIndex++;
    }

    public void keepShooting() {

        Bullet bullet = myPlayer.createBullet();  // Player decides what bullet it fires
        bullet.setCollided(false);
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
        }).start();

        myCollisionDetector.setBullet(bullet);
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

    public void spawnNextEnemy() {
        while (currentTargetIndex < targets.length) {
            Target t = targets[currentTargetIndex];

            if (t != null && !t.isDead()) {
                t.init();
                System.out.println("Spawned Target!!");
                //currentTargetIndex++;
                return;

            }

            // If null or dead, move to next
            System.out.println("No more targets to spawn!");
        }
    }

    public void setMyBullet(Bullet bullet) {
        this.myBullet = bullet;
    }

    public void setMyCollisionDetector(Bullet bullet, MyKeyboardHandler keyboardHandler) {
        this.myBullet = bullet;
        this.myCollisionDetector = new CollisionDetector(bullet, this, keyboardHandler);

        for (Target t : targets) {
            if (t != null) {
                t.setCollisionDetector(myCollisionDetector);
            }
        }
    }

    public void startGameLoop() {
        new Thread(() -> {
            while (true) {
                if (myCollisionDetector != null) {
                    myCollisionDetector.check();
                }

                if (readyToSpawnNext) {
                    spawnNextEnemy();
                    readyToSpawnNext = false;
                }

                try {
                    Thread.sleep(50); // Checks collisions every 50ms

                } catch (InterruptedException e) {
                    break;
                }
            }
        }).start();
    }

    public Target getCurrentTarget() {
        if (currentTargetIndex < targets.length) {
            return targets[currentTargetIndex];
        }
        return null;
    }
}
