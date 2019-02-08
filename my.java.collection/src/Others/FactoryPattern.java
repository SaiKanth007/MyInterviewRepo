package src.Others;

import src.Utilities.Coin;
import src.Utilities.Nickel;
import src.Utilities.Penny;

public class FactoryPattern {

	public static Coin getCoin(String coinType) {
		if (cointTypes.PENNY.value.equals(coinType))
			return new Penny();
		else if (cointTypes.NICKEL.value.equals(coinType)) {
			return new Nickel();
		}
		return null;
	}

}

enum cointTypes {
	PENNY("penny"), NICKEL("nickel");
	String value;

	public String getValue() {
		return value;
	}

	private cointTypes(String value) {
		this.value = value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

enum cointTypes2 {
	PENNY, NICKEL;
}
