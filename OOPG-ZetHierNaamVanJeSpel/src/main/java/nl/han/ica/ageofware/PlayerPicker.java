package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;

public class PlayerPicker extends GameObject{

    private AgeOfWar aow;
    private int xPos;
    private int yPos;
    private long prevMillis = 0;
    private ArrayList<Character> characters;

    public PlayerPicker(AgeOfWar aow) {
        this.aow = aow;
        xPos = 25;
        yPos = 615;
        characters = new ArrayList<Character>();
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(PGraphics g) {}

    @Override
    public void keyReleased(int keyCode, char key) {
        spawnPlayer(keyCode);
    }

    private void spawnPlayer(int keyCode) {
        long currentMillis = System.currentTimeMillis();

        if ((currentMillis - prevMillis) >= 2500){
            generatePlayer(keyCode);
            prevMillis = currentMillis;
        } else {
            System.out.println("De timer is nog niet voorbij");
        }
    }

    private void generatePlayer(int keyCode){
        Character c = new Zombie(1, "src/main/java/nl/han/ica/ageofware/media/zombie-attack-test.gif");
        if (keyCode == 49) { //if (keyCode == 49 && player.getSaldo() >= 25) {
            c = new Zombie(1, "src/main/java/nl/han/ica/ageofware/media/zombie-attack-test.gif");
//            player.setSaldo -= 25;
        } else if (keyCode == 50) { //} else if (keyCode == 50 && player.getSaldo() >= 50) {
            c = new Ninja(1,"src/main/java/nl/han/ica/ageofware/media/ninja-attack.gif");
//            player.setSaldo -= 50;
        } else if (keyCode == 51) {
            System.out.println("Vogel");
        } else if (keyCode == 52) {
            System.out.println("RIDDER");
        }
        characters.add(c);
        addCharacterToList(characters);
        aow.addGameObject(c, xPos, yPos);
    }

    private void addCharacterToList(ArrayList<Character> characters) {
        for (Character c: characters) {
            if(c instanceof Character) {
                Character o = (Character) c;
                o.addFriends(o);
            }
        }
    }

    public void die(Character c){
        aow.deleteGameObject(c);
    }
}