package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.UserInput.IKeyInput;
import nl.han.ica.waterworld.Player;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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

//        PlayerPicker playpicker = new PlayerPicker();
//        Character zombie = new Zombie(aow);
//        Character zombie2 = new Zombie(aow);

        aow.addGameObject(user, user.getXpos(), user.getYpos());
        aow.addGameObject(computer, computer.getXpos(), computer.getYpos());

        Timer timer = new Timer();

        timer.schedule(run(), 0, 5000);
//        aow.addGameObject(randomPicker.generateRandomNPC(), 25,aow.height - 135);
//        aow.addGameObject(zombie, 25, aow.height - zombie.getHeight() - 60);
//        aow.addGameObject(zombie2, 50, aow.height - zombie.getHeight() - 60);
//        aow.addGameObject(playpicker);

        for (character: npcs) {

        }

    }

    public void generateCharacter(){
        PlayerPicker playpicker = new PlayerPicker();

//        if(playpicker.keyPressed() == 1){
//            new Zombie
//
//        }
    }
}
