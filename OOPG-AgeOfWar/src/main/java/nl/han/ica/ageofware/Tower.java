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

    /**
     * Constructor
     * @param aow het spel
     * @param x de x positie van de toren
     * @param y de y positie van de toren
     */
    public Tower(AgeOfWar aow, int x, int y) {
        this(new Sprite("src/main/java/nl/han/ica/ageofware/media/coffin.png"));
        this.x = x;
        this.y = y;
        this.aow = aow;
        this.saldo = 1000;
        this.health = 200;

    }

    /**
     * Constructor
     * @param sprite de sprite van de Tower
     */
    private Tower(Sprite sprite) {
        super(sprite);
    }

    /**
     * Retourneert de health van de toren
     * @return de health van de toren
     */
    public int getHealth() {
        return health;
    }

    /**
     * zet de nieuwe health voor de toren
     * @param hp de health die van de oude health af gehaald moet worden
     */
    public void setHealth(int hp) {
        health = health - hp;
    }

    /**
     * Retourneert de x positie van de toren
     * @return de x positie van de toren
     */
    public int getXpos() {
        return x;
    }

    /**
     * Retourneert de y positie van de toren
     * @return y positie van de toren
     */
    public int getYpos() {
        return y;
    }

    @Override
    public void update() {
    }
}
