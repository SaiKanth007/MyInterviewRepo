package src.vendingMachine.states;

import java.util.List;

import src.vendingMachine.Coin;
import src.vendingMachine.VendingMachine;
import src.vendingMachine.VendingMachineState;

public class SelectProduct implements VendingMachineState {

	VendingMachine machine;

	public SelectProduct(VendingMachine pMachine) {
		machine = pMachine;
	}

	@Override
	public void selectProduct() {
		System.out.println("Please Select Product");

	}

	@Override
	public void insertCash() {
		System.out.println("No Product is selected yet");

	}

	@Override
	public void productDispensed() {
		System.out.println("No Product is selected yet");

	}

	@Override
	public void noChangeAvailableWithMachine() {
		System.out.println("No Product is selected yet");

	}

	@Override
	public void productSelected() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cashInserted(List<Coin> coins) {
		// TODO Auto-generated method stub

	}

}
