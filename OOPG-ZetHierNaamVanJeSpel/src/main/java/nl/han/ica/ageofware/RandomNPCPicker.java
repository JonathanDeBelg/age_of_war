package nl.han.ica.ageofware;
import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;


public class RandomNPCPicker extends TimerTask{
    Timer timer;
    private AgeOfWar aow;
    private ArrayList<Character> characters;

    public RandomNPCPicker(AgeOfWar aow){
        this.aow = aow;
        timer =  new Timer();
        characters = new ArrayList<Character>();
    }

    public void generateRandomNPC(){
        Random rand = new Random();
        int randomCharacter = rand.nextInt(5) + 1;

        Character c = new Zombie("src/main/java/nl/han/ica/ageofware/media/zombie-attack-npc.gif",-1, aow, 100);
        c.setDirection(360);
        if (randomCharacter <= 4) {
            c = new Zombie("src/main/java/nl/han/ica/ageofware/media/zombie-attack-npc.gif",(int)c.getDirection(), aow, 100);
            System.out.println("zombie");
            addCharacter(c);
        } else {
            c = new Ninja("src/main/java/nl/han/ica/ageofware/media/ninja-attack-npc.gif", (int)c.getDirection(), aow, 250);
            System.out.println("ninja");
            addCharacter(c);
        }
        c.setDirectionSpeed((int) c.getDirection(), -1);
    }

    private void addCharacter(Character c) {
        characters.add(c);
        addCharacterToList(characters);
        aow.addGameObject(c, aow.width - 100, aow.height - 135);
    }

    private void addCharacterToList(ArrayList<Character> characters) {
        for (Character c: characters) {
            if(c instanceof Character) {
                Character o = (Character) c;
                o.addFriends(o);
            }
        }
    }

    @Override
    public void run() {
        generateRandomNPC();
    }
}
