package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Ninja extends Character implements IWalkingCharacter {

    private int health = 125;

    public Ninja(String sprite, int direction, AgeOfWar aow) {
        super(new Sprite(sprite), direction, aow);
    }


    @Override
    public void doDamage(Character c) {
        c.setHealth() -= 40;
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
