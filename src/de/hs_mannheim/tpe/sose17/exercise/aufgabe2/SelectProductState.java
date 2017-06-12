package de.hs_mannheim.tpe.sose17.exercise.aufgabe2;

class SelectProductState implements State {

	private static final String[] PRODUCTS = { "Black Tea", "Coffee", "Cappuccino", "Cancel order"};
	
	private static final State[] PRODUCT_STATES = {
		new BlackTeaState(),
		new CoffeeState(),
		new CappuccinoState(),
		null // Will quit the program.
	};
	
	@Override
	public State execute(StateMachine stateMachine) {
		System.out.println("Please select a product by entering the one of the following numbers:");
		
		// Print products
		for (int i = 0; i < PRODUCTS.length; i++) {
			System.out.println(String.format("[%d]%s", i, PRODUCTS[i]));
		}
		
		int selection = InputHelper.readInt();
		
		if (selection >= 0 && selection < PRODUCTS.length) {
			return PRODUCT_STATES[selection];
		} else {
			System.err.println(String.format("Invalid number %d.", selection));
			return this;
		}
	}
}
