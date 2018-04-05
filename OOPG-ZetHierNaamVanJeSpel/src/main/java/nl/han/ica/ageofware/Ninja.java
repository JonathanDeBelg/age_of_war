package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Ninja extends Character {

    private int health = 125;
    private int returnMoney = 100;

    public Ninja(String sprite, int direction, AgeOfWar aow, int cost) {
        super(new Sprite(sprite), direction, aow, 250);
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
    public void setHealth(int hp) {
        health -= hp;
    }

    @Override
    public void returnMoneyOnDie() {
        aow.setSaldo(returnMoney, true);
    }
}
