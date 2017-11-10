package Wenjing;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * File Name:     Bank.java
 * Student Name:  Wenjing Wang
 * Course Name:   Data Structure
 * Lab Section:   300
 * Date:          2016-10-18
 *                
 * Purpose:       This class will contain the data structure for the Bank
 *                Simulator (a dynamically allocated ArrayList) 
 *                              
 * Description:   It process to add bank accounts, display accounts info,
 *                update balances, monthly update for each account, to find 
 *                the specified account number, display account list, sort account 
 *                in numeric order, binary search account number, open, read account info
 *                from file etc. 
 *                  
 */

public class Bank {

	private static int MAXSIZE = 1000;
	private List<BankAccount> bankData = null;
	private int numAccounts = 0;
	private Scanner sc = null;

	/**
	 * Default constructor instantiate the BankAccount ArrayList and the Scanner.
	 */
	public Bank() {
		this.bankData = new ArrayList<BankAccount>();
		this.numAccounts = 0;
		this.sc = new Scanner(System.in);
	} 

	/**
	 * Shows the menu, interacts with the user for menu selection, loops till
	 * they exit.
	 */
	public void menu() {
		boolean done = false;

		while (!done) {
			System.out.println ("\nEnter your choice:  a - add new account; d - display an account;");
			System.out.println ("                    u - update balance on account; m - run month end update;" );
			System.out.print ("                    f - enter info from file; l - list accounts; q - quit: ");
			String option = null;

			while (!sc.hasNextLine())
				sc.next();

			option = sc.nextLine().toLowerCase();

			if (option.equals("a")) {
				addAccount();
			} else if (option.equals("d")) {
				System.out.println(getAccount());
			} else if (option.equals("u")) {
				updateAccount();
			} else if (option.equals("m")) {
				monthlyUpdate();
			} else if (option.equals("f")) {
				readFile();
			} else if (option.equals("l")) {
				listAccounts();
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
	 * Prompts user to enter data for an account which
	 * is added to array – either chequing or savings account
	 * added if there is room.
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
				insertAccount(account);
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
	public String getAccount() {
		int index = toFind();

		if (index == -1)
			return "Account number cannot be found";
		else
			return bankData.get(index).toString();
	}

	/**
	 * prompts user to enter which account number to update,
	 * and by how much and then updates the balance appropriately.
	 * @return
	 */
	public void updateAccount() {
		int index = toFind();

		if (index == -1) {
			System.out.println("Account number cannot be found");
		} else {
			double amount;

			System.out.print("Enter account to update (negative for withdraw, positive for deposit: ");
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
			bankData.get(index).updateBalance(amount);
		}
	}

	/**
	 * Prompts user to enter which account number they wish to find
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

		return findAccount(account);
	}

	/**
	 * process through each current account in the array 
	 * and updates the balance appropriately.
	 */
	public void monthlyUpdate() {
		for (int i = 0; i < numAccounts; i++) {
			bankData.get(i).monthlyUpdate();
		}
	}

	/**
	 * To prompt user for name of file to process, opens that file, then reads
	 * through the file and adds accounts to the array if there is room - returns
	 * false if bad data is encountered, else returns true
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
							insertAccount(account);
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
	 * returns the Scanner object if a file (name input by user) is opened,
	 * else returns null
	 * 
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

	/**
	 * To list all the bank accounts.
	 */
	public void listAccounts() {
		for (int i = 0; i < numAccounts; i++) {
			System.out.println(bankData.get(i).toString());
		}
	}

	/**
	 * To insert a new account into the lists.
	 * @param account
	 */
	private void insertAccount(BankAccount account) {
		for (int i = 0; i < numAccounts; i++) {
			BankAccount temp = bankData.get(i);

			if (temp.isEqual(account.accountNumber)) {
				// if new account is equal to current account, do nothing and return
				return;
			} else if (account.accountNumber > temp.accountNumber) {
				// if new element is greater than current account, traverse to next.
				continue;
			}
			// code reaches here if new account is smaller than current account
			// add account at this index and return.
			bankData.add(i, account);

			return;
		}

		// if end of list is reached while traversing then add new account and
		// return. (This will add account at the end of list)
		bankData.add(account);
	}

	/**
	 * To find the specified account using binary search.
	 * The lists are already sorted.
	 * @param accountNumber
	 * @return
	 */
	private int findAccount(int accountNumber) {
		if (numAccounts == 0) {
			return -1;
		}

		int low = 0;
		int high = numAccounts - 1;

		while (low <= high ) {
			int middle = (low + high) / 2;
			BankAccount temp = bankData.get(middle);

			if (accountNumber > temp.accountNumber) {
				low = middle + 1;
			} else if (accountNumber < temp.accountNumber) {
				high = middle - 1;
			} else { // The element has been found
				return middle;
			}
		}

		return -1;
	}
}
