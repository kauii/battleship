package game;

public class Boat {
    private int size;
    // Should be char for the type
    private char abbr;
    // Like C1 || B2 || P3  (Carrier #1, Battleship #2, Patrol-Boat #3
    private String name = new String();
    private boolean destroyed = false;
    private int position[];
    private boolean posSet = false;


    public Boat() {}
    
    public Boat setBoat(int size, char abbr, String name) {
        this.size = size;
        this.abbr = abbr;
        this.name = name;
        return this;
    }
    
    public boolean isSunk() {
        return this.destroyed;
    }
    public boolean hit(int position) {
        int sum = 0;
        boolean hit = false;
        for (int i = 0; i < this.position.length; i++) {
            if ( this.position[i] == position) {
                this.position[i] = 0;
                hit = true;
            }
            sum += this.position[i];
            //System.out.println(this.position[i]);
        }
        //System.out.println(sum);
        if (sum == 0) {
            this.destroyed = true;
        }
        return hit;
    }
    public Boat getBoat() {
        return this;
    }
    
    // align: 0 =horizontal, 1= vertical && position: the leftest point||topest point
    public int[] setPosition(int align, int position) throws Exception {
        if (this.posSet ==true) {
            throw new Exception("ship is allready placed");
        } else {
            this.position = new int[this.size];
            
            for (int i = 0; i < this.size; i++) {
                this.position[i] = position + Math.max(i,(10*align*i));
                System.out.println(this.position.length);
              }
            this.posSet = true;
            
            return this.position;
        }
    }
    
    
}
