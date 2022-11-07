package game;

import java.util.Random;


public class Computer extends Player {
    Random r = new Random();
    GridPrint printer = new GridPrint();

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

    public int[] calculateMove(int hitPos) {
        posX = hitPos % 10;
        posY = hitPos / 10;
        int[] nextMoves = {(hitPos - 1), (hitPos + 1), (hitPos - 10), (hitPos + 10)};

        if (posX == 9) {
            nextMoves = removeElement(nextMoves, 1);         // case y9
            if (posY == 0) {
                nextMoves = removeElement(nextMoves, 1);     // corner case 09
            }
            if (posY == 9) {
                nextMoves = removeElement(nextMoves, 2);    // corner case 99
            }
        }

        if (posX == 0) {
            nextMoves = removeElement(nextMoves, 0);       // case y0
            if (posY == 0) {
                nextMoves = removeElement(nextMoves, 1);   // corner case 00
            }
            if (posY == 9) {
                nextMoves = removeElement(nextMoves, 2);   // corner case 90
            }
        }

        if (posY == 0 && posX != 0 && posX != 9) {
            nextMoves = removeElement(nextMoves, 2);      // case 0x
        }
        if (posY == 9 && posX != 0 && posX != 9) {
            nextMoves = removeElement(nextMoves, 3);     // case 9x
        }
        return nextMoves;
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

    public static int[] removeElement(int[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }

        int[] anotherArray = new int[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }

            anotherArray[k++] = arr[i];
        }

        return anotherArray;
    }


}