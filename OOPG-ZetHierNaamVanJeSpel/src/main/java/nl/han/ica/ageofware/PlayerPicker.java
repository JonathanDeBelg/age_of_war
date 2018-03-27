package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

public class PlayerPicker extends GameObject{

    public void run() {
        System.out.println("Random tekst");
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(PGraphics g) {

    }

    public void keyPressed(int keyCode, char key) {
        System.out.println(keyCode);
        maakCharacter(keyCode);
    }

    private Character maakCharacter(int keyCode) {
        Character character;

        if(keyCode == 49) {
            character = new Zombie();
        } else {
            character = null;
        }

        return character;
    }
}
