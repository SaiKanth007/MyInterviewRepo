package src.vendingMachine;

import java.util.List;

public interface VendingMachineState {

	void selectProduct() ;
	void insertCash();
	void productDispensed();
	void noChangeAvailableWithMachine();
	void productSelected();
	void cashInserted(List<Coin> coins);
	
}
