import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Ocean {
    //instance variables
    Ship[][] ships = new Ship[20][20];
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;
    //NEW STUFF
    Map<Integer, Integer> shots = new HashMap<Integer, Integer>();
    
    //constructor
    /*
     * creates an empty Ocean by filling the 20x20 array with EmptySea instances
     * initializes game variables, shotsFired, hitCount, shipsSunk
     */
    Ocean() {
	//iterate through ships array and set each index value to a new instance of EmptySea
	for (int i = 0; i < 20; i++) {
	    for (int j = 0; j < 20; j++) {
		ships[i][j] = new EmptySea();
	    }
	}
	//initiate game variables to 0
	shotsFired = 0;
	hitCount = 0;
	shipsSunk = 0;
    }
    
    //Getters for shotsFired, hitCount, and shipsSunk
    public int getShotsFired() {
        return shotsFired;
    }
    
    public int getHitCount() {
        return hitCount;
    }
    
    public int getShipsSunk() {
        return shipsSunk;
    }

    //methods
    /*
     * place all 13 ships randomly on the initally empty ocean, goes largest to smallest
     * uses Random class in the java.util package
     */
    void placeAllShipsRandomly() {
	/*
	//FOR TESTING PURPOSES JUST WRITE SIMPLE CODE TO PLACE SHIPS
	//initialize a Cruiser
	Ship testCruiser = new Cruiser();
	testCruiser.placeShipAt(5, 5, true, this);
	*/
	//initialize the 13 ships and put them in an array
	Ship battleShip = new BattleShip();
	Ship battleCruiser = new BattleCruiser();
	Ship cruiser1 = new Cruiser();
	Ship cruiser2 = new Cruiser();
	Ship lightCruiser1 = new LightCruiser();
	Ship lightCruiser2 = new LightCruiser();
	Ship destroyer1 = new Destroyer();
	Ship destroyer2 = new Destroyer();
	Ship destroyer3 = new Destroyer();
	Ship submarine1 = new Submarine();
	Ship submarine2 = new Submarine();
	Ship submarine3 = new Submarine();
	Ship submarine4 = new Submarine();

	Ship[] allShips = {battleShip, battleCruiser, cruiser1, cruiser2, lightCruiser1, lightCruiser2, destroyer1, destroyer2,
		destroyer3, submarine1, submarine2, submarine3, submarine4};
	
	//create a random class object for ints 0-19 for row and column
	Random random = new Random();
	random.ints(0, 20);
	//random.nextInt(20)
	
	//loop through the list of all ships and place in the ocean, first making sure the spot is allowed
	for (Ship ship : allShips) {
	    //generate a random set of coordinates, set checkOcean equal to false, and horizontal to true to randomize that as well
	    int randomRow = random.nextInt(20);
	    int randomColumn = random.nextInt(20);
	    boolean searchOcean = true;
	    boolean orientation = true;
	    //test for a good spot in the ocean to place the ship
	    while (searchOcean) {
		if (ship.okToPlaceShipAt(randomRow, randomColumn, orientation, this)) {
		    ship.placeShipAt(randomRow, randomColumn, orientation, this);
		    break;
		} else {
		    //get new coordinates randomly and switch orientation
		    randomRow = random.nextInt(20);
		    randomColumn = random.nextInt(20);
		    orientation = !orientation;
		}
	    }
	}

    }
    
    /*
     * returns true if the given location contains a ship, false if not
     */
    boolean isOccupied(int row, int column) {
	if(ships[row][column].getShipType() != "empty") {
	    return true;
	} 
	
	return false;
    }
    
    /*
     * returns true if the location contains a "real" ship, still afloat, false if not
     * updates the number of shots that have been fired, number of hits
     */
    boolean shootAt(int row, int column) {
	//update shotsFired
	shotsFired += 1;
	//check if empty sea, if so return false
	if (ships[row][column].getShipType().equals("empty")) {
	    //NEW STUFF
	    shots.put(row, column);
	    return false;
	}
	//check if ship is sunk, if so return false
	if (ships[row][column].isSunk()) {
	    return false;
	}
	//update hitCount and return true
	hitCount += 1;
	return true;
    }
    
    /*
     * returns true if all ships have been sunk, false if not
     */
    boolean isGameOver() {
	//there are 13 ships and when a ship is sunk shipsSunk get updated so just false until shipsSunk == 13
	if (shipsSunk < 13) {
	    return false;
	}
	return true;
    }
    
    /*
     * returns the 20x20 array of ships
     */
    Ship[][] getShipArray() {
	return ships;
    }
    
    /*
     * prints the ocean with row numbers 0-19 displayed to left and column numbers displayed on top
     * uses "S" to indicate fired and hit, "-" fired and missed, "x" sunken ship, "." never fired upon
     * only method in Ocean that does any input/output, never called from within Ocean, only from BattleshipGame class
     */
    void print() {
	//first need to print out the top row which is " " then 0-19 for column numbers
	//initialize and fill an array with the values 00, 0-19 to use for the top row and left column
	int index = 0;
	int[] indexRowColumn = new int[20];
	//print out R/C for Row/Column in top left corner
	System.out.print("R/C");
	System.out.print("\t");
	for (int i = 0; i < 20; i ++) {
	    indexRowColumn[i] = index;
	    System.out.print(indexRowColumn[i]);
	    System.out.print("\t");
	    index += 1;
	}
	System.out.print("\n");
	//now use indexRowColumn and the ships array to fill in the rest of the ocean
	for (int i = 0; i < 20; i++) {
	    System.out.print(indexRowColumn[i]);
	    System.out.print("\t");
	    for (int j = 0; j < 20; j++) {
		//JUST NEED TO PUT THE RIGHT CODE IN HERE TO GET "S" "-" "x" OR "."
		//check if spot in ocean is occupied, if so print ship and toString method override will come up with correct value
		//NEW STUFF
		if (shots.containsKey(i) && shots.get(i) == j && ships[i][j].getShipType() == "empty") {
		    System.out.print("-");
		} else {
		    System.out.print(ships[i][j]);
		}
		
		System.out.print("\t");
	    }
	    System.out.print("\n");
	}
	
    }
}
