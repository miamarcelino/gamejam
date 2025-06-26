package io.codeforall.bootcamp;

import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.screens.PlayArea;
import io.codeforall.bootcamp.shootable.Target;

public class CollisionDetector {

    private Bullet bullet;
    private PlayArea playArea;
    private MyKeyboardHandler keyboardHandler;

    public CollisionDetector(Bullet bullet, PlayArea playArea, MyKeyboardHandler keyboardHandler) {
        this.bullet = bullet;
        this.keyboardHandler = keyboardHandler;
        this.playArea = playArea;

        keyboardHandler.setMyBullet(bullet);
    }

    /**
     * Checks for collision of a bullet and a target
     * Requires iterating the array once
     */
    public void check() {

        int bulletX = bullet.getX();
        int bulletY = bullet.getY();
        int bulletWidth = bullet.getWidth();
        int bulletHeight = bullet.getHeight();

        Target currentTarget = playArea.getCurrentTarget();

        if (currentTarget == null || currentTarget.isDead()) {
            return;
        }

        int targetX = currentTarget.getX();
        int targetY = currentTarget.getY();
        int targetWidth = currentTarget.getWidth();
        int targetHeight = currentTarget.getHeight();


        // If none of these is true, they must be intersecting
        boolean intersect =
                !(bulletX + bulletWidth < targetX ||            // bullet is completely left of target
                        bulletX > targetX + targetWidth ||      // bullet is completely right of target
                        bulletY + bulletHeight < targetY ||     // bullet is completely above target
                        bulletY > targetY + targetHeight);      // bullet is completely below target


        if (intersect) {
            bullet.setCollided(true);
            currentTarget.die();
            notifyPlayAreaEnemyDied();
        }
    }

    public void notifyPlayAreaEnemyDied() {
        if (keyboardHandler.getPlayArea() != null) {
            keyboardHandler.getPlayArea().notifyEnemyDied();
        }
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }
}
