package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Zombie extends WalkingCharacters {
    int direction;
    private int health = 100;
    long prevMillis = 0;
    private int returnMoney = 75;
    String tekst;

    /**
     * Constructor
     * @param sprite de sprite
     * @param direction de richting van de character
     * @param aow het spel
     * @param cost de prijs van de character
     * @param tekst een relevante tekst voor de character
     */
    public Zombie(String sprite, int direction, AgeOfWar aow, int cost, String tekst) {
        super(new Sprite(sprite), direction, aow, cost);
        this.tekst = tekst;
    }

    @Override
    public String toString() {
        return tekst;
    }

    @Override
    public void doDamage(WalkingCharacters c) {
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

    @Override
    public void returnMoneyOnDie() {
        aow.setSaldo(returnMoney, true);
    }

}
