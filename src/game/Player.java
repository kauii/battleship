package game;

import java.util.Objects;

public class Player {
    public Board ownBoard = new Board();
    public Board targetBoard = new Board();

    public Fleet fleet = new Fleet();

    int posX, posY;

    // set initial positions of boats on board
    public void initBoard() {
    }

    public void attack(Player opponent) {
        int target;
        // find attack coordinates
        do{
            target = getAttackPos();

        }while(!Objects.equals(this.getTGrid()[posY][posX], null ));

        // Opponent checks if hit
        boolean hit = opponent.checkAttack(target);
        int[] t = {target};

        // Adapt own target board
        if (hit) {
            System.out.println("It's a hit!");
            String destroyed = opponent.isDestroyed(target);
            // hit
            // check if enemy ship destroyed
            if (!Objects.equals(destroyed, "x")) {
                // destroyed
                // insert on own board type
                System.out.println("Ship is destroyed!!");
                int[] boatPos = opponent.getBoatPos(destroyed);
                targetBoard.setGrid(destroyed.substring(0, 1), boatPos);

            } else {
                targetBoard.setGrid("X", t);

            }
        } else {
            // no hit
            // insert O on target board
            System.out.println("It's a miss..");
            targetBoard.setGrid("O", t);
        }
        opponent.hitBoat(target);
    }

    public int getAttackPos() {
        // find target position
        // input validation: check if already hit
        return posX + posY * 10;

    }

    public boolean checkAttack(int pos) {
        // opponent board
        String[][] grid = ownBoard.getGrid();
        // check if hit
        // ownBoard[pos/10][pos%10] != null
        if (grid[pos / 10][pos % 10] == null) {
            return false;
        }

        String id = grid[pos / 10][pos % 10];

        // fleet.checkId -> boat
        Boat boat = this.fleet.checkId(id);
        boat.hit(pos);
        return true;
    }

    public void hitBoat(int pos){
        String[][] grid=ownBoard.getGrid();
        int[] p={pos};
        if (grid[pos / 10][pos % 10] == null) {
            ownBoard.setGrid("O",p);
        } else{
            ownBoard.setGrid("X",p);
        }
    }

    public String isDestroyed(int pos) {
        // OPPONENT
        String[][] grid = ownBoard.getGrid();
        String id = grid[pos / 10][pos % 10];
        System.out.println("id = " + id);

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