package game;
import java.util.Random;


public class Computer extends Player{
    Random r = new Random();

    public Computer(Board pBoardUser, Board pBoardComputer){
        aBoardComp = pBoardComputer;
        aBoardUser = pBoardUser;
    }

    @Override
    public void attack() {
        rndAttack();
    }

    public void rndAttack() {
        char posX = (char)(r.nextInt(10) + 'A');
        int posY = r.nextInt(0, 10);
    }

    @Override
    public void initBoard() throws Exception {
        int align;
        int pos;
        int[] position;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                do {
                    System.out.println(fleet.boats[i][j].getType());
                    align = r.nextInt(0,1);
                    pos = r.nextInt(0,99);
                } while (!validatePos(align, pos,fleet.boats[i][j].getSize()));
                position = fleet.boats[i][j].setPosition(align,pos);
                aBoardComp.setGrid(fleet.boats[i][j].getType(), position);
            }
        }

    }

    public void calculateMove() {
    }

}
