package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.UserInput.IKeyInput;
import nl.han.ica.waterworld.Player;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static sun.misc.PostVMInitHook.run;

public class Playfield{
    AgeOfWar aow;
    RandomNPCPicker randomPicker = new RandomNPCPicker();
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
