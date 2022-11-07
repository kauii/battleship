package game;

import java.util.Random;


public class Computer extends Player {
    Random r = new Random();
    Printer printer = new Printer();

    @Override
    public int getAttackPos() {
        return rndAttack();
    }

    public int rndAttack() {
        posX = r.nextInt(0,10);
        posY = r.nextInt(0, 10);
        return posX + posY * 10;
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
                    align = r.nextInt(0, 2);
                    pos = calculatePos(align, fleet.boats[i][j].getSize());
                } while (!validatePos(align, pos, fleet.boats[i][j].getSize()));
                position = fleet.boats[i][j].setPosition(align, pos);
                ownBoard.setGrid(fleet.boats[i][j].getId(), position);
                String[][] grid = ownBoard.getGrid();
            }
        }
        //printer.printGrid(ownBoard.getGrid()); //CHEAT

    }

    private int calculatePos(int align, int size) {
        if (align == 0) {
            posX = r.nextInt(0, 10);
            posY = r.nextInt(0, 11 - size);
        } else {
            posX = r.nextInt(0, 11 - size);
            posY = r.nextInt(0, 10);
        }
        return posX * 10 + posY;
    }

    private boolean validatePos(int align, int pos, int size) {
        //check if out of board
        if (align == 1) {
            if (!(pos / 10 + size <= 10)) {
                return false;
            }
        } else {
            if (!(pos % 10 + size <= 10)) {
                return false;
            }
        }

        String[][] grid = ownBoard.getGrid();

        //check collision
        for (int i = 0; i < size; i++) {

            if (align == 1) {
                if (!(grid[pos / 10 + i][pos % 10] == null)) {
                    return false;
                }
            } else {
                if (!(grid[pos / 10][pos % 10 + i] == null)) {
                    return false;
                }
            }
        }
        return true;
    }

}