package de.hs_mannheim.tpe.sose17.exercise.aufgabe1;

import java.util.Scanner;

public class DrinksDispenser {
	
	double mustPay = 0;
	double hadPay = 0;
	Drink currentDrink;
	boolean weakDrink = false;
	boolean coldDrink = false;
	Scanner in;
	
	/**
	 * Start drink dispenser process to get a drink
	 */
	public void chooseDrink(){
		in = new Scanner(System.in);
		System.out.println("-----------------------------------------------------------");
		System.out.println("Choose a drink!");
		System.out.println("1. Black tea");
		System.out.println("2. Cappuccino");
		System.out.println("3. Latte Macciato");
		
		int i = in.nextInt();

		//Create selected drink object
		switch(i){
			case 1 : currentDrink = new BlackTea(); break;
			case 2 : currentDrink = new Cappuccino();break;
			case 3 : currentDrink = new LatteMacciato(); break;
		}
		
		mustPay = currentDrink.getPrice();
		System.out.println("You have choose " + currentDrink.getName());
		
		chooseStrengthOfDrink();
	}
	
	/**
	 * Select strength of the drink. After this task the program end or start {@link DrinksDispenser#chooseTemperature()}
	 */
	private void chooseStrengthOfDrink(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("Select strength of your " +  currentDrink.getName());
		System.out.println("1: strehgth");
		System.out.println("2: weak");
		System.out.println("Everything else : cancel");
		
		int i = in.nextInt();
		
		
		if(i == 1){
			weakDrink = false;
			chooseTemperature();
		}
		else if(i == 2){
			weakDrink = true;
			chooseTemperature();
		}
		else{
			System.out.println("process cancel");
		}
	}
	
	/**
	 * select temperature of the drink. After this task the process end or start {@link DrinksDispenser#pay()}
	 */
	private void chooseTemperature(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("Select temperature of your " +  currentDrink.getName());
		System.out.println("1: hot");
		System.out.println("2: cold");
		System.out.println("Everything else : cancel");
		
		int i = in.nextInt();
		
		if(i == 1){
			coldDrink = false;
			pay();
		}
		else if(i == 2){
			coldDrink = true;
			pay();
		}
		else{
			System.out.println("process cancel");
		}
	}
	
	/**
	 * Start pay process of the drink order process. After this task the user get his drink or the program cancel
	 */
	private void pay(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("Please add money to the dispenser");
		System.out.println("A: 2€");
		System.out.println("B: 1€");
		System.out.println("C: 50ct");
		System.out.println("D: 20ct");
		System.out.println("E: 10ct");
		System.out.println("Everything else : cancel");
		
		while(hadPay < mustPay){
			String moneyString = in.next();
			double money;
			
			switch( moneyString.toUpperCase()){
			case "A": money = 2;break;
			case "B": money = 1;break;
			case "C": money = 0.5;break;
			case "D": money = 0.2;break;
			case "E": money = 0.1;break;
			default: money = -1;
			}
			
			if(money > 0){
				if(money == 2 || money == 1 || money == 0.5 | money == 0.2 || money == 0.1){
					hadPay += money;
					if(hadPay < mustPay ){
						System.out.println("You must pay " + (mustPay - hadPay) + "€ anymore");
						System.out.println("Had pay: " + hadPay);
					}
				}
				else{
					System.out.println("The dispenser don't now the coint " + money);
				}
			}
			else{
				System.out.println("Cancel");
				if(hadPay > 0)
					payBack();
				break;
			}
		}
		if(hadPay >= mustPay){
			System.out.println("Here is your drink!");
			System.out.print("A ");
			
			if(coldDrink) System.out.print("cold ");
			else System.out.print("hot ");
			
			if(weakDrink) System.out.print("weak ");
			else System.out.print("strength ");
			
			System.out.println(currentDrink.getName());
			
			System.out.println("HadPayEnd: " + hadPay + ", mustPay: "+ mustPay);
			hadPay = hadPay - mustPay;
			if(hadPay > 0){
				payBack();
			}
			mustPay = 0;
			System.out.println("HadPayEnd: " + hadPay);
		}
		
	}
	
	/**
	 * Give current credit back to the user
	 */
	private void payBack(){
		System.out.println("You get back:");
		while(hadPay > 0){
			if(hadPay >= 2){
				System.out.println("2€ back");
				hadPay -= 2;
			}
			else if( hadPay >= 1){
				System.out.println("1€ back");
				hadPay -= 1;
			}
			else if( hadPay >= 0.5){
				System.out.println("50 cent back");
				hadPay -= 0.5;
			}
			else if( hadPay >= 0.2){
				System.out.println("20 cent back");
				hadPay -= 0.2;
			}
			else if(hadPay >= 0.1){
				System.out.println("10 cent back");
				hadPay -= 0.1;
			}
			else{
				hadPay = 0;
			}
		}
		
	}

}
