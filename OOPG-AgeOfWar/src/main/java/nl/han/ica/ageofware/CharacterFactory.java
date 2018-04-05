package nl.han.ica.ageofware;

import java.util.ArrayList;

public interface CharacterFactory {

    /**
     * Voegt een Character toe
     * @param c Character die toegevoegd moet worden
     */
    public void addCharacter(Character c);

    /**
     * @param characters de lijst van Characters
     * @param character de character die toegevoegd moet worden aan de lijst
     */
    public void addCharacterToList(ArrayList<Character> characters, Character character);
}

