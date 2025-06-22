package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EvilHitler extends Enemie{

    private Picture evilHitler;
    private boolean dead;

    public EvilHitler(){
        evilHitler = new Picture(1650, 830, "resources/SniperRifle/Enemies/evil_hitler.png");
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
        evilHitler.load("resources/SniperRifle/Enemies/evil_hitler_dead.png");
        dead = true;
    }


}
