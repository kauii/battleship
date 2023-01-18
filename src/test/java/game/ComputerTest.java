package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    Computer comp;

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
            assert (apo < max && apo > min);
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
}
