package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {

    Computer comp;
    Computer player1;
    Computer player2;

    @BeforeEach
    void SetUp() {
        comp = new Computer();
    }

    @Test
    void getAttackPos() {
        int max = 99;
        int min = 0;
        int i = 0;
        int apo;

        while (i < 10) {
            apo = comp.getAttackPos();
            assert (apo <= max && apo >= min);
            i++;
        }
    }

    @Test
    void initBoard() {
        comp.initBoard();

        // Ship counter
        int c = 0;
        int b = 0;
        int s = 0;
        int p = 0;

        String[][] grid = comp.getUGrid();

        // Iterate through grid
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                try {
                    switch (grid[i][j].charAt(0)) {
                        case 'C' -> c++;
                        case 'B' -> b++;
                        case 'S' -> s++;
                        case 'P' -> p++;
                        default -> {
                        }
                    }
                } catch (Exception ignored) {
                }
            }
        }

        assert (c == 6);
        assert (b == 8);
        assert (s == 9);
        assert (p == 8);
    }

    @Test
    void attack() {
        Player opponent = new Player();
        comp.attack(opponent);

        // Check if one position is hit on target board
        assert (checkGridHit(comp.getTGrid()));

        // Check if one position is hit on opponent board
        assert (checkGridHit(opponent.getUGrid()));
    }

    private boolean checkGridHit(String[][] grid) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                try {
                    if (grid[i][j].charAt(0) == 'O' || grid[i][j].charAt(0) == 'X') {
                        return true;
                    }
                } catch (Exception ignored) {
                }
            }
        }
        return false;
    }

    @Test
    void gameLoop() {
        player1 = new Computer();
        player2 = new Computer();

        // set initial boat positions
        player1.initBoard();
        player2.initBoard();

        // Game loop
        do {
            player1.attack(player2);
            player2.attack(player1);
        } while (!player1.fleet.isEmpty() && !player2.fleet.isEmpty());

        assert (player1.fleet.isEmpty() || player2.fleet.isEmpty());

    }
}
