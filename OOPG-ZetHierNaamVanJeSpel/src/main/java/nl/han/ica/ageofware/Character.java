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
    private long prevMillis = 0;
    AgeOfWar aow;


    /**
     * Constructor
     * @param sprite De sprite van de Character
     * @param direction De richting van de Character
     * @param aow Het spel
     * @param cost De prijs van de Character
     */
    public Character(Sprite sprite, int direction, AgeOfWar aow, int cost) {
        super(sprite);
        this.sprite = sprite;
        this.direction = direction;
        setxSpeed(direction);
        friends = new ArrayList<Character>();
        this.aow = aow;
        this.cost = cost;
    }

    /**
     *  retouneert de prijs van een Character
     * @return De prijs van de Character
     */
    public int getCost () {
        return cost;
    }

    /**
     * zet de friends lijst naar de volledige lijst
     * wanneer een nieuwe character wordt aangemaakt
     * @param friends
     */
    public void setFriends(ArrayList<Character> friends) {
        this.friends = friends;
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

    /**
     * Controleer of de Character aangevallen kan worden
     * @param object de Character waar tegen de andere Character staat
     */
    private void characterAttack(GameObject object) {
        WalkingCharacters c = (WalkingCharacters) object;
        if(!isFriend(c)) {
            attack(c);
            if (c.getHealth() <= 0) {
                c.returnMoneyOnDie();
            }
        }
    }

    /**
     * Controleerd of de Character een friend is
     * @param character de Character
     * @return is de Character een friend, true / false
     */
    private boolean isFriend(Character character) {
        if(friends.contains(character)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Valt de meegegeven Character aan
     * @param c de Character welke aangevallen wordt
     */
    private void attack(Character c) {
        long currentMillis = System.currentTimeMillis();
        WalkingCharacters o = (WalkingCharacters) c;
        if ((currentMillis - prevMillis) >= 2000) {
            doDamage(o);
            prevMillis = currentMillis;
        }
        if ( o.getHealth() <= 0) {
            die(c);
        }
    }

    /**
     * Valt de meegegeven Tower aan
     * @param t de tower welke aangevallen wordt
     */
    private void attackTower(Tower t) {
        long currentMillis = System.currentTimeMillis();

        if ((currentMillis - prevMillis) >= 2000) {
            t.setHealth(40);
            prevMillis = currentMillis;
        }
        if (t.getHealth() <= 0) {
            aow.deleteGameObject(t);
            System.out.println("De tower is verslagen");
            aow.pause();
        }
    }

    /**
     * Verwijdert de meegegeven Character uit het spel
     * @param c de Character welke verwijdert moet worden
     */
    private void die(Character c) {
        aow.deleteGameObject(c);
        friends.remove(c);
        System.out.println("Nieuwe saldo: " + aow.getSaldo());
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

    /**
     * Past de damage toe aan de meegegeven Character
     * @param c de Character die aangevallen wordt
     */
    public abstract void doDamage(WalkingCharacters c);
}