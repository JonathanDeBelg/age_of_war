package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.UserInput.IMouseInput;
import nl.han.ica.waterworld.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Character extends SpriteObject implements ICollidableWithGameObjects{
    private int cost, damage;
    private int x = 0;
    private int y = 255;
    private int size = 25;
    private Sprite sprite;
    private int direction;
    private List<Character> friends;

    public Character(Sprite sprite, int direction){
        super(sprite);
        this.sprite = sprite;
        this.direction = direction;
        this.friends = new ArrayList<>();
        setxSpeed(direction);
    }

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject object: collidedGameObjects) {
            if(object instanceof Character) {
                Character chararacter = (Character) object;
                setxSpeed(0);
                if(!isFriend(chararacter)){
                    //attack();
                }

            }

        }
    }

    public void addFriends(Character character){
        this.friends.add(character);
    }

    private boolean isFriend(Character character){
        return this.friends.contains(character);
    }

    @Override
    public void update() {
        if (getX() + getWidth() <= 0) {
            setX(1500);
            //commentaar
        }
    }
}
