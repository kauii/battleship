package game;
import java.util.Random;

public class Computer extends Player{
    public Computer(Board boardComputer){
    }

    public void attack() {
        Random r = new Random();
        char posX = (char)(r.nextInt(10) + 'A');
        int posY = r.nextInt(0, 10);
    }
}
