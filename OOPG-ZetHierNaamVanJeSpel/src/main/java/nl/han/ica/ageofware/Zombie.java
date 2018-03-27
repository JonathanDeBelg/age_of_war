package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;

public class Zombie extends Character {
    int direction;


    public Zombie(int direction) {
        super(new Sprite("src/main/java/nl/han/ica/ageofware/media/zombie-attack-test.gif"), direction);
    }

    @Override
    public void update() {
//        System.out.println("Doet iets");
    }

//    @Override
//    public void move() {
//        System.out.println("Doet iets");
//    }
//
//    @Override
//    public void attack() {
//        System.out.println("Doet iets");
//    }
}
