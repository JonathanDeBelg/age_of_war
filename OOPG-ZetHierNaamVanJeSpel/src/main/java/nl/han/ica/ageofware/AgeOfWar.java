package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.FilePersistence;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import nl.han.ica.OOPDProcessingEngineHAN.UserInput.IKeyInput;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.waterworld.TextObject;
import processing.core.PApplet;

/*
* @author Jonathan Vandionant & Nick Braks
* */

public class AgeOfWar extends GameEngine {

    Playfield p = new Playfield(this);
    private TextObject dashboardText;
    private Sound gameSound;
    private int saldo;
    Dashboard towerHealthPlayer = new Dashboard(40, 800, 500, 1);
    Dashboard towerHealthNPC = new Dashboard(40, 300, 500, 1);
    TextObject playerTowerHealth;
    TextObject NPCTowerHealth;


    public static void main(String[] args){
        PApplet.main(new String[]{"nl.han.ica.ageofware.AgeOfWar"});
    }

    /**
     * In deze methode worden de voor het spel
     * noodzakelijke zaken geïnitialiseerd
     */
    @Override
    public void setupGame() {
        int worldWidth=1500;
        int worldHeight=750;
        saldo = 500;

        createDashboard(worldWidth,100);
        createViewWithoutViewport(worldWidth, worldHeight);
        initializeSound();
        p.towerPlayerHealthGenerator(worldWidth, 300);
        p.towerNPCHealthGenerator(worldWidth, 100);
    }

    /**
    * @return retourneert saldo van de player
    * */
    public int getSaldo() {
        return saldo;
    }

    /**
    * zet het saldo op de juiste saldo
    * @param newSaldo het saldo van de speler die erbij komt of eraf gaat
    * @param state of het saldo erbij komt of van het oude saldo af gaat
    *
    * */
    public void setSaldo(int newSaldo, boolean state) {
        if(state){
            saldo += newSaldo;
        } else {
            saldo -= newSaldo;
        }
    }

    /**
     * Initialiseert geluid
     */
    private void initializeSound() {
        gameSound = new Sound(this, "src/main/java/nl/han/ica/ageofware/media/background-music.mp3");
        gameSound.loop(-1);
    }

    /**
     * Creeërt de view zonder viewport
     * @param screenWidth Breedte van het scherm
     * @param screenHeight Hoogte van het scherm
     */
    private void createViewWithoutViewport(int screenWidth, int screenHeight) {
        View view = new View(screenWidth,screenHeight);
        view.setBackground(loadImage("src/main/java/nl/han/ica/ageofware/media/game_background.png"));

        setView(view);
        size(screenWidth, screenHeight);
        p.createObjects();
    }

    /**
     * Maakt het dashboard aan
     * @param dashboardWidth Gewenste breedte van dashboard
     * @param dashboardHeight Gewenste hoogte van dashboard
     */
    private void createDashboard(int dashboardWidth,int dashboardHeight) {
        Dashboard dashboard = new Dashboard(10,10, dashboardWidth, dashboardHeight);
        dashboardText=new TextObject("");
        dashboard.addGameObject(dashboardText);
        addDashboard(dashboard);
    }

    /**
     * Vernieuwt het dashboard
     */
    public void refreshDasboardText() {
        dashboardText.setText("Saldo: " + getSaldo());
    }

    public void refreshTowerText(){
        p.towerTextTextSetter();
    }

    @Override
    public void update() {
    }


}
