package nl.han.ica.ageofware;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

import java.util.ArrayList;
import java.util.List;

public abstract class Character extends SpriteObject implements ICollidableWithGameObjects {
    private int cost, damage;
//    private int x = 20;
//    private int y = 255;
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
            if (object instanceof WalkingCharacters) {
                characterAttack(object);
            } else if(object instanceof Tower) {
                Tower t = (Tower) object;
                setxSpeed(0);
                attackTower(t);
            }
        }
    }

    private void characterAttack(GameObject object) {

        WalkingCharacters c = (WalkingCharacters) object;
        if(!isFriend(c)) {
            setxSpeed(0);
            attack(c);
            if (c.getHealth() <= 0) {
                c.returnMoneyOnDie();
            }
        }
    }


    public void addFriends(Character character) {
        friends.add(character);
    }

    private boolean isFriend(Character character) {
        if(friends.contains(character)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void update() {
        if (getX() + getWidth() <= 0) {
            setX(1500);
            die(this);
        }
        setxSpeed(direction);

        aow.refreshDasboardText();
    }

    private void attack(Character c) {
        long currentMillis = System.currentTimeMillis();
        WalkingCharacters o = (WalkingCharacters) c;
        if ((currentMillis - prevMillis) >= 2000) {
            doDamage(c);
            prevMillis = currentMillis;
        }
        if ( o.getHealth() <= 0) {
            die(c);
        }
    }

    private void attackTower(Tower t) {
        long currentMillis = System.currentTimeMillis();

        if ((currentMillis - prevMillis) >= 2000) {
            t.setHealth(40);
            prevMillis = currentMillis;
        }
        if (t.getHealth() <= 0) {
            aow.deleteGameObject(t);
            System.out.println("De tower is verslagen");
        }
    }


    private void die(Character c) {
        aow.deleteGameObject(c);
        friends.remove(c);
        System.out.println("Nieuwe saldo: " + aow.getSaldo());
    }

    private void walk() {
        setxSpeed(direction);
    }

    public abstract void doDamage(Character c);
}