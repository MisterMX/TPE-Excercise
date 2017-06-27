package de.hs_mannheim.tpe.sose17.exercise.aufgabe2;

import java.util.InputMismatchException;
import java.util.Scanner;

final class InputHelper {

	private static final Scanner scanner = new Scanner(System.in);

	private InputHelper() {

	}

	/**
	 * Reads an integer from the standard input stream.
	 * 
	 * @return
	 */
	public static int readInt() {
		int result = 0;
		boolean success = false;
		
		while (!success) {
			try {
				result = scanner.nextInt();
				success = true;
			} catch (InputMismatchException e) {
				System.err.println("Wrong input. Try again.");
			}
		}
		
		return result;
	}
	
	/**
	 * Reads a float from the standard input stream.
	 * 
	 * @return
	 */
	public static float readFloat() {
		float result = 0;
		boolean success = false;
		
		while (!success) {
			try {
				result = scanner.nextFloat();
				success = true;
			} catch (InputMismatchException e) {
				System.err.println("Wrong input. Try again.");
			}
		}
		
		return result;
	}
}
