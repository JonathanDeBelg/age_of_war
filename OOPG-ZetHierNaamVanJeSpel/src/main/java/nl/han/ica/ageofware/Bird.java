package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Bird extends FlyingCharacter {

    private String tekst;

    /**
     *  Constructor
     * @param sprite de sprite url
     * @param direction de richting van de Character
     * @param aow het spel
     * @param cost de prijs van de Character
     */
    public Bird(String sprite, int direction, AgeOfWar aow, int cost, String tekst) {
        super(new Sprite(sprite), direction, aow, cost);
        this.tekst = tekst;
    }

    @Override
    public void doDamage(WalkingCharacters c) {

    }
}
