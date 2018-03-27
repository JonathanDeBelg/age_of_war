package nl.han.ica.ageofware;
import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;


public class RandomNPCPicker{

    private AgeOfWar aow;

    public RandomNPCPicker(AgeOfWar aow){
        this.aow = aow;

    }

    public void generateRandomNPC(){
        Random rand = new Random();
        int randomCharacter = rand.nextInt(2) + 1;

        Character character;

        if (randomCharacter == 1) {
            aow.addGameObject(new Zombie(-1), aow.width - 200, aow.height - 135);
            System.out.println("dingen");

        } else {
            System.out.println("andere dingen");

        }


    }
}
