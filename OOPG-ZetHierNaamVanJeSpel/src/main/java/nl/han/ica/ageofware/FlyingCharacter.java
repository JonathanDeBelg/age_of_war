package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public abstract class FlyingCharacter extends Character {

    /**
     *  Constructor
     * @param sprite de sprite url
     * @param direction de richting van de Character
     * @param aow het spel
     * @param cost de prijs van de Character
     */
    public FlyingCharacter(Sprite sprite, int direction, AgeOfWar aow, int cost) {
        super(sprite, direction, aow, cost);
    }

    @Override
    public abstract void doDamage(WalkingCharacters c);
}
