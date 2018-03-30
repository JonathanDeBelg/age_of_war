package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

import java.util.List;

public class Zombie extends Character implements IWalkingCharacter {
    int direction;
    private int health = 100;
    long prevMillis = 0;
    AgeOfWar aow;

    public Zombie(int direction, String sprite) {
        super(new Sprite(sprite), direction);
    }

    @Override
    public void update() {
//        System.out.println("Doet iets");
    }

    @Override
    public void doDamage(Character c) {
        System.out.println("min 50 healht");
        health -= 50;
    }

    @Override
    public int getHealth() {
        return health;
    }

}
