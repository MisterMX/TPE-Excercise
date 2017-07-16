package de.hs_mannheim.tpe.sose17.exercise.aufgabe2;

import java.util.HashMap;

class SelectTemperatureState implements State {

	private static final int NUMBER_CANCEL = -1;
	
	private static final String[] TEMPERATURES = { "warm", "hot" } ;
	
	private final HashMap<String, Object> arguments;
	
	public SelectTemperatureState(HashMap<String, Object> arguments) {
		this.arguments = arguments;
	}
	
	@Override
	public State execute(StateMachine stateMachine) {
		System.out.println("Please choose a temperature:");
		
		// Print temperatures
		for (int i = 0; i < TEMPERATURES.length; i++) {
			System.out.println(String.format("[%d]%s", i, TEMPERATURES[i]));
		}
		
		System.out.println(String.format("[%d]Cancel order", NUMBER_CANCEL));
		
		int selection = InputHelper.readInt();
		
		if (selection == NUMBER_CANCEL) {
			System.out.println("Order canceled.");
			return null;
		} else if (selection >= 0 && selection < TEMPERATURES.length) {
			arguments.put(ArgumentKeys.KEY_TEMPERATURE, TEMPERATURES[selection]);
			return new SelectStrengthState(arguments);
		} else {
			System.err.println(String.format("Invalid number %d.", selection));
			return this;
		}
	}

}
