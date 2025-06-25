package io.codeforall.bootcamp;

import io.codeforall.bootcamp.screens.ChoosePlayer;
import io.codeforall.bootcamp.screens.PlayArea;
import io.codeforall.bootcamp.screens.StartingScreen;


public class Game {
    private StartingScreen sc;
    private ChoosePlayer cp;
    private PlayArea pa;

    private MyKeyboardHandler keyboardHandler;

    public Game() {

        keyboardHandler = new MyKeyboardHandler();

        pa = new PlayArea(keyboardHandler);
        //pa.load();
        cp = new ChoosePlayer();
        cp.load();
        sc = new StartingScreen();
        sc.load();

    }

    public void start() {
        keyboardHandler.setStartingScreen(sc);
        keyboardHandler.setChoosePlayer(cp);
        keyboardHandler.setMyPlayArea(pa);



       // keyboardHandler.setMyBullet(b1);
       // keyboardHandler.setMyEnemy(targets);
       // keyboardHandler.setMyPlayer(p1);

        keyboardHandler.init();
    }

    public MyKeyboardHandler getKeyboardHandler() {
        return keyboardHandler;
    }
}
