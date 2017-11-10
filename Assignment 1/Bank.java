package Wenjing;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;

/**
 * File Name: Bank.java
 * Student Name: Wenjing Wang
 * Course Name: Data Structure
 * Lab Section: 300
 * Date: 2016-09-22
 * Description: It contains the array of BankAccount objects
 * (which are instantiated with either SavingAccount
 * or ChequingAccount objects).  
 */
public class Bank {

	private static int MAXSIZE = 1000;
	private BankAccount[] bankData = null;
	private int numAccounts = 0;
	private Scanner sc = null;

	/**
	 * Default constructor to allocate default size.
	 */
	public Bank() {
		this.bankData = new BankAccount[MAXSIZE];

		for (int i = 0; i < MAXSIZE; i++) {
			this.bankData[i] = null;
		}

		this.numAccounts = 0;
		this.sc = new Scanner(System.in);
	}

	/**
	 * Shows the menu, interacts with the user for each selection.
	 */
	public void menu() {
		boolean done = false;

		while (!done) {
			System.out.print("Enter your choice: a - add new account; "
					+ "d - display an account; u - update balance on account; "
					+ "m - run month end update; f - enter info from file " + "q - quit: ");

			String option = null;

			while (!sc.hasNextLine())
				sc.next();

			option = sc.nextLine().toLowerCase();

			if (option.equals("a")) {
				addAccount();
			} else if (option.equals("d")) {
				System.out.println(toString());
			} else if (option.equals("u")) {
				update();
			} else if (option.equals("m")) {
				monthlyUpdate();
			} else if (option.equals("f")) {
				readFile();
			} else if (option.equals("q")) {
				System.out.println("Quit");
				done = true;
			} else {
				System.out.println("Invalid option, please try again.");
			}
			System.out.println();
		}
	}

	/**
	 * Prompts user to enter data for an account – chequing or savings
	 * account added if there is room.
	 * @return
	 */
	public boolean addAccount() {
		if (numAccounts == MAXSIZE) {
			System.out.println("The maxmium number of accounts is already added, so there is no room.");
		} else {
			boolean done = false;
			BankAccount account = null;

			while (!done) {
				System.out.print("Enter an s for Saving Account or c for Chequing Account: ");

				while (!sc.hasNextLine())
					sc.next();

				String option = sc.nextLine().toLowerCase();

				if (option.equals("c")) {
					// chequing account
					account = new ChequingAccount();
					done = true;
				} else if (option.equals("s")) {
					// saving account
					account = new SavingAccount();
					done = true;
				} else {
					System.out.println("Invalid option, please try again.");
				}
			}

			boolean added = account.addBankAccount();

			if (added) {
				bankData[numAccounts] = account;
				numAccounts++;
			}
			else
			{
				System.out.println("Account is not added");
			}
		}

		return true;
	}

	/**
	 * prompts user to enter an account number to display,
	 * then returns data formatted to display or an error message.
	 */
	public String toString() {
		int index = toFind();

		if (index == -1)
			return "Account number cannot be found";
		else
			return bankData[index].toString();
	}

	/**
	 * prompts user to enter account number to update,
	 * and by how much and then updates the balance appropriately.
	 * @return
	 */
	public String update() {
		int index = toFind();

		if (index == -1) {
			System.out.println("Account number cannot be found");
		} else {
			double amount;

			System.out.print("Enter amount to update (negative for withdraw, positive for deposit): ");
			while (true) {
				try {
					amount = sc.nextDouble();
					sc.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.err.println("Please enter a double");
					sc.nextLine();
				}
			}
			bankData[index].updateBalance(amount);
		}
		return null;
	}

	/**
	 * Prompts user to enter account number they wish to find
	 * and returns array index of where it is found.
	 * @return
	 */
	public int toFind() {
		int account;

		System.out.print("Enter account number to find: ");
		while (true) {
			try {
				account = sc.nextInt();
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.err.println("Please enter an integer");
				sc.nextLine();
			}
		}

		for (int i = 0; i < numAccounts; i++) {
			if (bankData[i].isEqual(account))
				return i;
		}

		return -1;
	}

	/**
	 * process through each current account in the array 
	 * and updates the balance appropriately.
	 */
	public void monthlyUpdate() {
		for (int i = 0; i < numAccounts; i++) {
			bankData[i].monthlyUpdate();
		}
	}

	/**
	 * Prompts user for name of file to process and read data from the file.
	 * @return
	 */
	public boolean readFile() {
		String filename = null;

		System.out.print("Enter name of file to process: ");

		while (true) {
			while (!sc.hasNextLine())
				sc.next();
			filename = sc.nextLine().trim();
			if (!filename.equals(""))
				break;
		}

		Scanner scanner = openFile(filename);
		if (scanner != null) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				Scanner s = new Scanner(line).useDelimiter(" ");
				String accountType = s.next();

				BankAccount account = null;

				if (accountType.equals("c")) {
					account = new ChequingAccount();
				} else if (accountType.equals("s")) {
					account = new SavingAccount();
				} else {
					System.out.println("Invalid account type - " + accountType);
				}

				if (account != null) {
					boolean success = account.readFile(s);
					if (success) {
						if (numAccounts < MAXSIZE) {
							bankData[numAccounts] = account;
							numAccounts++;
						} else {
							System.out.println("The maxmium number of accounts is already added.");
						}
					}
				}
			}

			scanner.close();

			return true;
		} else {
			System.out.println(filename + " not found");
			return false;
		}
	}

	/**
	 * To use Scanner to return the data in the file.
	 * @param filename
	 * @return
	 */
	public Scanner openFile(String filename) {
		File file = new File(filename);
		if (file.exists()) {
			try {
				Scanner scanner = new Scanner(file);
				return scanner;
			} catch (FileNotFoundException e) {
				return null;
			}
		} else {
			return null;
		}
	}
}
