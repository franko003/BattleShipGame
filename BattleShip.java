
public class BattleShip extends Ship {
    BattleShip() {
	this.setLength(8);
	boolean[] battleshipHit = {false, false, false, false, false, false, false, false};
	this.setHit(battleshipHit);
    }	

    @Override
    String getShipType() {
	return "battleship";
    }

}
