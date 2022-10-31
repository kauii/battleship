package game;

public class Fleet {
    // Array shipAvbl [carrier, battleship, submarine, patrol-boat]
    public int[] shipsAvbl = new int[] {1,2,3,4};
    public Boat boats[][] = new Boat[4][4];
    
    //Init Fleet
    public Fleet() {
        // boats[0] = carrier & boats[1] = Battleships & boats[2] = Submarines & boats[3] = PatrolBoats
        this.boats[0][0] = new Boat().setBoat(6, 'C', "C1");
        this.boats[1][0] = new Boat().setBoat(4, 'B', "B1");
        this.boats[1][1] = new Boat().setBoat(4, 'B', "B2");
        this.boats[2][0] = new Boat().setBoat(3, 'S', "S1");
        this.boats[2][1] = new Boat().setBoat(3, 'S', "S2");
        this.boats[2][2] = new Boat().setBoat(3, 'S', "S3");
        this.boats[3][0] = new Boat().setBoat(2, 'P', "P1");
        this.boats[3][1] = new Boat().setBoat(2, 'P', "P2");
        this.boats[3][2] = new Boat().setBoat(2, 'P', "P3");
        this.boats[3][3] = new Boat().setBoat(2, 'P', "P4");
    }
    
    public Fleet getFleet() {
        return this;        
    } 
    
    public Fleet setFleet(Fleet fleet) {
        //this = fleet;
        return this;        
    }
}
