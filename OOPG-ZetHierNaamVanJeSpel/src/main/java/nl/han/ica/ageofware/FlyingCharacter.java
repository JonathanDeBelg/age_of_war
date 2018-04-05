package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public abstract class FlyingCharacter extends Character {
    public FlyingCharacter(Sprite sprite, int direction, AgeOfWar aow, int cost) {
        super(sprite, direction, aow, cost);
    }

    @Override
    public abstract void doDamage(Character c);
}
