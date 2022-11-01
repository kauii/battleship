package game;
import java.util.Random;


public class Computer extends Player{
    public Board board;

    public Computer(Board pBoardUser, Board pBoardComputer){
        aBoardComp = pBoardComputer;
        aBoardUser = pBoardUser;
    }

    @Override
    public void attack() {
        rndAttack();

    }



    public void rndAttack() {
        Random r = new Random();
        char posX = (char)(r.nextInt(10) + 'A');
        int posY = r.nextInt(0, 10);
    }

    public void calculateMove() {
    }

}
