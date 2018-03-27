package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

public class CharacterFactory extends GameObject{


//    PlayerPicker pickPlayer = new PlayerPicker();
    AgeOfWar aow;

    public CharacterFactory() {
        aow.addGameObject(new PlayerPicker());
    }


    @Override
    public void update() {

    }

    @Override
    public void draw(PGraphics g) {

    }
}
