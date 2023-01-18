package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FleetTest {
    Fleet fleet = new Fleet();

    @Test
    void checkIDTest() {
        Assertions.assertEquals(fleet.checkId("C1").getClass(), Boat.class);
        Assertions.assertEquals(fleet.checkId("B1").getClass(), Boat.class);
        Assertions.assertEquals(fleet.checkId("S3").getClass(), Boat.class);
        Assertions.assertEquals(fleet.checkId("P3").getClass(), Boat.class);
    }

    @Test
    void checkEmpty() {
        assert (!fleet.isEmpty());
        fleet.boats[0][0].setBoat(1, "Carrier", "C1");
        fleet.boats[1][0].setBoat(1, "Battleship (1)", "B1");
        fleet.boats[1][1].setBoat(1, "Battleship (2)", "B2");
        fleet.boats[2][0].setBoat(1, "Submarine (1)", "S1");
        fleet.boats[2][1].setBoat(1, "Submarine (2)", "S2");
        fleet.boats[2][2].setBoat(1, "Submarine (3)", "S3");
        fleet.boats[3][0].setBoat(1, "Patrol Boat (1)", "P1");
        fleet.boats[3][1].setBoat(1, "Patrol Boat (2)", "P2");
        fleet.boats[3][2].setBoat(1, "Patrol Boat (3)", "P3");
        fleet.boats[3][3].setBoat(1, "Patrol Boat (4)", "P4");

        fleet.boats[0][0].setPosition(1, 1);
        fleet.boats[1][0].setPosition(1, 2);
        fleet.boats[1][1].setPosition(1, 3);
        fleet.boats[2][0].setPosition(1, 4);
        fleet.boats[2][1].setPosition(1, 5);
        fleet.boats[2][2].setPosition(1, 6);
        fleet.boats[3][0].setPosition(1, 7);
        fleet.boats[3][1].setPosition(1, 8);
        fleet.boats[3][2].setPosition(1, 9);
        fleet.boats[3][3].setPosition(1, 11);


        fleet.boats[0][0].hit(1);
        fleet.boats[1][0].hit(2);
        fleet.boats[1][1].hit(3);
        fleet.boats[2][0].hit(4);
        fleet.boats[2][1].hit(5);
        fleet.boats[2][2].hit(6);
        fleet.boats[3][0].hit(7);
        fleet.boats[3][1].hit(8);
        fleet.boats[3][2].hit(9);
        fleet.boats[3][3].hit(11);
        assert (fleet.isEmpty());

    }
}
