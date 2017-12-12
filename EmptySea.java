
public class EmptySea extends Ship {
    //constructor
    EmptySea() {
	this.setLength(1);
    }
    
    @Override
    boolean shootAt(int row, int column) {
	return false;
    }
    
    @Override
    boolean isSunk() {
	return false;
    }
    
    @Override
    public String toString() {
	return ".";
    }

    @Override
    String getShipType() {
	// TODO Auto-generated method stub
	return "empty";
    }

}
