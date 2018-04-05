package nl.han.ica.ageofware;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Playfield extends Timer{
    AgeOfWar aow;
    CharacterFactory randomPicker;
    private int timerMin = 70;
    private int timerMax = 80;

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
