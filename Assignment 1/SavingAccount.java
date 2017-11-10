package Wenjing;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * File Name: SavingAccount.java
 * Student Name: Wenjing Wang
 * Course Name: Data Structure
 * Lab Section: 300
 * Date: 2016-09-22
 * Description: It inherited from BankAccount class and contains
 * the interestRate and minimumBalance member for saving account
 * to operate savingAccount.  
 */
public class SavingAccount extends BankAccount {
	private double interestRate;
	private double minimumBalance;

	/**
	 * Default constructor
	 */
	public SavingAccount() {

	}

	/**
	 * Prompts user to enter data to add a new saving account.
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

		System.out.printf("\nAdding interest of %.2f to account %d. New balance is $ %.2f", 
				interestRate, accountNumber, balance);
	}

	/**
	 * To return the data of the account formatted to display.
	 */
	public String toString() {
		return super.toString() + " minimun Balance $" + minimumBalance + " interest rate $" + interestRate;
	}

	/**
	 * To use Scanner to read data from file of saving account.
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
