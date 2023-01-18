package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoatTest {

    Boat boat = new Boat();

    @Test
    void checksetBoat() {
        Boat tempBoat = boat.setBoat(3, "name", "id");

        Assertions.assertEquals(tempBoat.getSize(), 3);
        Assertions.assertEquals(tempBoat.getName(), "name");
        Assertions.assertEquals(tempBoat.getId(), "id");
    }

    @Test
    void checkHit() {
        boat.setBoat(3, "name", "id");
        boat.setPosition(1, 1);
        assert (!boat.hit(12));
        assert (boat.hit(1));
        assert (boat.hit(11));
        assert (boat.hit(21));
    }

    @Test
    void checkSunk() {
        boat.setBoat(3, "name", "id");
        boat.setPosition(1, 1);
        boat.hit(1);
        boat.hit(11);
        boat.hit(21);
        assert (boat.isSunk());
    }

    @Test
    void checkPosition() {
        boat.setBoat(3, "name", "id");
        boat.setPosition(1, 1);
        int[] pos = new int[3];
        pos[0] = 1;
        pos[1] = 11;
        pos[2] = 21;
        Assertions.assertEquals(boat.getPosition()[0], pos[0]);
        Assertions.assertEquals(boat.getPosition()[1], pos[1]);
        Assertions.assertEquals(boat.getPosition()[2], pos[2]);
    }

}