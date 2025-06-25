package io.codeforall.bootcamp.bullets;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MariaBullet extends Bullet{

        private Picture bullet;

        public MariaBullet(int startX, int startY) {
            super(startX, startY, "resources/Bullets/bullet-maria.png");
        }
}
