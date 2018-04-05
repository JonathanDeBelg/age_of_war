package nl.han.ica.ageofware;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;


public class RandomNPCPicker extends TimerTask implements CharacterFactory{
    Timer timer;
    private AgeOfWar aow;
    private ArrayList<Character> characters;

    /**
     * Constructor
     * @param aow het spel
     */
    public RandomNPCPicker(AgeOfWar aow){
        this.aow = aow;
        timer =  new Timer();
        characters = new ArrayList<Character>();
    }

    /**
     * Genereert de random NPC
     */
    public void generateRandomNPC(){
        Random rand = new Random();
        int randomCharacter = rand.nextInt(20) + 1;
        WalkingCharacters c = new Zombie("src/main/java/nl/han/ica/ageofware/media/zombie-attack-npc.gif",-1, aow, 100, "Enemy");
        FlyingCharacter fc = new Bird("src/main/java/nl/han/ica/ageofware/media/bird.gif", -1, aow, 500,"Enemy");
        if (randomCharacter <= 14) {
            c = new Zombie("src/main/java/nl/han/ica/ageofware/media/zombie-attack-npc.gif",-1, aow, 100, "Enemy");
            System.out.println("zombie");
            setCharacterStats(c);
            addCharacter(c);
        } else if(randomCharacter > 14 && randomCharacter < 19 ) {
            c = new Ninja("src/main/java/nl/han/ica/ageofware/media/ninja-attack-npc.gif", -1, aow, 250, "Enemy");
            System.out.println("ninja");
            setCharacterStats(c);
            addCharacter(c);
        } else if(randomCharacter == 20) {
            fc = new Bird("src/main/java/nl/han/ica/ageofware/media/bird.gif", -1, aow, 500, "Enemy");
            System.out.println("ninja");
            setCharacterStats(fc);
            addCharacter(fc);
        }
    }

    /**
     * Zet de positie en richting van de Character
     * @param c de character
     */
    private void setCharacterStats(Character c) {
        c.setX(1200);
        c.setDirection(270);
        c.setDirectionSpeed((int) c.getDirection(), -1);
    }

    @Override
    public void addCharacter(Character c) {
        if(c instanceof WalkingCharacters) {
            c.setY(615);
        } else {
            c.setY(200);
        }
        characters.add(c);
        addCharacterToList(characters, c);
        c.setDirectionSpeed((int) c.getDirection(), -1);
        System.out.println(c.getX());
        aow.addGameObject(c, c.getX(), c.getY());
    }

    @Override
    public void addCharacterToList(ArrayList<Character> characters, Character character) {
        for (Character c: characters) {
            if(c instanceof Character) {
                c.setFriends(characters);
            }
        }

    }

    @Override
    public void run() {
        generateRandomNPC();
    }
}
