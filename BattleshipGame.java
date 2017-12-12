import java.util.ArrayList;
import java.util.Scanner;

public class BattleshipGame {
    //instance variable
    Ocean gameOcean = new Ocean();
    /*
     * To start i think i will break this up into different methods, one for each aspect
     * SETUP GAME
     * ACCEPT SHOTS
     * DISPLAY RESULTS
     * GAME OVER - PRINT SCORES/DO YOU WANT TO PLAY AGAIN?
     */
    
    //constructor - sets up the game
    BattleshipGame() {
	//place all ships in the gameOcean
	gameOcean.placeAllShipsRandomly();
    }

    //methods
    /*
     * accepts shots from the user and formats them in an int[][] with the first row the row values and 2nd row the column values
     */
    public int[][] acceptShots() {

	//initiate row and column arrays for the coordinates given by the user
	ArrayList<Integer> row = new ArrayList<Integer>();
	ArrayList<Integer> column = new ArrayList<Integer>();
	//give instructions to the user about number and format of shots
	System.out.println("You get 5 shots.  Please shoot in the following format:");
	System.out.println("1,2;3,4;5,6;7,8;9,10");
	System.out.println("That is to say, row number (0-19), comma, column number (0-19), semicolon, next row number, comma,.....");
	System.out.println("Enter shots now:");
	//initialize a scanner to read from the user input
	Scanner scanner = new Scanner(System.in);
	//take in the line from user and parse into individual coordinates
	String userShots = scanner.next();
	String[] userCoords = userShots.split(";");
	//go through each coordinate and split on the comma, putting the first coordinate into array row and second into column
	for (String coord : userCoords) {
	    String[] index = coord.split(",");
	    row.add(Integer.valueOf(index[0]));
	    column.add(Integer.valueOf(index[1]));
	}
	//change arrayLists back into primitives
	int[] rowInt = new int[5];
	int[] columnInt = new int[5];
	
	for (int i = 0; i < 5; i++) {
	    rowInt[i] = (int) row.get(i);
	    columnInt[i] = (int) column.get(i);
	}
	//set shotsFired to desired row and column arrays and return.  Close scanner
	int[][] shotsFired = {rowInt, columnInt};
	scanner.close();
	return shotsFired;
    }
    
    /*
     * responds hit or miss to user based on shots fired
     * if hit, checks if sunk and displays ship type
     */
    public void shotResponse(int[][] shots) {
	//given 2D shot array we need to separate into row and column coords
	int[] shotsRow = shots[0];
	int[] shotsColumn = shots[1];
	//loop through using coords row and column to check if any of the 5 shots are a hit
	for (int i = 0; i < 5; i++) {
	    if (gameOcean.shootAt(shotsRow[i], shotsColumn[i])) {
		System.out.println("HIT");
		//check if ship is sunk and if so notify user of ship type
		if(gameOcean.getShipArray()[i][i].isSunk()) {
		    System.out.println("You just sank a " + gameOcean.getShipArray()[i][i].getShipType());
		}
	    } else {
		System.out.println("MISS");
	    }
	}
    }
    
    /*
     * given shots fired from the user it updates the ocean ship array
     */
    public void updateOcean(int[][] shots) {
	//given 2D shot array we need to separate into row and column coords
	int[] shotsRow = shots[0];
	int[] shotsColumn = shots[1];
	//loop through using coords row and column to check if any of the 5 shots are a hit
	for (int i = 0; i < 5; i++) {
	    if (gameOcean.shootAt(shotsRow[i], shotsColumn[i])) {
		
	    }
	}
    }
    public static void main(String[] args) {
	//begin a new battleship game and print the ocean
	BattleshipGame battle = new BattleshipGame();
	battle.gameOcean.print();
	
	//user calls out shots by entering 5 row, column tuples
	
	//response is hit or miss, if ship is sunk print "You just sank a ship-type", update ocean and display
	
	//if game over, print out game over, tell how many shots required and ask to play again

    }

}
