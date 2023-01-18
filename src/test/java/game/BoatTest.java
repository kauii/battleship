package game;

import static org.junit.Assert.*;

import	org.junit.jupiter.api.Test;

class BoatTest {

	Boat boat = new Boat();
	
	@Test
	void checksetBoat() {
	    Boat tempBoat = boat.setBoat(3,"name","id");

    	assertEquals(tempBoat.getSize(),3);
    	assertEquals(tempBoat.getName(),"name");
    	assertEquals(tempBoat.getId(),"id");
    }
	@Test
	void checkHit() {
	    boat.setBoat(3,"name","id");
	    boat.setPosition(1, 01);
    	assert(!boat.hit(12));
    	assert(boat.hit(01));
    	assert(boat.hit(11));
    	assert(boat.hit(21));
    }	
	@Test
	void checkSunk() {
	    boat.setBoat(3,"name","id");
	    boat.setPosition(1, 01);
    	boat.hit(01);
    	boat.hit(11);
    	boat.hit(21);
    	assert(boat.isSunk());
    }
	
	@Test
	void checkPosition() {
	    boat.setBoat(3,"name","id");
	    boat.setPosition(1, 01);
	    int[] pos = new int[3];
	    pos[0] = 1;
	    pos[1] = 11;
	    pos[2] = 21;
    	assertEquals(boat.getPosition()[0],pos[0]);
    	assertEquals(boat.getPosition()[1],pos[1]);
    	assertEquals(boat.getPosition()[2],pos[2]);
    }
	
}