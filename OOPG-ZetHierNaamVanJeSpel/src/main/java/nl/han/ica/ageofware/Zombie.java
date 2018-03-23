package nl.han.ica.ageofware;

public class Zombie extends Character {



    public Zombie(AgeOfWar aow) {
        super(aow);
    }

    @Override
    public void update() {
        System.out.println("Doet iets");
    }

    @Override
    public void move() {
        System.out.println("Doet iets");
    }

    @Override
    public void attack() {
        System.out.println("Doet iets");
    }
}
