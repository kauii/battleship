package game;

import java.lang.System;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws Exception {
        // generate board
        Board b = new Board().getBoard();
        // get access to the fleet
        Fleet f = new Fleet();



        // PLACE A SHIP! 1.var = align, 2.var= position on the grid! return value is Position array like [11,12,13,14] || 11=the leftest point||topest point
        int[] position = f.boats[0][0].setPosition(0,11);
        // to set the new grid after place a ship: 00 = Boat ->(0= carrier, 0=first ship), position= return value from boat
        b.setGrid("C0", position);
        //attack

        f.boats[0][0].hit(11);
        f.boats[0][0].hit(12);
        f.boats[0][0].hit(13);
        f.boats[0][0].hit(14);
        f.boats[0][0].hit(15);

        if (b.getGrid()[1][6] != null) {
            int pos[] = new int[] {16};
            b.setGrid("X",pos);
            f.boats[0][0].hit(16);

            // if a hit destroys a boat then mark it as sunk
            if (f.boats[0][0].isSunk()) {
                int[] p =  f.boats[0][0].getPosition();
                System.out.println("Test: "+ f.boats[0][0].getPosition()[0]);
                b.setGrid("xy",p);
            }
        } else {
            // missed attack
            int pos[] = new int[] {10};
            b.setGrid("O",pos);
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