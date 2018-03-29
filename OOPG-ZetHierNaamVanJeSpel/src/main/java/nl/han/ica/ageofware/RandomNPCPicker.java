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


        int randomCharacter = rand.nextInt(2) + 1;

        Character c = new Zombie(-1, "src/main/java/nl/han/ica/ageofware/media/zombie-attack-npc.gif");
        c.setDirection(360);
        if (randomCharacter == 1) {
            c = new Zombie((int) c.getDirection(), "src/main/java/nl/han/ica/ageofware/media/zombie-attack-npc.gif");
            c.setDirectionSpeed((int) c.getDirection(), -1);
            aow.addGameObject(c, aow.width - 200, aow.height - 135);
            System.out.println("dingen");
        } else {
            System.out.println("andere dingen");
        }
    }

    @Override
    public void run() {
        generateRandomNPC();
    }
}
