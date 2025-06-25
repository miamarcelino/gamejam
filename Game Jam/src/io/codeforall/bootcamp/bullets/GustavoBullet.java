package io.codeforall.bootcamp.bullets;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GustavoBullet extends Bullet{

    private Picture bullet;

    public GustavoBullet(int startX, int startY) {
        super(startX, startY, "resources/Bullets/bullet-gustavo.png");
    }
}
