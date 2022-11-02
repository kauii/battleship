package game;
import java.util.Random;


public class Computer extends Player{
    Random r = new Random();
    Board aBoardComp;

    public Computer(Board pBoardComputer){
        aBoardComp = pBoardComputer;
    }

    @Override
    public int uAttack() {
        rndAttack();
        return 1;
    }

    public void rndAttack() {
        char posX = (char)(r.nextInt(10) + 'A');
        int posY = r.nextInt(0, 10);
    }

    @Override
    public void initBoard() {
        System.out.println("Computer is deploying ships..");
        int align;
        int pos;
        int[] position;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                do {
                    System.out.println(fleet.boats[i][j].getType());
                    align = r.nextInt(0,2);
                    System.out.println("align is: " + align); // TODO:remove later for Computer
                    pos = calculatePos(align, fleet.boats[i][j].getSize());
                } while (!validatePos(align, pos,fleet.boats[i][j].getSize()));
                position = fleet.boats[i][j].setPosition(align,pos);
                aBoardComp.setGrid(fleet.boats[i][j].getId(), position);
                aBoardComp.printGrid(); //TODO: remove later for Computer
            }
        }

    }

    private int calculatePos(int align, int size ) {
        if (align == 0) {
            posX = r.nextInt(0,10);
            posY = r.nextInt(0, 11- size);
        } else {
            posX = r.nextInt(0,11 - size);
            posY = r.nextInt(0,10);
        }
        System.out.println(posX + "," + posY); //TODO:remove later for Computer
        return posX * 10 + posY;
    }

    public void calculateMove() {
    }

    private boolean validatePos(int align, int pos, int size) {
        //check if out of board
        if (align == 1) {
            if (!(pos / 10 + size <= 10)) {
                System.out.println("Invalid input. Ship is outside of the grid.");   // TODO:remove later for Computer
                return false;
            }
        }
        else {
            if (!(pos % 10 + size <= 10)) {
                System.out.println("Invalid input. Ship is outside of the grid."); // TODO:remove later for Computer
                return false;
            }
        }

        String[][] grid = aBoardComp.getGrid();

        //check collision
        for (int i = 0; i < size; i++) {

            if (align == 1) {
                if (!(grid[pos / 10 + i][pos % 10] == null)){
                    System.out.println("Invalid input. Another ship has already been placed on this position."); // TODO:remove later for Computer
                    return false;}
            } else {
                if (!(grid[pos / 10][pos % 10 + i] == null)){
                    System.out.println("Invalid input. Another ship has already been placed on this position."); // TODO:remove later for Computer
                    return false;}
            }
        }
        return true;
    }

}
