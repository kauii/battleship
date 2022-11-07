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
}
