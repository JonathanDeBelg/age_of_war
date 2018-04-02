package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

import java.util.ArrayList;
import java.util.List;

public abstract class Character extends SpriteObject implements ICollidableWithGameObjects {
    private int cost, damage;
    private int x = 0;
    private int y = 255;
    private int size = 25;
    private Sprite sprite;
    private int direction;
    private ArrayList<Character> friends;
    private long prevMillis = 0;
    AgeOfWar aow;

    public Character(Sprite sprite, int direction) {
        super(sprite);
        this.sprite = sprite;
        this.direction = direction;
        setxSpeed(direction);
        friends = new ArrayList<Character>();
    }


    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject object : collidedGameObjects) {
            if (object instanceof Character) {
                Character c = (Character) object;
//                System.out.println(collidedGameObjects);
                if (!isFriend(c)) {
                    setxSpeed(0);
                    attack(c);
                }
            }

        }
    }

    public void addFriends(Character character) {
        friends.add(character);
    }

    private boolean isFriend(Character character) {
        return friends.contains(character);
    }

    @Override
    public void update() {
        if (getX() + getWidth() <= 0) {
            setX(1500);
            //commentaar
        }
    }

    public void attack(Character c) {
        long currentMillis = System.currentTimeMillis();

        if ((currentMillis - prevMillis) >= 2000) {
            doDamage(c);
            prevMillis = currentMillis;
        }
        if (getHealth() <= 0) {
            System.out.println("dood");
            die(c);

        }
    }

    public void die(Character c) {
        aow.deleteGameObject(c);
    }

    public abstract void doDamage(Character c);

    public abstract int getHealth();
}