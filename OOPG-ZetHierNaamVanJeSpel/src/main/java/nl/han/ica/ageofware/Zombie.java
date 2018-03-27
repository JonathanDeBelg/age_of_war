package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

import java.util.List;

public class Zombie extends Character {
    int direction;


    public Zombie(int direction) {
        super(new Sprite("src/main/java/nl/han/ica/ageofware/media/zombie-attack-test.gif"), direction);
    }

    @Override
    public void update() {
//        System.out.println("Doet iets");
    }

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject object: collidedGameObjects) {
            if(object instanceof Character) {
                attack();
            }

        }
    }

//    @Override
//    public void move() {
//        System.out.println("Doet iets");
//    }
//
    public void attack() {
        setxSpeed(0);
    }
}
