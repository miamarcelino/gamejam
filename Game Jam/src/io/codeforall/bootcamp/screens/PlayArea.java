package io.codeforall.bootcamp.screens;


import io.codeforall.bootcamp.CollisionDetector;
import io.codeforall.bootcamp.MyKeyboardHandler;
import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.factories.TargetFactory;
import io.codeforall.bootcamp.players.Player;
import io.codeforall.bootcamp.shootable.Target;
import io.codeforall.bootcamp.shootable.bonus.Elias;
import io.codeforall.bootcamp.shootable.enemies.Enemy;
import io.codeforall.bootcamp.shootable.pedestrians.Pedestrian;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PlayArea {

    private Picture playArea;
    private Player myPlayer;
    private Target myTarget;
    private Bullet myBullet;

    private Target[] targets;                           // Container of Targets
    private CollisionDetector myCollisionDetector;      // The Collision detector
    private int manufacturedTargets = 99;               // We start with 20 Targets

    private MyKeyboardHandler myKeyboardHandler;
    private Thread shootingThread;

    private boolean readyToSpawnNext = false;           // Flag to spawn next Target
    private int currentTargetIndex = 0;                 // Counter for targets killed

    public PlayArea(MyKeyboardHandler myKeyboardHandler) {
        this.myKeyboardHandler = myKeyboardHandler;
        playArea = new Picture(10, 10, "resources/Background/play-area.jpg");
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
        setMyCollisionDetector(myBullet, myKeyboardHandler);

        spawnNextEnemy();

        myTarget = getCurrentTarget();
        myKeyboardHandler.setMyTarget(myTarget);
    }

    public void delete() {
        playArea.delete();
    }

    public void notifyEnemyDied() {
        currentTargetIndex++;
        readyToSpawnNext = true;
    }

    public void keepShooting() {

        Bullet bullet = myPlayer.createBullet();  // Player decides what bullet it fires
//        bullet.setCollided(false);
        bullet.reset(myPlayer.getX() + 40, myPlayer.getY() + 100);

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
                if (t instanceof Enemy) {
                    t.setX(1024);
                }

                if (t instanceof Pedestrian) {
                    t.setX(600);
                }

                if (t instanceof Elias) {
                    t.setX(600);
                }

                t.setCollisionDetector(myCollisionDetector);
                System.out.println("Initializing target " + i + ": " + t.getClass().getSimpleName());

                targets[i] = t;
            } else {
                System.out.println("TargetFactory returned null at index " + i);
            }
        }
    }

    public void spawnNextEnemy() {

        int[] yPositions = {10, 330, 650};

        if (currentTargetIndex >= targets.length) {
            System.out.println("All targets spawned or dead");
            return;
        }

        Target t = targets[currentTargetIndex];
        int lastPosition;
        if(currentTargetIndex > 0){
            lastPosition = targets[currentTargetIndex - 1].getY();
        } else {
            lastPosition = 10;
        }
       

        if (t != null && !t.isDead()) {

            if (t instanceof Pedestrian && currentTargetIndex < targets.length) {
                t.init();
                t = targets[currentTargetIndex + 1];
            }

            if (t instanceof Enemy) {
                currentTargetIndex--;
                if (t.getY() == lastPosition) {
                    switch (t.getY()) {
                        case 10:
                            t.setY(330);
                            break;

                        case 330:
                            t.setY(650);
                            break;

                        case 650:
                            t.setY(10);
                            break;
                    }
                }
                currentTargetIndex++;
            }

            t.init();
            System.out.println("Spawned Target!!");

            myTarget = t;
            myKeyboardHandler.setMyTarget(myTarget);


        } else {
            System.out.println("Target at index " + currentTargetIndex + " is null or already dead");
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

        if (currentTargetIndex < targets.length && currentTargetIndex >= 0) {
            return targets[currentTargetIndex];
        }
        return null;
    }
}
