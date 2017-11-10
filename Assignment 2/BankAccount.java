package Wenjing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * File Name:       BankAccount.java
 * Student Name:    Wenjing Wang
 * Course Name:     Data Structure
 * Lab Section:     300
 * Date:            2016-10-18
 * 
 * Purpose:         This class will contain the base objects for the Bank Simulator (a 
 *                  dynamically allocated ArrayList)
 *                  
 * Description:     It is the base class and contains the common data members 
 *                  for all Bank Accounts.
 */

public abstract class BankAccount {
	protected int accountNumber;
	protected String firstName = null;
	protected String lastName = null;
	protected double balance;

	private Scanner sc = null;

	/**
	 * Default constructor
	 */
	public BankAccount() {
		this.sc = new Scanner(System.in);
	}

	/**
	 * Prompts user to enter data for this object from keyboard.
	 * @return
	 */
	public boolean addBankAccount() {
		System.out.print("Enter account number: ");
		while (true) {
			try {
				int i = sc.nextInt();

				sc.nextLine();

				String str = Integer.toString(i);
				if (str.length() <= 8) {
					accountNumber = i;
					break;
				} else {
					System.err.println("Please enter an integer up to 8 digits long");
				}
			} catch (InputMismatchException e) {
				System.err.println("Please enter an integer");
				sc.nextLine();
			}
		}

		firstName = acceptString("Enter customer first name: ");
		lastName = acceptString("Enter customer last name: ");
		balance = acceptDouble("Enter balance: ");

		return true;
	}

	/**
	 * To compare the account with accountNumber.
	 * @param account
	 * @return
	 */
	public boolean isEqual(int account) {
		if (accountNumber == account) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * To compare the b with balance.
	 * @param b
	 * @return
	 */
	public boolean isGreater(double b) {
		if (balance == b) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * To update the balance in the object.
	 * @param amount
	 */
	public void updateBalance(double amount) {
		if (this.balance + amount < 0) {
			System.out.println("Sorry, you have no enough money to withdrawal.");
		} else {
			this.balance += amount;
		}

		System.out.println("Account updated");
	}

	/**
	 * To process the object with monthly update(empty for base class).
	 */
	public void monthlyUpdate() {
	}

	public boolean readFile(Scanner scanner) {
		try {
			accountNumber = scanner.nextInt();
			firstName = scanner.next();
			lastName = scanner.next();
			balance = scanner.nextDouble();

			return true;
		} catch (InputMismatchException e) {
			return false;
		}
	}

	/**
	 * Return String representation of BankAccount common data members.
	 */
	@Override
	public String toString() {
		return "Account: " + accountNumber + " " + firstName + " " + lastName + " Balance $" + balance;
	}

	/**
	 * To handle the incorrect value of String.
	 * @param prompt
	 * @return
	 */
	protected String acceptString(String prompt) {
		String value = null;

		System.out.print(prompt);

		while (true) {
			while (!sc.hasNextLine())
				sc.next();
			value = sc.nextLine().trim();
			if (!value.equals(""))
				break;
		}

		return value;
	}


	/**
	 * To handle the exception that the balance entry has incorrect value.
	 * @param prompt
	 * @return
	 */
	protected double acceptDouble(String prompt) {
		double value;

		System.out.print(prompt);

		while (true) {
			try {
				value = sc.nextDouble();
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.err.println("Please enter a double");
				sc.nextLine();
			}
		}

		return value;
	}
}
