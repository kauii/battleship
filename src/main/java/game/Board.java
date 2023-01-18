package game;

public class Board {
    final private static int numRows = 10;
    final private static int numCols = 10;
    public String[][] grid = new String[numRows][numCols];

    public Board getBoard() {
        return this;
    }

    public String[][] getGrid() {
        return grid;
    }

    public void setGrid(String id, int[] position) {
        for (int j : position) {
            int x = j / 10;
            int y = j % 10;
            //System.out.println("test: "+x+y + type);
            grid[x][y] = id;
            //System.out.println(this.grid[x][y]);
        }
    }

}