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

    public RandomNPCPicker(AgeOfWar aow){
        this.aow = aow;
        timer =  new Timer();
    }

    public void generateRandomNPC(){
        Random rand = new Random();


        int randomCharacter = rand.nextInt(5) + 1;

        Character c = new Zombie("src/main/java/nl/han/ica/ageofware/media/zombie-attack-npc.gif",-1, aow);
        c.setDirection(360);
        if (randomCharacter <= 4) {
            c = new Zombie("src/main/java/nl/han/ica/ageofware/media/zombie-attack-npc.gif",(int)c.getDirection(), aow);
            System.out.println("zombie");
        } else {
            c = new Zombie("src/main/java/nl/han/ica/ageofware/media/ninja-attack-npc.gif", (int)c.getDirection(), aow);
            System.out.println("ninja");
        }

        c.setDirectionSpeed((int) c.getDirection(), -1);
        aow.addGameObject(c, aow.width - 100, aow.height - 135);
    }

    @Override
    public void run() {
        generateRandomNPC();
    }
}
