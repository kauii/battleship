package game;

import java.lang.System;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws Exception {
        // generate board
        Board b = new Board().getBoard();
        // get access to the fleet
        Fleet f = b.getFleet();
        // PLACE A SHIP! 1.var = align, 2.var= position on the grid! return value is Position array like [11,12,13,14]
        int[] position = f.boats[0][0].setPosition(0,11);
        // to set the new grid after place a ship: 00 = Boat ->(0= carrier, 0=first ship), position= return value from boat
        b.setGrid(String.valueOf("C0"), position);
        b.printGrid();
        if (b.getGrid()[1][2] != "null") {
            int pos[] = new int[] {12}; 
            b.setGrid("X",pos);
            System.out.println(pos[0] + String.valueOf(f.boats[0][0].hit(12)));
        }
        //f.boats[0][0].hit(12);
        //f.boats[0][0].hit(13);
        //f.boats[0][0].hit(14);
        //f.boats[0][0].hit(15);
        System.out.println(f.boats[0][0].isSunk());
        System.out.println(f.boats[0][0].hit(16));
        System.out.println(f.boats[0][0].isSunk());
        
    }
  }
