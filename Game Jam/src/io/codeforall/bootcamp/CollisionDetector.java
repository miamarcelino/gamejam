package io.codeforall.bootcamp;

import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.shootable.Target;

public class CollisionDetector {

    private Bullet bullet;
    private Target[] targets;
    private MyKeyboardHandler keyboardHandler;

    public CollisionDetector(Bullet bullet, Target[] targets, MyKeyboardHandler keyboardHandler) {
        this.bullet = bullet;
        this.targets = targets;
        this.keyboardHandler = keyboardHandler;

        keyboardHandler.setMyBullet(bullet);
    }

    /**
     * Checks for collision of a bullet and a target
     * Requires iterating the array once
     */
    public void check() {

        if (bullet == null || bullet.isCollided()) {
            return;
        }

        int bulletX = bullet.getX();
        int bulletY = bullet.getY();
        int bulletWidth = bullet.getWidth();
        int bulletHeight = bullet.getHeight();

        for (Target t : targets) {
            if (t == null || t.isDead()) {
                continue;
            }

            int targetX = t.getX();
            int targetY = t.getY();
            int targetWidth = t.getWidth();
            int targetHeight = t.getHeight();

            // If none of these is true, they must be intersecting
            boolean intersect =
                    !(bulletX + bulletWidth < targetX ||            // bullet is completely left of target
                            bulletX > targetX + targetWidth ||      // bullet is completely right of target
                            bulletY + bulletHeight < targetY ||     // bullet is completely above target
                            bulletY > targetY + targetHeight);      // bullet is completely below target


        }

    }
}
