package de.hs_mannheim.tpe.sose17.exercise.aufgabe2;

import java.util.HashMap;

public class Main {

	/**
	 * Entry point of the application.
	 * @param args
	 */
	public static void main(String[] args) {
		StateMachine stateMachine = new StateMachine(new SelectProductState(new HashMap<>()));
		stateMachine.run();
	}

}
