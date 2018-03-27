package nl.han.ica.ageofware;
import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;


public class RandomNPCPicker{

    public Character generateRandomNPC(){
        Random rand = new Random();
        int randomCharacter = rand.nextInt(2) + 1;

        Character character;

        if (randomCharacter == 1) {
            character = new Zombie();

        } else {
            return character = new Zombie();
        }

        return character;
    }
}
