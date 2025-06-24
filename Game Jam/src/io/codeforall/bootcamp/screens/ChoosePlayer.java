package io.codeforall.bootcamp.screens;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ChoosePlayer {

    private Picture cp;
    private Picture daniel;
    private Picture maria;
    private Picture gustavo;

    private Picture press1;
    private Picture press2;
    private Picture press3;

    public ChoosePlayer() {
        cp = new Picture(10, 10, "resources/Background/choose-player-screen.png");

        press1 = new Picture(120, 200, "resources/Buttons/press-1.png");
        press2 = new Picture(530, 200, "resources/Buttons/press-2.png");
        press3 = new Picture(900, 200, "resources/Buttons/press-3.png");

        daniel = new Picture(100, 280, "resources/Player/Daniel/daniel-still-choose.png");
        maria = new Picture(560, 280, "resources/Player/Daniel/daniel-still-choose.png");
        gustavo = new Picture(890, 280, "resources/Player/Daniel/daniel-still-choose.png");
    }

    public void load() {
        cp.draw();

        press1.draw();
        press2.draw();
        press3.draw();


        daniel.draw();
        maria.draw();
        gustavo.draw();
    }

    public void delete() {
        cp.delete();

        press1.delete();
        press2.delete();
        press3.delete();

        daniel.delete();
        maria.delete();
        gustavo.delete();
    }

    public void flashingHeads(int ms) {
        for (int i = 0; i < 20; i++) {
            delayImage(ms);
            daniel.draw();
            maria.draw();
            gustavo.draw();

            delayImage(ms);
            daniel.delete();
            maria.delete();
            gustavo.delete();
        }
    }

    private void delayImage(int ms) {

        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
