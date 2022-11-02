package game;

public class Player {
    public Fleet fleet = new Fleet();
    public Board aBoardUser;
    public Board aBoardComp;

    int posX, posY;
    // set initial positions of boats on board
    public void initBoard() throws Exception {
    }

    public void attack(){
    }

    public void checkAttack(){


    }
    public void hasSunk(Boat boat){
        //boat.getPosition();
        //boat.getType();
        //board.setGrid(boat.getType(),boat.getPosition());

    }

    public boolean hasHit(){
        return true;
    }


    public boolean validatePos(int align, int pos, int size) {
        //check if out of board
        if (align == 1) {
            if (!(pos / 10 + size <= 9)) {
                return false;
            }
        }
        else {
            if (!(pos % 10 + size <= 9)) {
                return false;
            }
        }

        String[][] grid = aBoardUser.getGrid();

        //check collision
        for (int i = 0; i < size; i++) {

            if (align == 1) {
                if (!(grid[pos / 10 + i][pos % 10] == null)){
                    return false;}
            } else {
                if (!(grid[pos / 10][pos % 10 + i] == null)){
                    return false;}
            }
        }
        return true;
    }

}
