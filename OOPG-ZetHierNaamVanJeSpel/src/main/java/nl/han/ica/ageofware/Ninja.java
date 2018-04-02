package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Ninja extends Character implements IWalkingCharacter {



    public Ninja(int direction, String sprite) {
        super(new Sprite(sprite), direction);
    }


    @Override
    public void doDamage(Character c) {

    }

    @Override
    public int getHealth() {
        return 0;
    }
}
