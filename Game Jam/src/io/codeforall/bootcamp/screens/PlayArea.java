package io.codeforall.bootcamp.screens;


import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.players.Player;
import io.codeforall.bootcamp.shootable.enemies.Enemy;
import io.codeforall.bootcamp.shootable.enemies.EvilHitler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PlayArea {

    private Picture playArea;
    private Player myPlayer;
    private Enemy myEnemy;
    private Bullet myBullet;

    public PlayArea() {
        playArea = new Picture(10, 10, "resources/Background/background-blueprint.png");
    }

    public void load() {
        myPlayer = new Player();
        myEnemy = new EvilHitler();
        myEnemy.init();

        playArea.draw();
    }

    public void delete() {
        playArea.delete();
    }
}
