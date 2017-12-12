
public class Submarine extends Ship {
    Submarine() {
	this.setLength(3);
	boolean[] submarineHit = {false, false, false};
	this.setHit(submarineHit);
    }
    @Override
    String getShipType() {
	return "submarine";
    }

}
