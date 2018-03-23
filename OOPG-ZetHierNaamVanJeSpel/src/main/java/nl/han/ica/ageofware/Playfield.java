package nl.han.ica.ageofware;

import java.util.ArrayList;

public class Playfield {
    AgeOfWar aow;

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

        Character zombie = new Zombie(aow);

        aow.addGameObject(user, user.getXpos(), user.getYpos());
        aow.addGameObject(computer, computer.getXpos(), computer.getYpos());
        aow.addGameObject(zombie, 255, 180);
    }
}
