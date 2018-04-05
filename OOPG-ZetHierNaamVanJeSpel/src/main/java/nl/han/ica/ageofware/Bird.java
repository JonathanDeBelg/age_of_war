package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Bird extends FlyingCharacter {
    public Bird(String sprite, int direction, AgeOfWar aow, int cost) {
        super(new Sprite(sprite), direction, aow, cost);
    }

    @Override
    public void doDamage(WalkingCharacters c) {

    }
}
