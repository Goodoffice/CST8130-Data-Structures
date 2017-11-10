package Wenjing;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * File Name:       ChequingAccount.java
 * Student Name:    Wenjing Wang
 * Course Name:     Data Structure
 * Lab Section:     300
 * Date:            2016-10-18
 * 
 * Purpose:         This class will contain processing for the  Chequing Account objects for the  
 *                  Bank Simulator (a dynamically allocated ArrayList) - inherited from BankAccount
 *                  
 * Description:     It inherited from BankAccount class and contains the monthDeducted member for chequing account.  
 * 
 */

public class ChequingAccount extends BankAccount {
	private double monthDeducted;

	private Scanner sc = null;

	/**
	 * Default constructor
	 */
	public ChequingAccount() {
		this.sc = new Scanner(System.in);
	}

	/**
	 * Prompts user to enter data for this object from keyboard to add a new account.
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
		balance -= monthDeducted;

		System.out.printf("Deducting fee of $%.2f from account %d. New balance is $ %.2f", monthDeducted, accountNumber, balance);
	}

	/**
	 * To return the data of the account formatted to display.
	 */
	public String toString() {
		return super.toString() + " monthly fee $" + monthDeducted;	
	}

	/**
	 * Using Scanner object parameter to fill object with data- returns          
	 * false if bad data is encountered, else returns true 
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
