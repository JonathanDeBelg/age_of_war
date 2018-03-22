package nl.han.ica.ageofware;


import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import processing.core.PGraphics;

public class Tower extends SpriteObject{

    private int x, y, health, saldo;
    private AgeOfWar aow;

    public int getXpos() {
        return x;
    }

    public int getYpos() {
        return y;
    }

    public Tower(AgeOfWar aow, int x, int y) {
        this(new Sprite("src/main/java/nl/han/ica/ageofware/media/coffin.png"));
        this.x = x;
        this.y = y;
        this.aow = aow;
//        this.health = health;
//        this.saldo = saldo;
    }

    /**
     * Create a new SpriteObject with a Sprite object.
     *
     * @param sprite
     */
    private Tower(Sprite sprite) {
        super(sprite);
    }

    void drawTower(){

    }

    @Override
    public void update() {

    }
}
