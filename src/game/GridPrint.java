package game;

public class GridPrint {

    public void printGrid(Board board){
        char e;

        String[][] grid=board.getGrid();

        // print x-axis
        System.out.println("  A B C D E F G H I J ");
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+");

        // iterate through rows
        for(int i=0;i<=9;i++){
            System.out.printf("%d|",i);
            // iterate through columns
            for(int j=0;j<=9;j++){
                if(grid[i][j]==null){
                    e=' ';
                }else{
                    e=grid[i][j].charAt(0);
                }

                // print char + |
                System.out.printf("%c|",e);
            }
            System.out.printf("%d\n",i);
        }
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+");
        System.out.println("  A B C D E F G H I J ");

    }

}
