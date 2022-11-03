package game;

import java.util.Scanner;

public class User extends Player {
    Scanner input = new Scanner(System.in);
    GridPrint printer = new GridPrint();
    // User creates fleet

    public void initBoard() {
        int align;
        int pos;
        System.out.println("Deploy your ships!");

        int[] position;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                do {
                    System.out.println("Set your position for: " + fleet.boats[i][j].getName() + " | length: " + fleet.boats[i][j].getSize());
                    System.out.println("Insert 0 for horizontal / Insert 1 for vertical");
                    align = input.nextInt();
                    pos = inputPos();
                } while (!validatePos(align, pos, fleet.boats[i][j].getSize()));
                position = fleet.boats[i][j].setPosition(align, pos);
                ownBoard.setGrid(fleet.boats[i][j].getId(), position);
                String[][] grid = ownBoard.getGrid();
                printer.printGrid(grid);
            }
        }

    }

    @Override
    public int getAttackPos() {
        System.out.println("It's your turn.");
        return inputPos();
    }

    private int inputPos() {

        System.out.println("Choose your x-coordinate (A-J):");
        String strPosX = input.next();
        while (strPosX.length() != 1 || !strPosX.matches("[a-jA-J]+")) {
            System.out.println("Invalid input.\nEnter only a single char from A-J:");
            strPosX = input.next();
        }
        posX = Character.getNumericValue(strPosX.charAt(0)) - 10;

        //input for y-coordinate (int 0-9)
        System.out.println("Choose your y-coordinate (0-9):");
        String strPosY = input.next();
        while (strPosY.length() != 1 || !strPosY.matches("[0-9]+")) {
            System.out.println("Invalid input.\nEnter only one number from 0-9:");
            strPosY = input.next();
        }
        posY = Integer.parseInt(strPosY);

        return posX + posY * 10;
    }


    private boolean validatePos(int align, int pos, int size) {
        //check if out of board
        if (align == 1) {
            if (!(pos / 10 + size - 1 <= 9)) {
                System.out.println("Invalid input. Ship is outside of the grid.");
                return false;
            }
        } else {
            if (!(pos % 10 + size - 1 <= 9)) {
                System.out.println("Invalid input. Ship is outside of the grid.");
                return false;
            }
        }

        String[][] grid = ownBoard.getGrid();

        //check collision
        for (int i = 0; i < size; i++) {

            if (align == 1) {
                if (!(grid[pos / 10 + i][pos % 10] == null)) {
                    System.out.println("Invalid input. Another ship has already been placed on this position.");
                    return false;
                }
            } else {
                if (!(grid[pos / 10][pos % 10 + i] == null)) {
                    System.out.println("Invalid input. Another ship has already been placed on this position.");
                    return false;
                }
            }
        }
        return true;
    }


}