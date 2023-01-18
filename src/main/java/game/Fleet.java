package game;

public class Fleet {
    public Boat[][] boats = new Boat[4][4];

    //Init Fleet
    public Fleet() {
        // boats[0] = carrier & boats[1] = Battleships & boats[2] = Submarines & boats[3] = PatrolBoats
        this.boats[0][0] = new Boat().setBoat(6, "Carrier", "C1");
        this.boats[1][0] = new Boat().setBoat(4, "Battleship (1)", "B1");
        this.boats[1][1] = new Boat().setBoat(4, "Battleship (2)", "B2");
        this.boats[2][0] = new Boat().setBoat(3, "Submarine (1)", "S1");
        this.boats[2][1] = new Boat().setBoat(3, "Submarine (2)", "S2");
        this.boats[2][2] = new Boat().setBoat(3, "Submarine (3)", "S3");
        this.boats[3][0] = new Boat().setBoat(2, "Patrol Boat (1)", "P1");
        this.boats[3][1] = new Boat().setBoat(2, "Patrol Boat (2)", "P2");
        this.boats[3][2] = new Boat().setBoat(2, "Patrol Boat (3)", "P3");
        this.boats[3][3] = new Boat().setBoat(2, "Patrol Boat (4)", "P4");
    }

    public Boat checkId(String id) {
        char c = id.charAt(0);
        char d = id.charAt(1);
        int i;
        int j = d - 48;
        i = switch (c) {
            case 'C' -> 0;
            case 'B' -> 1;
            case 'S' -> 2;
            default -> 3;
        };
        return this.boats[i][j - 1];
    }

    public boolean isEmpty() {
        boolean fin = false;
        int ships = 0;
        for (int i = 0; i < this.boats.length; i++) {
            for (int j = 0; j <=i ; j++) {
                if (!this.boats[i][j].isSunk()) {
                    ships += 1;
                }
            }
        }
        if (ships == 0) {
            fin = true;
        }
        return fin;
    }

}