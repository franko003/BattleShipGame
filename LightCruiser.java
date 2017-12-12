
public class LightCruiser extends Ship {
    LightCruiser() {
	this.setLength(5);
	boolean[] lightcruiserHit = {false, false, false, false, false};
	this.setHit(lightcruiserHit);
    }
    @Override
    String getShipType() {
	return "light cruiser";
    }

}
