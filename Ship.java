
public abstract class Ship {
    //instance variables
    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;
    
    //abstract method
    abstract String getShipType();
    
    //Getters and Setters for all instance variables
    public int getBowRow() {
        return bowRow;
    }
    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }
    public int getBowColumn() {
        return bowColumn;
    }
    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public boolean isHorizontal() {
        return horizontal;
    }
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }
    public boolean[] getHit() {
        return hit;
    }
    public void setHit(boolean[] hit) {
        this.hit = hit;
    }
    
    //methods
    /*
     * returns true if it is ok to put a ship of this length with its bow in this location, with the given orientation, returns false otherwise
     * the ship must not overlap another ship or touch another ship and it cant stick out beyond the array
     */
    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
	//check OK given length, with bow in this location and orientation
	//first check length vs row or column depending on orientation to see if the potential ship could fit in the sea
	//create and initialize variable lastRowColumn to describe the last row or column possible given ship length
	int lastRowColumn = 20 - length;
	if (horizontal) {
	    if (column > lastRowColumn) {
		return false;
	    }
	} else {
	    if (row > lastRowColumn) {
		return false;
	    }
	}
	//next, if horizontal loop through all index values in Ocean array around potential Ship
	//create start and end Row and Column variables
	int startRow;
	int endRow;
	int startColumn;
	int endColumn;
	//set variables depending on orientation of the ship
	if (horizontal) {
	    //initialize start and end Row and Column variables for iteration
	    startRow = row - 1;
	    endRow = row + 1;
	    startColumn = column - 1;
	    endColumn = column + length;
	} else {    
	    //initialize start and end Row and Column variables for iteration
	    startRow = row - 1;
	    endRow = row + length;
	    startColumn = column - 1;
	    endColumn = column + 1;
	    
	}    
	//now that i have set start and end for Row and Column need to check that they are in the Ocean
	//first create and set an int[] to put all values in
	int[] checkRowColumn = {startRow, endRow, startColumn, endColumn};
	//loop through and check if less than 0 or greater than 19, if so change value to 0 or 19 respectively
	for (int i = 0; i < checkRowColumn.length; i++) {
	    if (checkRowColumn[i] < 0) {
		checkRowColumn[i] = 0;
	    }
	    if (checkRowColumn[i] > 19) {
		checkRowColumn[i] = 19;
	    }
	}
	//now that changes to the values have been made in checkRowColumn, set start and end variables to correct values
	startRow = checkRowColumn[0];
	endRow = checkRowColumn[1];
	startColumn = checkRowColumn[2];
	endColumn = checkRowColumn[3];
	//now use 2 for loops to get through the correct spots in the Ocean on and around the potential place for the new Ship
	for (int i = startRow; i <= endRow; i++) {
	    for (int j = startColumn; j <= endColumn; j++) {
		//if any spot in the ocean has a ship with length != 1 we know its not EmptySea so we return false because we cant place a new ship
		if (ocean.getShipArray()[i][j].getLength() != 1) {
		    return false;
		}
	    }
	}
	//if all spots are == 1 than we know they are all EmptySea and we return true
	return true;
    }
    
    /*
     * "puts" this ship in the ocean
     * gives values to bowRow, bowColumn and horizontal instance variables of the ship
     * puts a reference to the ship in each of 1 or more locations (up to 8) in the ships array in the Ocean object
     */
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
	//give values to instance variables
	bowRow = row;
	bowColumn = column;
	this.horizontal = horizontal;
	//now put a reference to "this" ship in the correct parts of the ocean depending on orientation and length
	if (horizontal) {
	    for (int i = column; i < column + length; i ++) {
		ocean.getShipArray()[row][i] = this;
	    }
	} else {
	    for (int i = row; i < row + length; i ++) {
		ocean.getShipArray()[i][column] = this;
	    }
	}
    }
    
    /*
     * if a part of the ship occupies the give row and column and the ship hasnt been sunk, mark that part of the ship as "hit" in hit array
     * and return true, otherwise return false
     */
    boolean shootAt(int row, int column) {
	//if the ship is sunk return false
	if (this.isSunk()) {
	    return false;
	}
	//iterate down the ship starting at the bow depending on orientation and check whether given coordinates are on the ship
	if (horizontal) {
	    for (int i = bowColumn; i < bowColumn + length; i ++) {
		if (bowRow == row && i == column) {
		    hit[column] = true;
		    return true;
		}
	    }
	} else {
	    for (int i = bowRow; i < bowRow + length; i ++) {
		if (i == row && bowColumn == column) {
		    hit[row] = true;
		    return true;
		}
	    }
	}
	return false;
    }
    
    /*
     * return true if every part of the ship has been hit, false otherwise
     */
    boolean isSunk() {
	//loop through the hit array and return true if all are true, false otherwise
	for (boolean b : hit) {
	    if (!b) {
		return false;
	    }
	}
	return true;
    }
    
    /*
     * returns a single-char String to use in the Oceans print method, "x" if the ship has been sunk, "S" if it has not been sunk
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        if (this.isSunk()) {
            return "x";
        } else {
            return "S";
        }
        
    }

}
