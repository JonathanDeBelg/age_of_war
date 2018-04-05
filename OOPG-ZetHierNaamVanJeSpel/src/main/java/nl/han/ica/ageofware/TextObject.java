package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

public class TextObject extends GameObject {

    private String text;

    /**
     * Constructor
     * @param text de tekst voor het object
     */
    public TextObject(String text) {
        this.text=text;
    }

    /**
     *  Past de tekst aan naar de parameter
     * @param text de tekst waarin het gezet moet worden
     */
    public void setText(String text) {
        this.text=text;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(PGraphics g) {
        g.textAlign(g.LEFT,g.TOP);
        g.textSize(25);
        g.color(255);
        g.text(text,10,10);
    }
}
