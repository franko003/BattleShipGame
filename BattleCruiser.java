
public class BattleCruiser extends Ship {
    BattleCruiser() {
	this.setLength(7);
	boolean[] battlecruiserHit = {false, false, false, false, false, false, false};
	this.setHit(battlecruiserHit);
    }
    @Override
    String getShipType() {
	return "battlecruiser";
    }

}
