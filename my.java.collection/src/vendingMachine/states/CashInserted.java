package src.vendingMachine.states;

import java.util.List;

import src.vendingMachine.Coin;
import src.vendingMachine.VendingMachine;
import src.vendingMachine.VendingMachineState;

public class CashInserted implements VendingMachineState {

	VendingMachine machine;

	public CashInserted(VendingMachine pMachine) {
		machine = pMachine;
	}

	@Override
	public void selectProduct() {
		System.out.println("Product already selected, cannot select an other one");

	}

	@Override
	public void insertCash() {
		System.out.println("you have inserted cash already, please wait while we process your request");
	}

	public VendingMachine getMachine() {
		return machine;
	}

	public void setMachine(VendingMachine machine) {
		this.machine = machine;
	}

	@Override
	public void productDispensed() {
		System.out.println("you have inserted cash already, please wait while we process your request");
	}

	@Override
	public void noChangeAvailableWithMachine() {
		// TODO Auto-generated method stub

	}

	@Override
	public void productSelected() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cashInserted(List<Coin> coins) {
		System.out.println("Thank you for inserting the cash, please wait while we process your request");
		// check if the given amount is sufficient for the product selected and if
		// any balance has to be returned process that accordingly
		Double totalSum = coins.stream().mapToDouble(coin -> coin.getDenomination()).sum();
		this.getMachine().setAmountAvailableWithVendingMachine(totalSum);
		this.getMachine().setCurrentState(this.getMachine().getDispensedProduct());
	}

}
