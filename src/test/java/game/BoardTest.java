package game;

import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board board;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        board=new Board();
    }

    @org.junit.jupiter.api.Test
    void getBoard() {
        assert (board.getBoard()==board);
    }

    @org.junit.jupiter.api.Test
    void getGrid() {
        String[][] grid=new String[10][10];
        Assert.assertArrayEquals(grid, board.getGrid());
    }

    @org.junit.jupiter.api.Test
    void setGrid() {
        board.setGrid("A",new int[]{12,13});
        String [][] grid=new String[10][10];
        grid[1][2]="A";
        grid[1][3]="A";
        Assert.assertArrayEquals(grid, board.getGrid());
    }
}