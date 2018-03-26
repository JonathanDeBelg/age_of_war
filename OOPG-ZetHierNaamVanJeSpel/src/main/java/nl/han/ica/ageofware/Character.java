package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public abstract class Character extends SpriteObject {

    private final AgeOfWar aow;
    private int cost, damage;
    private int x = 0;
    private int y = 255;
    private int size = 25;

    public Character(AgeOfWar aow){
        super((new Sprite("src/main/java/nl/han/ica/ageofware/media/zombie-attack-test.gif")));
        this.aow = aow;
        setxSpeed(1);
    }

    @Override
    public void update(){
        if (getX()+getWidth()<=0) {
            setX(1500);
        }
    }
}
