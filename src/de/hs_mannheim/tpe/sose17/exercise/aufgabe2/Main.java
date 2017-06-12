package de.hs_mannheim.tpe.sose17.exercise.aufgabe2;

public class Main {

	public static void main(String[] args) {
		StateMachine stateMachine = new StateMachine(new SelectProductState());
		stateMachine.run();
	}

}
