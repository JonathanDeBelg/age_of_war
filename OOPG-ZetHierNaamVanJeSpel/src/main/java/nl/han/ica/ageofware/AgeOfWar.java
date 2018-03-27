package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.UserInput.IKeyInput;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import processing.core.PApplet;

public class AgeOfWar extends GameEngine {

    Playfield p = new Playfield(this);

    public static void main(String[] args){
        PApplet.main(new String[]{"nl.han.ica.ageofware.AgeOfWar"});
    }

    @Override
    public void setupGame() {
        int worldWidth=1500;
        int worldHeight=750;

        createViewWithoutViewport(worldWidth, worldHeight);
    }

    private void createViewWithoutViewport(int screenWidth, int screenHeight) {
        View view = new View(screenWidth,screenHeight);
        view.setBackground(loadImage("src/main/java/nl/han/ica/ageofware/media/game_background.png"));

        setView(view);
        size(screenWidth, screenHeight);
        p.createObjects();
        p.generateCharacter();
    }

    @Override
    public void update() {
    }
}
