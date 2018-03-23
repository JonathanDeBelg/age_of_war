package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public abstract class Character extends AnimatedSpriteObject{

    private final AgeOfWar aow;
    private int cost, damage;
    private int x = 0;
    private int y = 255;
    private int size = 25;

    public Character(AgeOfWar aow){
        super((new Sprite("src/main/java/nl/han/ica/ageofware/media/zombie_attack.gif")), 1);
        this.aow = aow;
    }

    public abstract void move();

    public abstract void attack();
}
