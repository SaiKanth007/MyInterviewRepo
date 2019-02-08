package src.vendingMachine.states;

import java.util.List;

import src.vendingMachine.Coin;
import src.vendingMachine.VendingMachine;
import src.vendingMachine.VendingMachineState;

public class ProductSelected implements VendingMachineState{

	
	VendingMachine machine;

	public ProductSelected(VendingMachine pMachine) {
		machine = pMachine;
	}

	
	@Override
	public void selectProduct() {
		
		
	}

	@Override
	public void insertCash() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void productDispensed() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

}
