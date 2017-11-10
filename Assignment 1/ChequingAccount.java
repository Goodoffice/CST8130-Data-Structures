package Wenjing;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * File Name: ChequingAccount.java
 * Student Name: Wenjing Wang
 * Course Name: Data Structure
 * Lab Section: 300
 * Date: 2016-09-22
 * Description: It inherited from BankAccount class and contains
 * the monthDeducted member for chequing account to operate chequingAccount.  
 */
public class ChequingAccount extends BankAccount {
	private double monthDeducted;

	/**
	 * Default constructor
	 */
	public ChequingAccount() {

	}

	/**
	 * Prompts user to enter data to add a new chequing account.
	 */
	public boolean addBankAccount() {
		super.addBankAccount();

		monthDeducted = acceptDouble("Enter monthly fee: ");

		return true;
	}

	/**
	 * To process the object with monthly update of withdrawing the fee.
	 */
	public void monthlyUpdate() {
		if (balance > monthDeducted) {
			balance -= monthDeducted;

			System.out.printf("\nDeducting fee of $%.2f from account %d. New balance is $ %.2f", monthDeducted, accountNumber, balance);
		} else {
			System.out.println("No enough balance!");
		}
	}

	/**
	 * To return the data of the account formatted to display.
	 */
	public String toString() {
		return super.toString() + " monthly fee $" + monthDeducted;	
	}

	/**
	 * To use Scanner to read data from file of saving account.
	 */
	public boolean readFile(Scanner scanner) {
		boolean success = super.readFile(scanner);

		if (success) {
			try {
				monthDeducted = scanner.nextDouble();

				return true;
			} catch (InputMismatchException e) {
				return false;
			}
		}

		return success;
	}
}
