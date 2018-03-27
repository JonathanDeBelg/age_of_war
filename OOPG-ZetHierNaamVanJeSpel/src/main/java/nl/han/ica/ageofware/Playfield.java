package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.UserInput.IKeyInput;
import nl.han.ica.waterworld.Player;
import processing.core.PGraphics;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Playfield{
    AgeOfWar aow;
    RandomNPCPicker randomPicker = new RandomNPCPicker();
    PlayerPicker playerPicker = new PlayerPicker();

    ArrayList<Character> players;
    ArrayList<Character> npcs;

    public Playfield(AgeOfWar aow) {
        this.aow = aow;
        players = new ArrayList<Character>();
        npcs = new ArrayList<Character>();
    }

    /**
     * Maakt de spelobjecten aan
     */
    public void createObjects() {
        Tower user = new Tower(aow, 0, aow.height - 255);
        Tower computer = new Tower(aow, aow.width-100, aow.height - 255);
        aow.addGameObject(user,0, aow.height - 61 - user.getHeight());
        aow.addGameObject(computer,aow.width-computer.getWidth(), aow.height - 61 - computer.getHeight());

//        Character zombie = new Zombie(aow);
//        Character zombie2 = new Zombie(aow);

        aow.addGameObject(user, user.getXpos(), user.getYpos());
        aow.addGameObject(computer, computer.getXpos(), computer.getYpos());

        Timer timer = new Timer();

//        timer.schedule(run(), 0, 5000);
//        aow.addGameObject(randomPicker.generateRandomNPC(), 25,aow.height - 135);
//        aow.addGameObject(zombie, 25, aow.height - zombie.getHeight() - 60);
//        aow.addGameObject(zombie2, 50, aow.height - zombie.getHeight() - 60);
//        aow.addGameObject(playpicker);

        npcs.add(new Zombie());
        players.add(new Zombie());
    }

    public void generateCharacter(){
        for (Character npc: npcs) {
            aow.addGameObject(npc, 100, aow.height - 135);
        }

        for (Character player: players) {
            aow.addGameObject(player, 25, aow.height - 135);
        }
    }
}
