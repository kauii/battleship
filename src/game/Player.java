package game;

public class Player {
    public Fleet fleet = new Fleet();
    public Board aBoardUser = new Board();
    public Board aBoardComp = new Board();

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


    public void validateMove(char x, int y) {

    }

}
