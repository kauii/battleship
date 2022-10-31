package game;

public class Board {
    final private static int numRows = 10;
    final private static int numCols = 10;
    private static String[][] grid = new String[numRows][numCols];
    private Fleet fleet;

    public Board(){
        this.fleet = new Fleet();
    }
    public Board getBoard() {
        return this;
    }
    public Fleet getFleet() {
        return this.fleet.getFleet();
    }
    
    public String[][] getGrid() {
        return this.grid;
    }
    public String[][] setGrid(String type,int[] position) {
        for (int i = 0; i < position.length; i++) {
            int x = Integer.parseInt(String.valueOf(position[i]).substring(0,1));
            int y = Integer.parseInt(String.valueOf(position[i]).substring(1,2));
            //System.out.println("test: "+x+y + type);
            this.grid[x][y] = type;
            //System.out.println(this.grid[x][y]);
          }
        return this.grid;
    }
    
    public void printGrid(){
        //First section of Ocean Map
        System.out.print("  |  ");
        for(int i = 0; i < numCols; i++)
                System.out.print(i+"  |  ");
        System.out.println();

        //Middle section of Ocean Map
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //grid[i][j] = "| ";
                if (j == 0)
                    System.out.print(i + " |" + grid[i][j]+ " |" );
                else if (j == grid[i].length - 1)
                    System.out.print(grid[i][j] + "|" + i);
                else
                    System.out.print(grid[i][j]+"|");
            }
            System.out.println();
        }

        //Last section of Ocean Map
        System.out.print("  |");
        for(int i = 0; i < numCols; i++)
            System.out.print(i+"|");
        System.out.println();
    }
}
