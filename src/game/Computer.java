package game;

import java.util.Objects;
import java.util.Random;


public class Computer extends Player {
    Random r = new Random();
    GridPrint printer = new GridPrint();
    boolean hit = false;
    int lastAttack = -1;
    int nextAttack;

    @Override
    public int getAttackPos() {
        return rndAttack();
    }
    public int AIgetAttackPos() {

        if (lastAttack == -1) {         // first attack
            int randomPos = rndAttack();
            lastAttack = randomPos;
            return randomPos;
        }

        if (checkAttack(lastAttack)) { // check if last attack was a hit
            hit = true;
        }

        if (hit) {
            int[] nextMoves = calculateMove(lastAttack);  // returns all possible moves from the hit position
            int rnd = r.nextInt(nextMoves.length);
            int nextMove = nextMoves[rnd - 1]; // picks random nextMove from nextMoves array
            nextMoves =  removeElement(nextMoves, rnd); // removes picked random move from list

            if (checkAttack(nextMove)) { // check if the next calculated attack would be a hit.
                if (Math.abs(lastAttack - nextAttack) == 1) { // ship is horizontal, --> next moves are +- 1
                    return 0; //TODO
                } else {  //ship is vertical, --> next moves are +-10
                    return 1; //TODO
                }
            }

            // else next "nextMove" from nextMoves array

            return nextAttack;
        }

        // else pick random attackPos
        int randomPos = rndAttack();
        lastAttack = randomPos;
        return randomPos;
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
        printer.printGrid(ownBoard.getGrid()); //CHEAT

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