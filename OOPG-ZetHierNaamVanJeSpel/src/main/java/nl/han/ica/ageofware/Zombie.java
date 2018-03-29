package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

import java.util.List;

public class Zombie extends Character implements IWalkingCharacter {
    int direction;
    private int health;

    public Zombie(int direction, String sprite) {
        super(new Sprite(sprite), direction);
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
    @Override
    public void attack() {
        setxSpeed(0);

    }
}
