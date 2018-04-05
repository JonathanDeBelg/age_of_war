package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.waterworld.TextObject;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Playfield extends Timer{
    AgeOfWar aow;
    CharacterFactory randomPicker;

    private int timerMin = 70;
    private int timerMax = 80;

    Tower user;
    Tower computer;

    /**
     * Constructor
     * @param aow het spel
     */
    public Playfield(AgeOfWar aow) {
        this.aow = aow;
        aow.addGameObject(new PlayerPicker(aow));
        randomPicker = new RandomNPCPicker(aow);
    }

    /**
     * Maakt de spelobjecten aan
     */
    public void createObjects() {
        user = new Tower(aow, 0, aow.height - 255);
        computer = new Tower(aow, aow.width-100, aow.height - 255);

        Random rand = new Random();

        int randomCharacterSpawnTime = rand.nextInt((timerMax - timerMin) + 1) + timerMin;
        aow.addGameObject(user, user.getXpos(), user.getYpos());
        aow.addGameObject(computer, computer.getXpos(), computer.getYpos());

        Timer timer = new Timer();
        TimerTask tasknew = new RandomNPCPicker(aow);

        timer.schedule(tasknew, 0, (randomCharacterSpawnTime * 100));

    }

    /**
     * Deze functie haalt de health van de towers op
     * Deze functie wordt geupdatet binnen de AgeOfWar class
     */
    public void towerTextTextSetter(){
        aow.NPCTowerText.setText("Health: " + computer.getHealth());
        aow.playerTowerText.setText("Health: " + user.getHealth());
    }
}
