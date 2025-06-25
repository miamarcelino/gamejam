package io.codeforall.bootcamp;

import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.factories.TargetFactory;
import io.codeforall.bootcamp.shootable.Target;
import io.codeforall.bootcamp.players.Player;
import io.codeforall.bootcamp.screens.ChoosePlayer;
import io.codeforall.bootcamp.screens.PlayArea;
import io.codeforall.bootcamp.screens.StartingScreen;


public class Game {
    private StartingScreen sc;
    private ChoosePlayer cp;
    private PlayArea pa;
    private Player p1;
    private Target[] targets;                           // Container of Targets
    private Bullet b1;
    private MyKeyboardHandler keyboardHandler;

    private CollisionDetector myCollisionDetector;      // The Collision detector
    private int manufacturedTargets = 20;               // We start with 20 Targets

    public Game() {

        keyboardHandler = new MyKeyboardHandler();

        pa = new PlayArea(keyboardHandler);
        pa.load();
        cp = new ChoosePlayer();
        cp.load();
        sc = new StartingScreen();
        sc.load();

        targets = new Target[manufacturedTargets];
    }

    public void start() {
        keyboardHandler.setStartingScreen(sc);
        keyboardHandler.setChoosePlayer(cp);
        keyboardHandler.setMyPlayArea(pa);

        keyboardHandler.setMyBullet(b1);
       // keyboardHandler.setMyEnemy(targets);
        keyboardHandler.setMyPlayer(p1);

        keyboardHandler.init();

        myCollisionDetector = new CollisionDetector(b1, targets);

        spawnEnemies();
    }

    public void spawnEnemies() {
        for(int i = 0; i < manufacturedTargets; i++) {

            targets[i] = TargetFactory.getNewTarget();
            targets[i].setCollisionDetector(myCollisionDetector);
        }
    }

    public void spawnAllEnemies() {
        for(Target t: targets) {
            spawnEnemies();
            myCollisionDetector.check();
        }
    }
}
