
public class Destroyer extends Ship {
    Destroyer() {
	this.setLength(4);
	boolean[] destroyerHit = {false, false, false, false};
	this.setHit(destroyerHit);
    }
    
    @Override
    String getShipType() {
	return "destroyer";
    }

}
