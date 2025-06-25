package io.codeforall.bootcamp.players;

import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.bullets.GustavoBullet;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Gustavo extends Player {

    private Picture gustavo;
    private Bullet bullet;
    private boolean canMoveUp = true;
    private boolean canMoveDown = false;

    public Gustavo() {
        super(new Picture(20, 650, "resources/Player/Gustavo/gustavo-still.png"));
        this.bullet = new GustavoBullet(this.getX() + 40, this.getY() + 100);
    }

    @Override
    public void standardFace() {
        gustavo.load("resources/Player/Gustavo/gustavo-still.png");
    }

    @Override
    public void shootingFace() {
        gustavo.load("resources/Player/Gustavo/gustavo-shooting.png");
    }
}
