package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

import java.util.List;

public class Zombie extends Character {
    int direction;


    public Zombie(int direction, boolean player) {
        super(new Sprite("src/main/java/nl/han/ica/ageofware/media/zombie-attack-test.gif"), direction, player);
    }

    @Override
    public void update() {
//        System.out.println("Doet iets");
    }

//    @Override
//    public void move() {
//        System.out.println("Doet iets");
//    }
//
    public void attack() {
        setxSpeed(0);
    }
}
