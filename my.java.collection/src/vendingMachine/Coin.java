package src.vendingMachine;

public class Coin {
	int denomination;
	String name;

	public String getName() {
		return name;
	}

	public int getDenomination() {
		return denomination;
	}

	public void setDenomination(int denomination) {
		this.denomination = denomination;
	}

	public void setName(String name) {
		this.name = name;
	}
}
