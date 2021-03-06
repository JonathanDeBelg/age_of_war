package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;

public class PlayerPicker extends GameObject implements CharacterFactory {

    private AgeOfWar aow;
    private int xPos;
    private int yPos;
    private long prevMillis = 0;
    private ArrayList<Character> characters;
    long startTijd;

    /**
     * Constructor
     * @param aow het spel
     */
    public PlayerPicker(AgeOfWar aow) {
        this.aow = aow;
        setX(105);
        //xPos = 105;
        //yPos = 615;
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

    /**
     * het genereren van de Character
     * @param keyCode De ingedrukte key
     */
    private void spawnPlayer(int keyCode) {
        generatePlayer(keyCode);
        System.out.println(aow.getSaldo());
    }

    /**
     * het genereren van de Character
     * @param keyCode De ingedrukte key
     */
    private void generatePlayer(int keyCode){
        System.out.println(keyCode);
        if (tijdVoorbij(startTijd, 2500)) {
            if (keyCode == 49) {
                WalkingCharacters c = new Zombie("src/main/java/nl/han/ica/ageofware/media/zombie-attack-test.gif", 1, aow, 100, "friend");
                checkSaldoOnPlayerSpawn(c);
            } else if (keyCode == 50) { //} else if (keyCode == 50 && player.getSaldo() >= 50) {
                WalkingCharacters c = new Ninja("src/main/java/nl/han/ica/ageofware/media/ninja-attack.gif", 1, aow, 250, "friend");
                checkSaldoOnPlayerSpawn(c);
            } else if (keyCode == 51) {
                FlyingCharacter c = new Bird("src/main/java/nl/han/ica/ageofware/media/bird.gif", 1, aow, 50, "friend");
                checkSaldoOnPlayerSpawn(c);
            }
        }
    }

    @Override
    public void addCharacter(Character c) {
        if(c instanceof WalkingCharacters) {
            setY(615);
        } else {
            setY(200);
        }
        characters.add(c);
        addCharacterToList(characters, c);
        System.out.println(getY());
        aow.addGameObject(c, getX(), getY());
        startTijd = System.currentTimeMillis();
    }

    @Override
    public void addCharacterToList(ArrayList<Character> characters, Character character) {

        for (Character c: characters) {
            if(c instanceof Character) {
                c.setFriends(characters);
            }
        }
    }

    /**
     * Controleerd of er voldoende saldo is
     * @param c de Character die toegevoegd wordt
     */
    private void checkSaldoOnPlayerSpawn(Character c){
        if (c.getCost() <= aow.getSaldo()) {
            addCharacter(c);
            aow.setSaldo(c.getCost(), false);
        } else {
            System.out.println("Niet genoeg saldo!");
        }
    }

    /**
     * Controleerd of de tijd al voorbij is
     * @param startTijd de starttijd
     * @param interval de interval tussen de starttijd en de tijd dat het nu is
     * @return true / false of de tijd al voorbij is
     */
    private boolean tijdVoorbij(long startTijd, int interval){
        return System.currentTimeMillis() - startTijd >= interval;
    }
}