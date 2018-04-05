package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Ridder extends Character {
    int direction;
    private int health = 150;
    long prevMillis = 0;
    private int returnMoney = 120;

    public Ridder(String sprite, int direction, AgeOfWar aow, int cost) {
        super(new Sprite(sprite), direction, aow, cost);
    }

    @Override
    public void doDamage(Character c) {
        c.setHealth(80);
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health -= health;
    }

    @Override
    public void returnMoneyOnDie() {
        aow.setSaldo(returnMoney, true);
    }

}
