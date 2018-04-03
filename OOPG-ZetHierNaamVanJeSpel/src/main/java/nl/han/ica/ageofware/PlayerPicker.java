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
    long startTijd;

    public PlayerPicker(AgeOfWar aow) {
        this.aow = aow;
        xPos = 25;
        yPos = 615;
        characters = new ArrayList<Character>();
        startTijd = System.currentTimeMillis() - 2500;
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
        generatePlayer(keyCode);
        System.out.println(aow.getSaldo());
    }

    private void generatePlayer(int keyCode){
        Character c;
        if (tijdVoorbij(startTijd, 2500)) {
            if (keyCode == 49) {
                c = new Zombie("src/main/java/nl/han/ica/ageofware/media/zombie-attack-test.gif", 1, aow, 100);
                checkSaldoOnPlayerSpawn(c);
            } else if (keyCode == 50) { //} else if (keyCode == 50 && player.getSaldo() >= 50) {
                c = new Ninja("src/main/java/nl/han/ica/ageofware/media/ninja-attack.gif", 1, aow, 250);
                checkSaldoOnPlayerSpawn(c);
            } else if (keyCode == 51) {
                System.out.println("Vogel");
            } else if (keyCode == 52) {
                System.out.println("RIDDER");
            }
            startTijd = System.currentTimeMillis();
        }
    }

    private void addCharacter(Character c) {
        characters.add(c);
        addCharacterToList(characters);
        aow.addGameObject(c, xPos, yPos);
    }

    private void checkSaldoOnPlayerSpawn(Character c){
        if (c.getCost() <= aow.getSaldo()) {
            addCharacter(c);
            aow.setSaldo(c.getCost(), false);
        } else {
            System.out.println("Niet genoeg saldo!");
        }
    }

    private void addCharacterToList(ArrayList<Character> characters) {
        for (Character c: characters) {
            if(c instanceof Character) {
                Character o = (Character) c;
                o.addFriends(o);
            }
        }
    }

    private boolean tijdVoorbij(long startTijd, int interval){
        return System.currentTimeMillis() - startTijd >= interval;
    }

    public void die(Character c){
        aow.deleteGameObject(c);
    }
}