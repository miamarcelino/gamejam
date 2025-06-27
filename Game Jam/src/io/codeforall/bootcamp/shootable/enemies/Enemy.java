package io.codeforall.bootcamp.shootable.enemies;

import io.codeforall.bootcamp.CollisionDetector;
import io.codeforall.bootcamp.shootable.Target;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy implements Target {

    protected Picture enemie;
    private boolean dead;
    private CollisionDetector collisionDetector;
    private long spawnTime;

    public Enemy(int x, int y, String src) {
        this.enemie = new Picture(x, y, src);
        dead = false;
    }


    @Override
    public void init() {
        enemie.draw();
        spawnTime = System.currentTimeMillis();

        new Thread(() -> {
            try {
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                System.out.println("3 seconds without dying");
                e.printStackTrace();
               return;
            }

            if(!dead) {
                delete();

                if(collisionDetector != null) {
                    collisionDetector.notifyPlayAreaEnemyDied();
                }
            }
        }).start();
    }

    @Override
    public void delete() {
        enemie.delete();
    }

    @Override
    public void die() {
        if(dead) {
            return;
        }

        dead = true;

        enemie.load("resources/Enemies/evil_hitler_dead.png");
        enemie.draw();

        new Thread(() -> {

            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                System.out.println("Enemy is dead ...");
                e.printStackTrace();
                return;
            }

            enemie.delete();

            // Notify via CollisionDetector -> PlayArea
            if(collisionDetector != null) {
                System.out.println("Notifying PlayArea enemy died...");
                collisionDetector.notifyPlayAreaEnemyDied();
            } else {
                System.out.println("Collision Detector was null");
            }
        }).start();
    }

    @Override
    public int getX() {
        return enemie.getX();
    }

    @Override
    public int getY() {
        return enemie.getY();
    }

    public boolean isDead() {
        return dead;
    }

    @Override
    public void setX(int x) {
        int dx = x - enemie.getX();
        enemie.translate(dx, 0);
    }

    @Override
    public void setY(int y) {
        int dy = y - enemie.getY();
        enemie.translate(0, dy);
    }

    @Override
    public int getWidth() {
        return enemie.getWidth();
    }

    @Override
    public int getHeight() {
        return enemie.getHeight();
    }

    @Override
    public void setCollisionDetector(CollisionDetector myCollisionDetector) {
        this.collisionDetector = myCollisionDetector;
    }

    @Override
    public void setSpawnTime(long time) {
        this.spawnTime = time;
    }

    @Override
    public long getSpawnTime() {
        return spawnTime;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public CollisionDetector getCollisionDetector() {
        return collisionDetector;
    }

}
