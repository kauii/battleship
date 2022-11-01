package game;
import java.util.Scanner;

public class User extends Player {
    Scanner input = new Scanner(System.in);
    // User creates fleet

    public Board board;

  public void initBoard() throws Exception {
      int align;
      int pos;
      System.out.println("Deploy your ships!");
      int[] position;
      for (int i = 0; i < 4; i++) {
          for (int j = 0; j <= i; j++) {
              do {
                  System.out.println(fleet.boats[i][j].getType());
                  align = input.nextInt();
                  pos = inputPos();
              } while (!validatePos(align, pos,fleet.boats[i][j].getSize()));
              position = fleet.boats[i][j].setPosition(align,pos);
              aBoardUser.setGrid(fleet.boats[i][j].getType(), position);
          }
      }

  }

    public User(Board boardUser,Board boardTarget){
    	
    }

    @Override
    public void attack() {
    }

    public int inputPos() {

        System.out.println("Choose your x-coordinate (A-J):");
        String strPosX = input.next();
        while (strPosX.length() != 1 || !strPosX.matches("[a-jA-J]+")) {
            System.out.println("Invalid input.\nEnter only a single char from A-J:");
            strPosX = input.next();
        } posX = Character.toUpperCase(strPosX.charAt(0)) -65;

        //input for y-coordinate (int 0-9)
        System.out.println("Choose your y-coordinate (0-9):");
        String strPosY = input.next();
        while (strPosY.length() != 1 || !strPosY.matches("[0-9]+")) {
            System.out.println("Invalid input.\nEnter only one number from 0-9:");
            strPosY = input.next();
        } posY = Integer.parseInt(strPosY);

        return posX * 10 + posY;
    }


    @Override
    public void hasSunk(Boat boat){
        board.setGrid(boat.getType(),boat.getPosition());
    }

    private boolean validatePos(int align, int pos, int size) {
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
