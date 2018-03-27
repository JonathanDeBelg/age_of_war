package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.UserInput.IKeyInput;
import nl.han.ica.waterworld.Player;
import processing.core.PGraphics;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Playfield{
    AgeOfWar aow;
    RandomNPCPicker randomPicker;
    //CharacterFactory cf = new CharacterFactory(aow);
    ArrayList<Character> players;
    ArrayList<Character> npcs;

    public Playfield(AgeOfWar aow) {
        this.aow = aow;
        aow.addGameObject(new PlayerPicker(aow));
        players = new ArrayList<Character>();
        npcs = new ArrayList<Character>();
        randomPicker = new RandomNPCPicker(aow);
    }

    /**
     * Maakt de spelobjecten aan
     */
    public void createObjects() {
        Tower user = new Tower(aow, 0, aow.height - 255);
        Tower computer = new Tower(aow, aow.width-100, aow.height - 255);

        aow.addGameObject(user, user.getXpos(), user.getYpos());
        aow.addGameObject(computer, computer.getXpos(), computer.getYpos());

        Timer timer = new Timer();

        randomPicker.generateRandomNPC();

    }

    public void generateCharacter(){
    }
}
