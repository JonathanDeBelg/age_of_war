package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Ninja extends WalkingCharacters {

    private int health = 150;
    private int returnMoney = 100;
    private int damage = 60;
    private String tekst;

    /**
     *  Constructor
     * @param sprite de sprite url
     * @param direction de richting van de Character
     * @param aow het spel
     * @param cost de prijs van de Character
     */
    public Ninja(String sprite, int direction, AgeOfWar aow, int cost, String tekst) {
        super(new Sprite(sprite), direction, aow, 250);
        this.tekst = tekst;
    }

    @Override
    public String toString() {
        return tekst;
    }

    @Override
    public void doDamage(WalkingCharacters c) {
        c.setHealth(damage);
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
