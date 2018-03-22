package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

public abstract class Character extends GameObject {

    private int cost, damage;

    public Character(int cost, int damage){
        this.cost = cost;
        this.damage = damage;
    }

    public abstract void move();

    public abstract void attack();

    public void drawCharacter(){
        //code
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(PGraphics g) {

    }
}
