import static org.junit.Assert.*;

import org.junit.Test;

public class BattleshipGameTest {
    //initiate a new battleship game
    BattleshipGame testGame = new BattleshipGame();

    @Test
    public void testBattleshipGame() {
	fail("Not yet implemented");
    }

    @Test
    public void testAcceptShots() {
	//test by entering coordinates and making sure that the array list has them in the correct spot
	//int test = testGame.acceptShots()[1][3];
	//assertEquals(test, 15);
    }

    @Test
    public void testShotResponse() {
	//first run acceptShots on testGame
	int[][] test = testGame.acceptShots();
	testGame.shotResponse(test);
    }
}
