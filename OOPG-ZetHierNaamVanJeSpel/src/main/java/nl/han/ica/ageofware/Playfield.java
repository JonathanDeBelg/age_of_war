package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.UserInput.IKeyInput;
import nl.han.ica.waterworld.Player;
import processing.core.PGraphics;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Playfield extends Timer{
    AgeOfWar aow;
    RandomNPCPicker randomPicker;
    private int timerMin = 35;
    private int timerMax = 75;
    public Playfield(AgeOfWar aow) {
        this.aow = aow;
        aow.addGameObject(new PlayerPicker(aow));
        randomPicker = new RandomNPCPicker(aow);
    }

    /**
     * Maakt de spelobjecten aan
     */
    public void createObjects() {
        Tower user = new Tower(aow, 0, aow.height - 255);
        Tower computer = new Tower(aow, aow.width-100, aow.height - 255);

        Random rand = new Random();

        int randomCharacterSpawnTime = rand.nextInt((timerMax - timerMin) + 1) + timerMin;
        aow.addGameObject(user, user.getXpos(), user.getYpos());
        aow.addGameObject(computer, computer.getXpos(), computer.getYpos());

        Timer timer = new Timer();
        TimerTask tasknew = new RandomNPCPicker(aow);

        timer.schedule(tasknew, 0, (randomCharacterSpawnTime * 100));

    }

    public void generateCharacter(){
    }
}
