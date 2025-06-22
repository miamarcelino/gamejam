package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EvilHitler extends Enemy{

    private Picture evilHitler;
    private boolean dead;

    public EvilHitler(){
        evilHitler = new Picture(1500, 760, "resources/Enemies/maria-still-enemy.png");
        dead = false;

        init();
    }

    public void init(){
        evilHitler.draw();
    }

    public boolean isDead(){
        return dead;
    }

    @Override
    public void die(){
        evilHitler.load("resources/Enemies/evil_hitler_dead.png");
        dead = true;
    }


}
