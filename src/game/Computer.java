package game;
import java.util.Random;


public class Computer extends Player{
    public Board board;
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
                aBoardUser.setGrid(fleet.boats[i][j].getType(), position);
            }
        }

    }

    private boolean validatePos(int align, int pos, int size) {
        //check if out of board
        if (align == 1) {
            if (!(pos / 10 + size <= 9)) {
                return false;
            }
        }
        else {
            if (!(pos % 10 + size <= 9)) {
                return false;
            }
        }

        String[][] grid = aBoardUser.getGrid();

        //check collision
        for (int i = 0; i < size; i++) {

            if (align == 1) {
                if (!(grid[pos / 10 + i][pos % 10] == null)){
                    return false;}
            } else {
                if (!(grid[pos / 10][pos % 10 + i] == null)){
                    return false;}
            }
        }
        return true;
    }


    public void calculateMove() {
    }

}
