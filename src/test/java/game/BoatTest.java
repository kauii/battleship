package game;

import static org.junit.Assert.*;

import org.junit.Test;

class BoatTest {

	Boat boat = new Boat();
	
	@Test
	void checksetBoat() {
	    Boat tempBoat = boat.setBoat(3,"name","id");

    	assertEquals(tempBoat.getSize(),3);
    	assertEquals(tempBoat.getName(),"name");
    	assertEquals(tempBoat.getId(),"id");
    }
	
}