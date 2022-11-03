import game.*;

import java.util.Random;

public class Game {

    // Prototype Player
    Player player1;
    Player player2;
    Player user;
    Player computer;

    // Create printer
    GridPrint printer = new GridPrint();

    public Game() {
        int round = 1;

        System.out.println("Starting new game...");

        // create board & players
        setupGame();

        // set initial boat positions
        player1.initBoard();
        player2.initBoard();

        System.out.println("Choosing a random starting player...");
        if (user == player1) {
            System.out.println("You start!");
        } else {
            System.out.println("The computer starts.");
        }



        // Game loop
        do {
            fight(round);
            round++;
        } while (!player1.fleet.isEmpty() && !player2.fleet.isEmpty());

        // Game Over
        gameOver();


    }

    private void setupGame() {
        // set user as either player 1 or 2
        // create random boolean
        Random rand = new Random();
        final boolean r = rand.nextBoolean();

        if (r) {
            // if True: Player1 -> User; Player2 -> Computer
            player1 = new User();
            user = player1;
            player2 = new Computer();
        } else {
            // else: Player1 -> Computer; Player2 -> User
            player1 = new Computer();
            player2 = new User();
            user = player2;
        }

    }

    private void fight(int round) {
        player1.attack(player2);
        player2.attack(player1);

        // print Game board
        printBoard(round);

    }

    private void printBoard(int round) {

        // Clear screen / new round
        System.out.println("\n\n\n");
        System.out.println("============ Round " + round + " ============");
        System.out.println();

        // Display Target board
        System.out.println("====== Target Board ======");
        String[][] tGrid = user.getTGrid();
        printer.printGrid(tGrid);
        System.out.println();

        // Display User board
        System.out.println("====== User Board ======");
        String[][] uGrid = user.getUGrid();
        printer.printGrid(uGrid);

    }


    private void gameOver() {
        Player winner;
        if (player1.fleet.isEmpty()) {
            winner = player2;
        } else {
            winner = player1;
        }

        // Game Over screen
        System.out.println("#######################");
        System.out.println("#######################");

        // Winner message
        if (winner instanceof User) {
            System.out.println("###### You won!! ######");
            System.out.println("#######################");
        } else {
            System.out.println("###### You lost. ######");
            System.out.println("#######################");
        }
        System.out.println("#######################");
        System.out.println("#######################");
        System.out.println("# Thanks for playing! #");
        System.out.println("#######################");

        // Show opponent board if lost
        if(winner instanceof Computer){
            String[][] uGrid=winner.getUGrid();
            System.out.println();
            System.out.println("#### Opponent Board ###");
            printer.printGrid(uGrid);
            System.out.println("#######################");
        }

    }


}