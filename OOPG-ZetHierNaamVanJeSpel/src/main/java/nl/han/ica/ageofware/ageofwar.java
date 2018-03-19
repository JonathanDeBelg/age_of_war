package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;

public class ageofwar extends GameEngine {
    @Override
    public void setupGame() {
        int worldWidth=1204;
        int worldHeight=903;

        createViewWithoutViewport(worldWidth, worldHeight);
    }

    private void createViewWithoutViewport(int screenWidth, int screenHeight) {
        View view = new View(screenWidth,screenHeight);
        view.setBackground(loadImage("src/main/java/nl/han/ica/ageofwar/media/background-test.jpg"));

        setView(view);
        size(screenWidth, screenHeight);
    }

    @Override
    public void update() {

    }
}
