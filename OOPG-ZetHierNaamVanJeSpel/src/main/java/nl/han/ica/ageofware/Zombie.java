package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

import java.util.List;

public class Zombie extends Character implements IWalkingCharacter {
    int direction;
    private int health = 100;
    long prevMillis = 0;

    public Zombie(String sprite, int direction, AgeOfWar aow) {
        super(new Sprite(sprite), direction, aow);
    }


    @Override
    public void doDamage(Character c) {
        c.setHealth(40);
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health -= health;
    }

}
