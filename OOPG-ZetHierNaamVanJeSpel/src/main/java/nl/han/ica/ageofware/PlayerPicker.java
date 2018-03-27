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

    @Override
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
