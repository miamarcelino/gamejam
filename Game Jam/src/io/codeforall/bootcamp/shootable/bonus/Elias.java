package io.codeforall.bootcamp.shootable.bonus;

import io.codeforall.bootcamp.CollisionDetector;
import io.codeforall.bootcamp.shootable.Target;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Elias implements Target {

    private Picture elias;
    private boolean dead;
    private CollisionDetector collisionDetector;

    public Elias() {
        super();
        elias = new Picture(1000, 600, "resources/BonusChar/Elias/elias-down.png");
        dead = false;

        init();
        animateElias();
    }

    public void animateElias() {
        int counter = 0;

        while (counter < 500) {
            delayMethod(300);
            elias.load("resources/BonusChar/Elias/elias-up.png");
            delayMethod(300);
            elias.load("resources/BonusChar/Elias/elias-down.png");
            delayMethod(300);
            elias.load("resources/BonusChar/Elias/elias-up.png");
            delayMethod(300);
            elias.load("resources/BonusChar/Elias/elias-down.png");

            counter++;
        }
    }

    @Override
    public void init() {
        elias.draw();
    }

    @Override
    public void delete() {
        elias.delete();
    }

    @Override
    public void die() {
        dead = true;
    }

    @Override
    public int getX() {
        return elias.getX();
    }

    @Override
    public int getY() {
        return elias.getY();
    }

    @Override
    public boolean isDead() {
        return dead;
    }

    @Override
    public void setX(int x) {
        int dx = x - elias.getX();
        elias.translate(dx, 0);
    }

    @Override
    public void setY(int y) {
        int dy = y - elias.getY();
        elias.translate(0, dy);
    }

    @Override
    public int getWidth() {
        return elias.getWidth();
    }

    @Override
    public int getHeight() {
        return elias.getHeight();
    }

    @Override
    public void setCollisionDetector(CollisionDetector myCollisionDetector) {
        this.collisionDetector = myCollisionDetector;
    }

    private void delayMethod(int ms) {
        try {
            Thread.sleep(ms);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
