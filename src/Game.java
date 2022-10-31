import game.Board;
import game.Computer;
import game.Player;
import game.User;

import java.util.Random;

public class Game {

    // Prototype Player
    Player player1;
    Player player2;
    // Prototype Boards
    Board boardUser;
    Board boardComp;
    Board boardTarget;

    public Game() {

        System.out.println("Starting new game...");

        // create board & players
        setupGame();

        // set initial boat positions
        player1.initBoard();
        player2.initBoard();

        // Gameloop
        do {
            fight();
        } while (player1.fleet.isEmpty() && player2.fleet.isEmpty()); // TODO: Check whether fleet of one player is destroyed.

        // Game Over
        gameOver();


    }

    private void setupGame() {
        // create board
        boardUser = new Board();
        boardComp = new Board();
        boardTarget = new Board();

        // set user as either player 1 or 2
        // create random boolean
        Random rand = new Random();
        final boolean r = rand.nextBoolean();

        if (r) {
            // if True: Player1 -> User; Player2 -> Computer
            player1 = new User(boardUser, boardTarget);
            player2 = new Computer(boardComp);
        } else {
            // else: Player1 -> Computer; Player2 -> User
            player1 = new Computer(boardComp);
            player2 = new User(boardUser, boardTarget);
        }

    }

    private void fight() {
// hasHit(boolean true/false) checkAttack(int position) attack()
        int i = player1.attack();
        int j = player2.attack();
        int x = player2.checkAttack(i);
        if (x>0){
            player1.hasHit(true);
            if (player2.fleet.boats[x.substring(0,1)][x.substring(1,2)].isSunk()) {
                player1.hassunk(player2.fleet.boats[x.substring(0,1)][x.substring(1,2)].getBoat());
            }
        }

        player2.hasHit(player1.checkAttack(player2.attack()));


        // print Gameboard
        //printBoard();

    }

    private void gameOver(){
        Player winner;
        if(player1.fleet.isEmpty()){    // TODO: Check if fleet of player1 is destroyed
            winner=player2;
        }else {
            winner=player1;
        }

        // Game Over screen
        System.out.println("################################################");
        System.out.println("################################################");

        // Winner message
        if(winner instanceof User){
            System.out.println("#############      You won!        #############");
        } else {
            System.out.println("#############      You lost!       #############");
        }
        System.out.println("################################################");
        System.out.println("################################################");
        System.out.println("#############  Thanks for playing  #############");
        System.out.println("################################################");

    }


}
