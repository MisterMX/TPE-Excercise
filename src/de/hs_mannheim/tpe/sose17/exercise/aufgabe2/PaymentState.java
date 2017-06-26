package de.hs_mannheim.tpe.sose17.exercise.aufgabe2;

import java.util.HashMap;

class PaymentState implements State {

	private static final int NUMBER_CANCEL = -1;
	
	private static final float[] PAYMENT_INPUT = { 2f, 1f, 0.5f, 0.2f, 0.1f } ;
	
	private final HashMap<String, Object> arguments;
	
	
	public PaymentState(HashMap<String, Object> arguments) {
		this.arguments = arguments;
	}
	
	@Override
	public State execute(StateMachine stateMachine) {
		float paymentRest = (float)arguments.get(ArgumentKeys.KEY_COSTS); 
		
		System.out.println(String.format(
				"You have  ordered a %s %s %s for %.2f",
				arguments.get(ArgumentKeys.KEY_TEMPERATURE),
				arguments.get(ArgumentKeys.KEY_STRENGTH),
				arguments.get(ArgumentKeys.KEY_PRODUCT),
				paymentRest));
		
		System.out.println("Please pay only with the following:");
		for (int i = 0; i < PAYMENT_INPUT.length; i++) {
			System.out.print(String.format("%.2f ", PAYMENT_INPUT[i]));
		}
		System.out.println();
		System.out.println("[%d]Cancel order");
		
		// Collect money
		while (paymentRest > 0) {
			float input = InputHelper.readFloat();
			
			if (input == NUMBER_CANCEL) {
				System.out.println("Order canceled.");
				return null;
			} else if (isValidPayment(input)) {
				paymentRest -= input;
				System.out.println(String.format("Rest: %.2f", paymentRest));
			} else {
				System.out.println(String.format("Invalid payment: %.2f. Try again.", input));
			}
		}
	}

	/**
	 * Checks, whether the following value is a valid input payment method.
	 * @param value
	 * @return
	 */
	private boolean isValidPayment(float value) {
		for (float registered : PAYMENT_INPUT) {
			if (registered == value) {
				return true;
			}
		}
		
		return false;
	}
}
