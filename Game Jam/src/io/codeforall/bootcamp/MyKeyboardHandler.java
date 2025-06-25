package io.codeforall.bootcamp;

import io.codeforall.bootcamp.bullets.Bullet;
import io.codeforall.bootcamp.bullets.DanielBullet;
import io.codeforall.bootcamp.bullets.GustavoBullet;
import io.codeforall.bootcamp.bullets.MariaBullet;
import io.codeforall.bootcamp.players.*;
import io.codeforall.bootcamp.shootable.Target;
import io.codeforall.bootcamp.shootable.enemies.Enemy;
import io.codeforall.bootcamp.screens.ChoosePlayer;
import io.codeforall.bootcamp.screens.PlayArea;
import io.codeforall.bootcamp.screens.StartingScreen;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class MyKeyboardHandler implements KeyboardHandler {

    private Keyboard keyboard;
    private Bullet myBullet;
    private Target myTarget;
    private Player myPlayer;
    private StartingScreen mySC;
    private ChoosePlayer myCP;
    private PlayArea myPlayArea;

    private boolean pressedSpace = false;   // To check if space key is pressed
    private boolean canShoot = false;
    private boolean chosen = true;

    private String chosenPlayer = "";

    public void init() {

        keyboard = new Keyboard(this);
        KeyboardEvent spaceKey = new KeyboardEvent();
        KeyboardEvent sKey = new KeyboardEvent();
        KeyboardEvent upKey = new KeyboardEvent();
        KeyboardEvent downKey = new KeyboardEvent();
        KeyboardEvent oneKey = new KeyboardEvent();
        KeyboardEvent twoKey = new KeyboardEvent();
        KeyboardEvent threeKey = new KeyboardEvent();

        spaceKey.setKey(KeyboardEvent.KEY_SPACE);
        spaceKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        oneKey.setKey(KeyboardEvent.KEY_1);
        oneKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        twoKey.setKey(KeyboardEvent.KEY_2);
        twoKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        threeKey.setKey(KeyboardEvent.KEY_3);
        threeKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        sKey.setKey(KeyboardEvent.KEY_S);
        sKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        upKey.setKey(KeyboardEvent.KEY_UP);
        upKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downKey.setKey(KeyboardEvent.KEY_DOWN);
        downKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(spaceKey);

        keyboard.addEventListener(oneKey);
        keyboard.addEventListener(twoKey);
        keyboard.addEventListener(threeKey);

        keyboard.addEventListener(sKey);

        keyboard.addEventListener(upKey);
        keyboard.addEventListener(downKey);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_SPACE:

                // Only start the thread if it hasn't been started yet
                if (!pressedSpace) {
                    System.out.println("Pressed space, starting thread...");

                    mySC.delete();  // Deletes Starting Screen
                    myCP.load();    // Loads Choose Player Screen

                    // Create and start the flashing effect
                    myCP.startFlashingEffect();

                    pressedSpace = true;
                    chosen = false;

                } else {
                    System.out.println("Space Key already pressed. Thread running...");
                }
                break;

            case KeyboardEvent.KEY_1:
                if (!chosen) {
                    myPlayer = new Daniel();
                    myBullet = myPlayer.getBullet();
                    //myBullet = new DanielBullet(myPlayer.getX() + 40, myPlayer.getY() + 100);

                    // Stops the flashingThread if another key is pressed
                    myCP.stopFlashingEffect();
                    myCP.delete();

                    myPlayArea.setMyPlayer(myPlayer);
                    setMyPlayer(myPlayer);
                    setMyBullet(myBullet);

                    myPlayArea.load();
                    myPlayArea.setMyCollisionDetector(myBullet, this);
                    System.out.println("Showing PlayArea");
                    myPlayArea.show();
                    myPlayer.init();

                    myPlayArea.startGameLoop();

                    chosen = true;
                    canShoot = true;
                }
                break;

            case KeyboardEvent.KEY_2:
                if (!chosen) {
                    myPlayer = new Maria();
                    myBullet = myPlayer.getBullet();
                    //myBullet = new MariaBullet(myPlayer.getX() + 40, myPlayer.getY() + 100);

                    // Stops the flashingThread if another key is pressed
                    myCP.stopFlashingEffect();
                    myCP.delete();

                    myPlayArea.setMyPlayer(myPlayer);
                    setMyPlayer(myPlayer);
                    setMyBullet(myBullet);

                    myPlayArea.load();
                    myPlayArea.setMyCollisionDetector(myBullet, this);
                    System.out.println("Showing PlayArea");
                    myPlayArea.show();
                    myPlayer.init();

                    myPlayArea.startGameLoop();

                    chosen = true;
                    canShoot = true;
                }
                break;

            case KeyboardEvent.KEY_3:
                if (!chosen) {
                    myPlayer = new Gustavo();
                    myBullet = myPlayer.getBullet();
                   // myBullet = new GustavoBullet(myPlayer.getX() + 40, myPlayer.getY() + 100);

                    // Stops the flashingThread if another key is pressed
                    myCP.stopFlashingEffect();
                    myCP.delete();

                    myPlayArea.setMyPlayer(myPlayer);
                    setMyPlayer(myPlayer);
                    setMyBullet(myBullet);

                    myPlayArea.load();
                    myPlayArea.setMyCollisionDetector(myBullet, this);
                    System.out.println("Showing PlayArea");
                    myPlayArea.show();
                    myPlayer.init();

                    myPlayArea.startGameLoop();

                    chosen = true;
                    canShoot = true;
                }
                break;

            case KeyboardEvent.KEY_S:

                if (canShoot) {
                    myPlayArea.keepShooting();
                } else {
                    myPlayArea.stopShootingThread();
                }

                break;

            case KeyboardEvent.KEY_UP:
                if (myPlayer.canMoveUp()) {
                    myPlayer.moveUp();
                }
                break;

            case KeyboardEvent.KEY_DOWN:
                if (myPlayer.canMoveDown()) {
                    myPlayer.moveDown();
                }
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void setMyBullet(Bullet myBullet) {
        this.myBullet = myBullet;
    }

    public void setMyTarget(Target target) {
        this.myTarget = target;
    }

    public void setMyPlayer(Player player) {
        this.myPlayer = player;
    }

    public Bullet getMyBullet() {
        return myBullet;
    }

    public void setStartingScreen(StartingScreen sc) {
        this.mySC = sc;
    }

    public void setChoosePlayer(ChoosePlayer cp) {
        this.myCP = cp;
    }

    public void setMyPlayArea(PlayArea pa) {
        this.myPlayArea = pa;
    }

    public String getChosenPlayer() {
        return chosenPlayer;
    }
}
