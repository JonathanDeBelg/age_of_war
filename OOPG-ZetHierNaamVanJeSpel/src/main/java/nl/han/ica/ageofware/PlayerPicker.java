package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

public class PlayerPicker extends GameObject{
<<<<<<< HEAD
=======

>>>>>>> 7f78a233d3a775ca32808b872a34d23290d2770a
    @Override
    public void update() {
    }

    @Override
    public void draw(PGraphics g) {

    }

    @Override
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
