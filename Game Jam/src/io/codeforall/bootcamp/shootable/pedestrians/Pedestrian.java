package io.codeforall.bootcamp.shootable.pedestrians;

import io.codeforall.bootcamp.CollisionDetector;
import io.codeforall.bootcamp.shootable.Target;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Pedestrian implements Target {

    protected Picture pedestrian;
    private boolean dead;
    private CollisionDetector collisionDetector;
    private long spawnTime;

    public Pedestrian() {
        super();
        pedestrian = new Picture();
        dead = false;
    }
    @Override
    public void init() {
        pedestrian.draw();
        spawnTime = System.currentTimeMillis();

        new Thread(() -> {
            try {
                Thread.sleep(1000);

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
        pedestrian.delete();
    }

    @Override
    public void die() {
        dead = true;
    }

    @Override
    public int getX() {
        return pedestrian.getX();
    }

    @Override
    public int getY() {
        return pedestrian.getY();
    }

    @Override
    public boolean isDead() {
        return dead;
    }

    @Override
    public void setX(int x) {
        int dx = x - pedestrian.getX();
        pedestrian.translate(dx, 0);
    }

    @Override
    public void setY(int y) {
        int dy = y - pedestrian.getY();
        pedestrian.translate(0, dy);
    }

    @Override
    public int getWidth() {
        return pedestrian.getWidth();
    }

    @Override
    public int getHeight() {
        return pedestrian.getHeight();
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
}
