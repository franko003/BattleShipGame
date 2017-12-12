
public class Cruiser extends Ship {
    Cruiser() {
	this.setLength(6);
	boolean[] cruiserHit = {false, false, false, false, false, false};
	this.setHit(cruiserHit);
    }
    @Override
    String getShipType() {
	return "cruiser";
    }

}
