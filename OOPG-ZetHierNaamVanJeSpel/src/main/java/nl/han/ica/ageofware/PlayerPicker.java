package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

public class PlayerPicker extends GameObject {

    private AgeOfWar aow;
    private int xPos;
    private int yPos;

    public PlayerPicker(AgeOfWar aow) {
        this.aow = aow;
        xPos = 25;
        yPos = 615;
    }
    @Override
    public void update() {
    }

    @Override
    public void draw(PGraphics g) {}

    @Override
    public void keyReleased(int keyCode, char key) {
        generatePlayer(keyCode);
    }

    private void generatePlayer(int keyCode) {
        Character c = new Zombie(1);
        c.setDirection(1);
        if(keyCode == 49) {
            c = new Zombie(1);
        } else if(keyCode == 50) {
            System.out.println("NINJA");
        } else if(keyCode == 51) {
            System.out.println("Vogel");
        } else if(keyCode == 52) {
            System.out.println("RIDDER");
        }
        aow.addGameObject(c, xPos, yPos);
    }
}
