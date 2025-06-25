package io.codeforall.bootcamp.players;

import io.codeforall.bootcamp.bullets.Bullet;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Maria extends Player {

    private Picture maria;
    private Bullet bullet;
    private boolean canMoveUp = true;
    private boolean canMoveDown = false;

    public Maria() {
        maria = new Picture(20, 650, "resources/Player/Maria/maria-still.png");
        //this.bullet = new Bullet(getX(), getY(), "resources/Bullets/maria-bullet");
    }

    @Override
    public void standardFace() {
        maria.load("resources/Player/Maria/maria-still.png");
    }

    @Override
    public void shootingFace() {
        maria.load("resources/Player/Maria/maria-shooting.png");
    }
}
