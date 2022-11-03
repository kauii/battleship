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
        for (int i = 0; i < position.length; i++) {
            int x = position[i] / 10;
            int y = position[i] % 10;
            //System.out.println("test: "+x+y + type);
            grid[x][y] = id;
            //System.out.println(this.grid[x][y]);
        }
    }

}