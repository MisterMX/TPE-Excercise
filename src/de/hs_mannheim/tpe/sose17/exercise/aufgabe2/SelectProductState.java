package de.hs_mannheim.tpe.sose17.exercise.aufgabe2;

import java.util.HashMap;

class SelectProductState implements State {

	private static final int NUMBER_CANCEL = -1;
	
	private static final String[] PRODUCTS = { "black tea", "green tea", "coffee", "cappuccino"};
	private static final float[] PRODUCT_COSTS = { 2f, 2f, 2.5f, 2.6f };
	
	private final HashMap<String, Object> arguments;
	
	public SelectProductState(HashMap<String, Object> arguments) {
		this.arguments = arguments;
	}
	
	@Override
	public State execute(StateMachine stateMachine) {
		System.out.println("Please select a product:");
		
		// Print products
		for (int i = 0; i < PRODUCTS.length; i++) {
			System.out.println(String.format("[%d]%s", i, PRODUCTS[i]));
		}
		
		System.out.println(String.format("[%d]Cancel order", NUMBER_CANCEL));
		
		int selection = InputHelper.readInt();
		
		if (selection == NUMBER_CANCEL) {
			System.out.println("Order canceled.");
			return null;
		} else if (selection >= 0 && selection < PRODUCTS.length) {
			arguments.put(ArgumentKeys.KEY_PRODUCT, PRODUCTS[selection]);
			arguments.put(ArgumentKeys.KEY_COSTS, PRODUCT_COSTS[selection]);
			return new SelectTemperatureState(arguments);
		} else {
			System.err.println(String.format("Invalid number %d.", selection));
			return this;
		}
	}
}
