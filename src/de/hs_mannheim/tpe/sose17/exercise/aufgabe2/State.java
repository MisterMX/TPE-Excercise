package de.hs_mannheim.tpe.sose17.exercise.aufgabe2;

/**
 * Represents the state of a {@link StateMachine}.
 */
interface State {
	/**
	 * Executes the current {@link State} for the following {@link StateMachine}.
	 * @param stateMachine
	 * @return the next {@link State}. If it is null, the machine will quit.
	 */
	State execute(StateMachine stateMachine);
}
