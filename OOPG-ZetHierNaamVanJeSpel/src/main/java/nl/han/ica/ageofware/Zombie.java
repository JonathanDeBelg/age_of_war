package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Zombie extends WalkingCharacters {
    private int health = 100;
    private int returnMoney = 75;
    private int damage = 40;

    public Zombie(String sprite, int direction, AgeOfWar aow, int cost) {
        super(new Sprite(sprite), direction, aow, cost);
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
    public void setHealth(int health) {
        this.health -= health;
    }

    @Override
    public void returnMoneyOnDie() {
        aow.setSaldo(returnMoney, true);
    }

}
