package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

import java.util.List;

public class Zombie extends Character implements IWalkingCharacter {
    int direction;
    private int health = 100;

    public Zombie(int direction, String sprite) {
        super(new Sprite(sprite), direction);
    }

    @Override
    public void update() {
//        System.out.println("Doet iets");
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

//        @Override
//    public void move() {
//        System.out.println("Doet iets");
////    }
//
    @Override
   public void attack() {
//        Character enemy =
//        if(timer){
//            if(character.isFriend())
//            tegenstander.health -= 50;
//        }
    }
}
