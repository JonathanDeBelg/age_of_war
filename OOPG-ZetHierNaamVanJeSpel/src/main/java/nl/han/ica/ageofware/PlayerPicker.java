package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

public class PlayerPicker extends GameObject{
    @Override
    public void update() {
    }

    @Override
    public void draw(PGraphics g) {

    }

    public void keyPressed(int keyCode, char key) {
        if(keyCode == 49) {
//            character = new Zombie();
            System.out.println("ZOMBIE");
        } else {
//            character = null;
            System.out.println("NINJA");
        }
    }

    private Character generatePlayer(int keyCode) {
        Character character;

        if(keyCode == 49) {
            character = new Zombie();
        } else {
            character = null;
        }

        return character;
    }
}
