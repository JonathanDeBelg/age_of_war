package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public abstract class WalkingCharacters extends Character {
    public WalkingCharacters(Sprite sprite, int direction, AgeOfWar aow, int cost) {
        super(sprite, direction, aow, cost);
    }

    @Override
    public abstract void doDamage(WalkingCharacters c);

    /**
     * De health van een lopende character
     * @return de health van een character
     */
    public abstract int getHealth();

    /**
     * zet de health voor de character
     * @param health de health van de character
     */
    public abstract void setHealth(int health);

    /**
     * zet het saldo van de player hoger wanneer de tegenstander dood is
     */
    public abstract void returnMoneyOnDie();
}
