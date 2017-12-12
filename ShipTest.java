import static org.junit.Assert.*;

import org.junit.Test;

public class ShipTest {
    
    Ocean testOcean = new Ocean();
    Ship testShip = new Destroyer();

    @Test
    public void testOkToPlaceShipAt() {
	assertTrue(testShip.okToPlaceShipAt(11, 17, false, testOcean));
    }

    @Test
    public void testPlaceShipAt() {
	fail("Not yet implemented");
    }

    @Test
    public void testShootAt() {
	//just initialized a new Destroyer
	testShip.placeShipAt(0, 0, true, testOcean);
	testShip.shootAt(0, 0);
	assertTrue(testShip.getHit()[0]);
	//shoot at the back end of the ship
	testShip.shootAt(0, 3);
	assertTrue(testShip.getHit()[3]);
    }

    @Test
    public void testIsSunk() {
	//just initialized new Destroyer
	assertTrue(!testShip.isSunk());
	//change hit array to all hits
	boolean[] testHit = {true, true, true, true};
	testShip.setHit(testHit);
	assertTrue(testShip.isSunk());
	//change hit array to 3 of 4 hits
	boolean[] testHit1 = {true, true, false, true};
	testShip.setHit(testHit1);
	assertTrue(!testShip.isSunk());
    }

    @Test
    public void testToString() {
	//just initialized new Destroyer
	assertTrue(testShip.toString().equals("S"));
	//change hit array to all hits
	boolean[] testHit = {true, true, true, true};
	testShip.setHit(testHit);
	assertTrue(testShip.toString().equals("x"));
	//change hit array to 3 of 4 hits
	boolean[] testHit1 = {true, true, false, true};
	testShip.setHit(testHit1);
	assertTrue(testShip.toString().equals("S"));
    }

}
