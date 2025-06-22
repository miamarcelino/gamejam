package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemie implements Target {

    private Picture enemie;
    private boolean dead;

    public Enemie(){
        super();
        dead = false;
    }


    @Override
    public void init() {
        enemie.draw();
    }

    @Override
    public void delete() {
        enemie.delete();
    }

    @Override
    public void die() {
        enemie.load("resources/SniperRifle/Enemies/evil_hitler_dead.png");
        dead = true;
    }

    @Override
    public int getX() {
        return enemie.getX();
    }

    @Override
    public int getY() {
        return enemie.getY();
    }

    public boolean isDead(){
        return dead;
    }

}
