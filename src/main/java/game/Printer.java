package game;

public class Printer {

    public void printGrid(String[][] grid) {
        char e;

        // print x-axis
        System.out.println("  A B C D E F G H I J ");
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+");

        // iterate through rows
        for (int i = 0; i <= 9; i++) {
            System.out.printf("%d|", i);
            // iterate through columns
            for (int j = 0; j <= 9; j++) {
                if (grid[i][j] == null) {
                    e = ' ';
                } else {
                    e = grid[i][j].charAt(0);
                }

                // print char + |
                System.out.printf("%c|", e);
            }
            System.out.printf("%d\n", i);
        }
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+");
        System.out.println("  A B C D E F G H I J ");

    }

    public void printBoard(Player user, int round) {

        // Clear screen / new round
        System.out.println("\n\n\n");
        System.out.println("======= Round " + round + " =======");
        System.out.println("===== Target Grid =====");
        System.out.println();

        // Display Target board
        System.out.println("===== TARGET GRID =====");
        String[][] tGrid = user.getTGrid();
        printGrid(tGrid);
        System.out.println("=======================");
        System.out.println();
        System.out.println("-----------------------");
        System.out.println();

        // Display User board
        System.out.println("===== OCEAN GRID =====");
        String[][] uGrid = user.getUGrid();
        printGrid(uGrid);
    }

    public void printGameOver(Player winner) {
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
            printGrid(uGrid);
            System.out.println("#######################");
        }
    }

}
