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
    private ArrayList<Character> enemies;
    private long prevMillis = 0;
    AgeOfWar aow;

    public Character(Sprite sprite, int direction, AgeOfWar aow, int cost) {
        super(sprite);
        this.sprite = sprite;
        this.direction = direction;
        setxSpeed(direction);
        friends = new ArrayList<Character>();
        enemies = new ArrayList<Character>();
        this.aow = aow;
        this.cost = cost;
    }

    public int getCost () {
        return cost;
    }

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject object : collidedGameObjects) {
            if (object instanceof Character) {
                Character c = (Character) object;
                if ( (friends.size() > 0) ) {
                    if(!isFriend(c)) {
                        setxSpeed(0);
                        attack(c);
                    }

                    //attack(c);
                } else if(enemies.size() > 0) {
                    if(!isEnemy(c)) {
                        setxSpeed(0);
                        attack(c);
                    }
                }
            }
        }
    }

    public void addFriends(Character character) {
        friends.add(character);
    }

    public void addEnemy(Character character) {
        enemies.add(character);
    }

    private boolean isFriend(Character character) {
        return friends.contains(character);
    }

    private boolean isEnemy(Character character) {
        return enemies.contains(character);
    }

    @Override
    public void update() {
        if (getX() + getWidth() <= 0) {
            setX(1500);
            //commentaar
        }
        setxSpeed(direction);
    }

    public void attack(Character c) {
        long currentMillis = System.currentTimeMillis();

        if ((currentMillis - prevMillis) >= 2000) {
            doDamage(c);
            prevMillis = currentMillis;
        }
        if (c.getHealth() <= 0) {
            die(c);
        }
    }

    public void die(Character c) {
        returnMoneyOnDie();
        aow.deleteGameObject(c);
        friends.remove(c);
        System.out.println("Nieuwe saldo: " + aow.getSaldo());
    }

    public abstract void doDamage(Character c);

    public abstract int getHealth();

    public abstract void setHealth(int health);

    public abstract void returnMoneyOnDie();
}