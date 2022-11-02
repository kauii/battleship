package game;

import java.util.Objects;

public class Player {
    Board ownBoard = new Board();
    Board targetBoard = new Board();


    public Fleet fleet = new Fleet();

    int posX, posY;

    // set initial positions of boats on board
    public void initBoard() {
    }

    public void attack(Player opponent) {
        // find attack coordinates
        int target = this.uAttack();
        // Opponent checks if hit
        boolean hit = opponent.checkAttack(target);
        int[] t = {target};

        // Adapt own target board
        if (hit) {
            String destroyed = opponent.isDestroyed(target);
            // hit
            // check if enemy ship destroyed
            if (!Objects.equals(destroyed, "x")) {
                // destroyed
                // insert on own board type
                int[] boatPos = opponent.getBoatPos(destroyed);
                targetBoard.setGrid(destroyed.substring(0, 1), boatPos);

            } else {
                targetBoard.setGrid("X", t);

            }
        } else {
            // no hit
            // insert O on target board
            targetBoard.setGrid("O", t);
        }


    }

    public int uAttack() {
        // find target position
        // input validation: check if already hit
        return 12;

    }

    public boolean checkAttack(int pos) {
        // opponent board
        String[][] grid = ownBoard.getGrid();
        int[] p = {pos};
        // check if hit
        // ownBoard[pos/10][pos%10] != null
        if (grid[pos / 10][pos % 10] == null) {
            ownBoard.setGrid("O", p);
            return false;
        }

        // if hit:
        //      boat.hit(); -> boat saves hit
        //      boat.isSunk();
        //      save to own grid
        //      return true
        // else: insert O on own board
        //      return false
        String id = grid[pos / 10][pos % 10];

        // fleet.checkId -> boat
        Boat boat = this.fleet.checkId(id);
        boat.hit(pos);

        // adapt own board
        ownBoard.setGrid("X", p);


        return true;
    }

    public String isDestroyed(int pos) {
        // OPPONENT
        String[][] grid = ownBoard.getGrid();
        String id = grid[pos / 10][pos % 10];

        // fleet.checkId -> boat
        Boat boat = this.fleet.checkId(id);
        // return boat.isSunk()
        if (boat.isSunk()) {
            return id;
        }
        return "x";
    }

    public int[] getBoatPos(String id) {
        Boat boat = this.fleet.checkId(id);
        return boat.getPosition();
    }


    public String[][] getTGrid() {
        return targetBoard.getGrid();
    }

    public String[][] getUGrid() {
        return ownBoard.getGrid();
    }


}
