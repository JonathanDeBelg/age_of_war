package nl.han.ica.ageofware;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class RandomNPCPicker extends TimerTask{

    public void run() {
        System.out.println("Random tekst");
        generateRandomNPC();
    }

    public Character generateRandomNPC(){
        Random rand = new Random();
        int randomCharacter = rand.nextInt(2) + 1;

        Character character;

        if (randomCharacter == 1) {
            character = new Zombie();

        } else {
            return character = new Zombie();
        }

//        else if (randomCharacter == 2){
////            return Ninja;
//            System.out.println("NINJA!!");
//        }


        return character;
    }
}
