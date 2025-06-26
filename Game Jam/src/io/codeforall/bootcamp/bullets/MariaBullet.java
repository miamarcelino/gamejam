package io.codeforall.bootcamp.bullets;


public class MariaBullet extends Bullet{

        public MariaBullet(int startX, int startY) {
            super(startX, startY, "resources/Bullets/bullet-maria.png");
        }

        public Bullet createBullet() {
            return new MariaBullet(getX(), getY());
        }
}
