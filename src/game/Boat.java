package game;

public class Boat {
    private int size;
    // Should be char for the type
    private char type;
    // Like C1 || B2 || P3  (Carrier #1, Battleship #2, Patrol-Boat #3
    private String id;
    private String name = new String();
    private boolean destroyed = false;
    private int[] position;
    private int[] hits;
    private boolean posSet = false;


    public Boat setBoat(int size, char type, String name, String id) {
        this.size = size;
        this.type = type;
        this.name = name;
        this.id = id;
        return this;
    }

    public char getType() {
        return this.type;
    }

    public boolean isSunk() {
        return this.destroyed;
    }

    public boolean hit(int position) {
        int sum = 0;
        boolean hit = false;
        for (int i = 0; i < this.hits.length; i++) {
            if (this.hits[i] == position) {
                this.hits[i] = 0;
                hit = true;
            }
            sum += this.hits[i];
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

    // align: 0 =vertical, 1= horizontal && position: the leftest point||topest point
    public int[] setPosition(int align, int position) {

        this.position = new int[this.size];
        this.hits = new int[this.size];

        for (int i = 0; i < this.size; i++) {
            this.position[i] = position + Math.max(i, (10 * align * i));
            this.hits[i] = this.position[i];
            System.out.println(this.position[i]);
        }
        this.posSet = true;
        return this.position;

    }

    public int[] getPosition() {

        return this.position;
    }

    public int getSize() {
        return this.size;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }


}
