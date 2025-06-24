package io.codeforall.bootcamp.players;

import io.codeforall.bootcamp.bullets.Bullet;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Daniel extends Player {

    private Picture daniel;
    private Bullet bullet;
    private boolean canMoveUp = true;
    private boolean canMoveDown = false;

    public Daniel(){
        daniel = new Picture(20, 650, "resources/Player/Daniel/daniel-still.png");
        this.bullet = new Bullet(getX(), getY(), "resources/Bullets/daniel-bullet.png");
    }

    @Override
    public void standardFace() {
        daniel.load("resources/Player/Daniel/daniel-still.png");
    }

    @Override
    public void shootingFace(){
        daniel.load("resources/Player/Daniel/daniel-shooting.png");
    }
}
