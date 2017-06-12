package de.hs_mannheim.tpe.sose17.exercise.aufgabe2;

/**
 * Implements a finite state machine using an interface.
 */
class StateMachine {
	private State currentState;
	
	/**
	 * Initializes a new instance of the {@link StateMachine} class.
	 * @param initialState
	 */
	public StateMachine(State initialState) {
		currentState = initialState;
	}
	
	/**
	 * Executes the current {@link StateMachine}.
	 */
	public void run() {
		while (currentState != null) {
			currentState = currentState.execute(this);
		}
	}
}
