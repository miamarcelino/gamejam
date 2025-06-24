package io.codeforall.bootcamp.screens;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ChoosePlayer {

    private Picture cp;

    private Picture danielTitle;
    private Picture mariaTitle;
    private Picture gustavoTitle;

    private Picture daniel;
    private Picture maria;
    private Picture gustavo;

    private Picture press1;
    private Picture press2;
    private Picture press3;


    public ChoosePlayer() {
        cp = new Picture(10, 10, "resources/Background/choose-player-screen.png");

        danielTitle = new Picture(65, 100, "resources/Buttons/daniel-title.png");
        mariaTitle = new Picture(490, 100, "resources/Buttons/maria-title.png");
        gustavoTitle = new Picture(890, 100, "resources/Buttons/gustavo-title.png");

        daniel = new Picture(110, 280, "resources/Player/Daniel/daniel-still-choose.png");
        maria = new Picture(530, 290, "resources/Player/Maria/maria-still-choose.png");
        gustavo = new Picture(930, 290, "resources/Player/Gustavo/gustavo-still-choose.png");

        press1 = new Picture(120, 500, "resources/Buttons/press-1.png");
        press2 = new Picture(530, 500, "resources/Buttons/press-2.png");
        press3 = new Picture(930, 500, "resources/Buttons/press-3.png");
    }

    public void load() {
        cp.draw();

        danielTitle.draw();
        mariaTitle.draw();
        gustavoTitle.draw();

        daniel.draw();
        maria.draw();
        gustavo.draw();

        press1.draw();
        press2.draw();
        press3.draw();
    }

    public void delete() {
        cp.delete();

        danielTitle.delete();
        mariaTitle.delete();
        gustavoTitle.delete();

        daniel.delete();
        maria.delete();
        gustavo.delete();

        press1.delete();
        press2.delete();
        press3.delete();
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

        daniel.draw();
        maria.draw();
        gustavo.draw();
    }

    private void delayImage(int ms) {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
