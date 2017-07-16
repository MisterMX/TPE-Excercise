package de.hs_mannheim.tpe.sose17.exercise.aufgabe1;

/**
 * Abstract class for every drink. Contain name and price of a drink.
 * @author Max Soest & Maximilian Blatt
 *
 */
public abstract class Drink {
	
	protected String name;
	protected double price;
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
}
