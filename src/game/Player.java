package game;

public class Player {
    public Fleet fleet = new Fleet();
    // set initial positions of boats on board
    public void initBoard(){

    }

    public void attack(){


    }

    public void checkAttack(){


    }
    public void hasSunk(Boat boat){
        boat.getPosition();
        boat.getType();
        board.setGrid(boat.getType(),boat.getPosition());

    }


    public void validateMove(char x, int y) {

    }

}
