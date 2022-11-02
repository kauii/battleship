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

    public void printGrid() {
        //First section of Ocean Map
        System.out.print(" ");
        for (int i = 0; i < numCols; i++)
            System.out.print(" " + (char) (i + 65));
        System.out.println();
        System.out.print(" +-+-+-+-+-+-+-+-+-+-+");
        System.out.println();

        //Middle section of Ocean Map
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //grid[i][j] = "| ";
                if (j == 0)
                    if (grid[i][j] == null)
                        System.out.print(i + "| |");
                    else
                        System.out.print(i + "|" + grid[i][j] + "|");
                else if (j == grid[i].length - 1)
                    if (grid[i][j] == null)
                        System.out.print(" |" + i);
                    else
                        System.out.print(grid[i][j] + "|" + i);
                else if (grid[i][j] == null)
                    System.out.print(" |");
                else
                    System.out.print(grid[i][j] + "|");
            }
            System.out.println();
        }

        //Last section of Ocean Map
        System.out.print(" +-+-+-+-+-+-+-+-+-+-+");
        System.out.println();
        System.out.print(" ");
        for (int i = 0; i < numCols; i++)
            System.out.print(" " + (char) (i + 65));
        System.out.println();
    }
}
