package de.hs_mannheim.tpe.sose17.exercise.aufgabe2;

import java.util.HashMap;

class SelectStrengthState implements State {

	private static final int NUMBER_CANCEL = -1;
	
	private static final String[] STRENGTHS = { "strong", "mild" } ;
	
	private final HashMap<String, Object> arguments;
	
	public SelectStrengthState(HashMap<String, Object> arguments) {
		this.arguments = arguments;
	}
	
	@Override
	public State execute(StateMachine stateMachine) {
		System.out.println("Please choose the strength of your beverage:");
		
		// Print strengths
		for (int i = 0; i < STRENGTHS.length; i++) {
			System.out.println(String.format("[%d]%s", i, STRENGTHS[i]));
		}
		
		System.out.println(String.format("[%d]Cancel order", NUMBER_CANCEL));
		
		int selection = InputHelper.readInt();
		
		if (selection == NUMBER_CANCEL) {
			System.out.println("Order canceled.");
			return null;
		} else if (selection >= 0 && selection < STRENGTHS.length) {
			arguments.put(ArgumentKeys.KEY_STRENGTH, STRENGTHS[selection]);
			return new PaymentState(arguments);
		} else {
			System.err.println(String.format("Invalid number %d.", selection));
			return this;
		}
	}
}
