package Wenjing;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * File Name:       SavingAccount.java
 * Student Name:    Wenjing Wang
 * Course Name:     Data Structure
 * Lab Section:     300
 * Date:            2016-10-18
 * 
 * Purpose:         This class will contain processing for the Savings Account objects for the  
 *                  Bank Simulator (a dynamically allocated ArrayList) - inherited from BankAccount
 *                  
 * Description:     It inherited from BankAccount class and contains the interestRate and 
 *                  minimumBalance member for saving account.  
 *                  
 */

public class SavingAccount extends BankAccount {
	private double interestRate;
	private double minimumBalance;

	private Scanner sc = null;

	/**
	 * Default constructor
	 */
	public SavingAccount() {
		this.sc = new Scanner(System.in);
	}

	/**
	 * Prompts user to enter data for this object from keyboard to add a new account.
	 */
	public boolean addBankAccount() {
		super.addBankAccount();

		minimumBalance = acceptDouble("Enter monthly minium balance: ");
		interestRate = acceptDouble("Enter monthly interest rate: ");

		return true;
	}

	/**
	 * To process the object with monthly update of adding interest.
	 */
	public void monthlyUpdate() {
		balance += balance * interestRate;

		System.out.printf("Adding interest of %.2f to account %d. New balance is $ %.2f", 
				interestRate, accountNumber, balance);
	}

	/**
	 * To return the data of the account formatted to display.
	 */
	public String toString() {
		return super.toString() + " minimun Balance $" + minimumBalance + " interest rate $" + interestRate;
	}

	/**
	 * Using Scanner object parameter to fill object with data- returns          
	 * false if bad data is encountered, else returns true 
	 */
	public boolean readFile(Scanner scanner) {
		boolean success = super.readFile(scanner);

		if (success) {
			try {
				interestRate = scanner.nextDouble();
				minimumBalance = scanner.nextDouble();

				return true;
			} catch (InputMismatchException e) {
				return false;
			}
		}

		return success;
	}
}
