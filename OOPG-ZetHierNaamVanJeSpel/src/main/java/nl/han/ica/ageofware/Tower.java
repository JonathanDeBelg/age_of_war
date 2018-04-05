package nl.han.ica.ageofware;


import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.waterworld.TextObject;
import processing.core.PGraphics;

import javax.swing.*;

public class Tower extends SpriteObject {

    private int x, y, health;
    public int saldo;
    private AgeOfWar aow;
    private TextObject towerHealth;


    public Tower(AgeOfWar aow, int x, int y) {
        this(new Sprite("src/main/java/nl/han/ica/ageofware/media/coffin.png"));
        this.x = x;
        this.y = y;
        this.aow = aow;
        this.saldo = 1000;
        this.health = 200;

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int hp) {
        health = health - hp;
    }

    public int getXpos() {
        return x;
    }

    public int getYpos() {
        return y;
    }

    /**
     * Create a new SpriteObject with a Sprite object.
     *
     * @param sprite
     */
    private Tower(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void update() {
//        aow.refreshTowerText();
    }
}
