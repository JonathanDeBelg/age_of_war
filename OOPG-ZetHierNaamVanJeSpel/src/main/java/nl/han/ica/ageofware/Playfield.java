package nl.han.ica.ageofware;

public class Playfield {
    AgeOfWar aow;
    public Playfield(AgeOfWar aow) {
        this.aow = aow;
    }

    /**
     * Maakt de spelobjecten aan
     */
    public void createObjects() {
        Tower speler = new Tower(aow, 0, aow.height - 255);
        Tower computer = new Tower(aow, aow.width-100, aow.height - 255);
        aow.addGameObject(speler, speler.getXpos(), speler.getYpos());
        aow.addGameObject(computer, computer.getXpos(), computer.getYpos());
    }
}
