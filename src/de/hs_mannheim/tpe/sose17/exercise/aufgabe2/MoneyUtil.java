package de.hs_mannheim.tpe.sose17.exercise.aufgabe2;

class MoneyUtil {
	
	/**
	 * Calculates the number of coins that should be returned.
	 * 
	 * @param paymentMethods The available payment methods.
	 * @param payment The value that should be returned.
	 * @return the number of each given payment method in an array of the same length as paymentMethods.
	 */
	public static int[] getReturn(float[] paymentMethods, float payment) {
		int[] countings = new int[paymentMethods.length];

		float paymentRest = payment;

		// Return money
		int paymentIndex = 0;
		while (paymentRest < 0 && paymentIndex < paymentMethods.length) {
			int count = (int) Math.abs(paymentRest / paymentMethods[paymentIndex]);

			paymentRest += paymentMethods[paymentIndex] * count;
			if (count > 0) {
				countings[paymentIndex] = count;
			}
			paymentIndex++;
		}
		
		return countings;
	}
}
