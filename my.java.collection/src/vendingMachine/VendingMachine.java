package src.vendingMachine;

import java.util.List;

import src.vendingMachine.states.InsertCash;
import src.vendingMachine.states.NoChangeAvailbale;
import src.vendingMachine.states.ProductDispensed;
import src.vendingMachine.states.SelectProduct;

//this solution is more based on the system design point of view
// and hence much of the business logic is not covered yet
// i will have to add that as well soon 
//https://springframework.guru/gang-of-four-design-patterns/state-pattern/
public class VendingMachine implements VendingMachineState {

	// possible states
	VendingMachineState selectProduct;
	VendingMachineState insertCash;
	VendingMachineState dispensedProduct;
	VendingMachineState noChangeAvailable;

	VendingMachineState currentState;

	Double amountAvailableWithVendingMachine = 0.0;
	String productSelected = null;
	List<Coin> coinsInserted = null;

	public Double getAmountAvailableWithVendingMachine() {
		return amountAvailableWithVendingMachine;
	}

	public void setAmountAvailableWithVendingMachine(Double amountAvailableWithVendingMachine) {
		this.amountAvailableWithVendingMachine = amountAvailableWithVendingMachine;
	}

	public VendingMachineState getSelectProduct() {
		return selectProduct;
	}

	public void setSelectProduct(VendingMachineState selectProduct) {
		this.selectProduct = selectProduct;
	}

	public VendingMachineState getInsertCash() {
		return insertCash;
	}

	public void setInsertCash(VendingMachineState insertCash) {
		this.insertCash = insertCash;
	}

	public VendingMachineState getDispensedProduct() {
		return dispensedProduct;
	}

	public void setDispensedProduct(VendingMachineState dispensedProduct) {
		this.dispensedProduct = dispensedProduct;
	}

	public VendingMachineState getNoChangeAvailable() {
		return noChangeAvailable;
	}

	public void setNoChangeAvailable(VendingMachineState noChangeAvailable) {
		this.noChangeAvailable = noChangeAvailable;
	}

	public VendingMachineState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(VendingMachineState machineState) {
		this.currentState = machineState;
	}

	public VendingMachine() {
		this.selectProduct = new SelectProduct(this);
		this.insertCash = new InsertCash(this);
		this.dispensedProduct = new ProductDispensed(this);
		this.noChangeAvailable = new NoChangeAvailbale(this);
		this.currentState = this.selectProduct;

	}

	@Override
	public void selectProduct() {
		currentState.selectProduct();
	}

	@Override
	public void insertCash() {
		currentState.insertCash();

	}

	@Override
	public void productDispensed() {
		currentState.productDispensed();

	}

	@Override
	public void noChangeAvailableWithMachine() {
		currentState.noChangeAvailableWithMachine();
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
