package io.codeforall.bootcamp;

import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.shootable.Target;

public class CollisionDetector {

    private Bullet bullet;
    private Target[] targets;

    public CollisionDetector(Bullet bullet, Target[] targets) {
        this.bullet = bullet;
        this.targets = targets;
    }

    /**
     * Checks for collision of a bullet and a target
     * Requires iterating the array once
     */
    public void check() {

        for (Target t : targets) {
            if (t.getX() == bullet.getMaxX() && t.getY() == bullet.getY()) {
                bullet.setCollided();
                t.die();
            }
        }

    }
}
