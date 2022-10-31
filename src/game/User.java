package game;
import java.util.Scanner;

public class User extends Player {
    public User(Board boardUser,Board boardTarget){
    }

    public void attack() {
        Scanner input = new Scanner(System.in);

        //input for x-coordinate (char A-J)
        System.out.println("It's your turn!\nChoose your x-coordinate (A-J):");
        String strPosX = input.next();
        while (strPosX.length() != 1 || !strPosX.matches("[a-jA-J]+")) {
            System.out.println("Invalid input.\nEnter only a single char from A-J:");
            strPosX = input.next();
        } char posX = Character.toUpperCase(strPosX.charAt(0));

        //input for y-coordinate (int 0-9)
        System.out.println("Choose your y-coordinate (0-9):");
        String strPosY = input.next();
        while (strPosY.length() != 1 || !strPosY.matches("[0-9]+")) {
            System.out.println("Invalid input.\nEnter only one number from 0-9:");
            strPosY = input.next();
        } int posY = Integer.parseInt(strPosY);
    }
}
