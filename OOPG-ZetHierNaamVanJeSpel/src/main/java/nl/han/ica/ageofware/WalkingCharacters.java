package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public abstract class WalkingCharacters extends Character {
    public WalkingCharacters(Sprite sprite, int direction, AgeOfWar aow, int cost) {
        super(sprite, direction, aow, cost);
    }

    @Override
    public abstract void doDamage(WalkingCharacters c);

    public abstract int getHealth();

    public abstract void setHealth(int health);

    public abstract void returnMoneyOnDie();
}
