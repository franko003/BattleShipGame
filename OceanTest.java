import static org.junit.Assert.*;

import org.junit.Test;

public class OceanTest {
    
    Ocean testOcean = new Ocean();
    
    @Test
    public void testOcean() {
	assertEquals(0, testOcean.getShipsSunk());
    }

    @Test
    public void testPlaceAllShipsRandomly() {
	//testOcean.placeAllShipsRandomly();
	//testOcean.print();
    }

    @Test
    public void testIsOccupied() {
	fail("Not yet implemented");
    }

    @Test
    public void testShootAt() {
	//place test ship and shoot at the bow
	testOcean.placeAllShipsRandomly();
	testOcean.print();
	assertEquals(testOcean.getShotsFired(), 0);
	boolean testBoo = testOcean.shootAt(0, 0);
	System.out.println(testOcean.ships[0][0].getShipType());
	//test for shotsFired update, hitCount update and return of true for the method
	assertEquals(testOcean.getShotsFired(), 1);
	assertEquals(testOcean.getHitCount(), 0);
	testOcean.print();
	//assertTrue(!testBoo);
    }

    @Test
    public void testIsGameOver() {
	fail("Not yet implemented");
    }

    @Test
    public void testPrint() {
	//testOcean.placeAllShipsRandomly();
	//testOcean.print();
    }

}
