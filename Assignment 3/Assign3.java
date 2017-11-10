import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * File Name: Assign3.java
 * Student Name: Wenjing Wang
 * Course Name: Data Structure
 * Lab Section: 300
 * Date: 2016-11-06
 * Purpose:  The class is the driver class for Assignment 3
 * Description: This class contains the main method and displays the menu. 
 */
public class Assign3 {
	private Scanner sc = new Scanner(System.in);
	private Directory directory = new Directory();

	public static void main(String[] args) {
		Assign3 assign3 = new Assign3();
		assign3.menu();
	}

	/**
	 * Shows the menu, interacts with the user for menu selection, loops till
	 * they exit.
	 */
	public void menu() {
		boolean done = false;

		while (!done) {
			System.out.println("Enter c to create a new list");
			System.out.println("      p to display all the email lists");
			System.out.println("      a to add an entry to a list");
			System.out.println("      d to delete an entry from a list");
			System.out.println("      l to display a list");
			System.out.println("      f to load lists from file");
			System.out.print("      q to quit: ");

			String option = null;

			while (!sc.hasNextLine()) {
				sc.next();
			}

			option = sc.nextLine().toLowerCase();

			if (option.equals("c")) {
				createList();
			} else if (option.equals("p")) {
				displayAllLists();
			} else if (option.equals("a")) {
				addEntryToList();
			} else if (option.equals("d")) {
				deleteEntryFromList();
			} else if (option.equals("l")) {
				displaySingleList();
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
	 * Prompts user to enter data for a new list.
	 */
	private void createList() {
		String name = enterName("Enter the name of the list: ");
		EmailList emailList = findEmailList(name);

		if (emailList == null) {
			emailList = new EmailList(name);
			enterEmailAddress(emailList);
			directory.addEmailList(emailList);
		} else {
			System.out.println("The EmailList with the name already exist.");
		}
	}

	/**
	 * Displays all EmailLists in the directory.
	 */
	private void displayAllLists() {
		directory.display();
	}

	/**
	 * Prompts user to enter the name of the EmailList and displays the list.
	 */
	private void displaySingleList() {
		String name = enterName("Enter name of list to display: ");
		EmailList emailList = findEmailList(name);

		if (emailList != null) {
			emailList.display();
		} else {
			System.out.println("The EmailList does not exist.");
		}
	}

	/**
	 * Prompts user to enter the name of the EmailList and adds an EmailAddress to the list.
	 */
	private void addEntryToList() {
		String name = enterName("Enter name of list to add to: ");
		EmailList emailList = findEmailList(name);

		if (emailList != null) {
			EmailAddress emailAddress = new EmailAddress();
			emailAddress.addAddress(sc, "y");
			emailList.addEntry(emailAddress);
			sc.nextLine();
		} else {
			System.out.println("The EmailList does not exist.");
		}
	}

	/**
	 * Prompts user to enter the name of the EmailList and deletes the list.
	 */
	private void deleteEntryFromList() {
		String name = enterName("Enter name of list to delete from: ");
		EmailList emailList = findEmailList(name);

		if (emailList != null) {
			int count = emailList.size();

			if (count > 0) {
				emailList.show();

				int index = -1;

				while (true) {
					System.out.print("Enter entry number to delete: ");
					try {
						index = sc.nextInt();
						sc.nextLine();
						break;
					} catch (InputMismatchException ex) {
						System.err.println("Please enter an integer");
						sc.nextLine();
					}
				}

				if (index >= 0 && index < count) {
					emailList.deleteEntry(index);
				} else {
					System.out.println("The entry number is out of range.");
				}
			} else {
				System.out.println("The EmailList is empty.");
			}
		} else {
			System.out.println("The EmailList does not exist.");
		}
	}

	/**
	 * Reads in EmailLists from a file.
	 */
	private void readFile() {
		String filename = null;

		System.out.print("Enter name of file to process: ");

		while (true) {
			while (!sc.hasNextLine()) {
				sc.next();
			}

			filename = sc.nextLine().trim();

			if (!filename.equals("")) {
				break;
			}
		}

		Scanner scanner = openFile(filename);

		if (scanner != null) {
			// Read the line count.
			int totalLines = 0;

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();

				if (!line.equals("")) {
					try {
						totalLines = Integer.parseInt(line);

						if (totalLines <= 0) {
							System.out.println("The total lines must be a positive integer: " + line);
							return;
						}

						break;
					} catch (NumberFormatException ex) {
						System.out.println("Cannot find the total lines: " + line);
						return;
					}
				}
			}

			int lineCount = 0;

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();

				if (!line.equals("")) {
					lineCount++;

					Scanner s = new Scanner(line).useDelimiter(" ");
					String name = s.next();
					int numberOfEmailAddresses = s.nextInt();
					EmailList emailList = new EmailList(name);

					for (int i = 0; i < numberOfEmailAddresses; i++) {
						emailList.addEntry(new EmailAddress(s.next()));
					}
					directory.addEmailList(emailList);

					if (lineCount >= totalLines) {
						break;
					}
				}
			}

			scanner.close();
		} else {
			System.out.println(filename + " not found");
		}
	}

	/**
	 * Prompts user to enter a name that represents the EmailList 
	 * and returns the name.
	 *
	 * @return String
	 */
	private String enterName(String prompt) {
		String name = null;
		boolean done = false;

		while (!done) {
			System.out.print(prompt);

			while (!sc.hasNextLine()) {
				sc.next();
			}

			name = sc.nextLine().trim();

			if (!name.equals("")) {
				done = true;
			}
		}

		return name;
	}

	private void enterEmailAddress(EmailList emailList) {
		boolean done = false;
		EmailAddress emailAddress = null;

		while (!done) {
			emailAddress = new EmailAddress();
			emailAddress.addAddress(sc, "y");
			emailList.addEntry(emailAddress);

			sc.nextLine();

			System.out.print("Another? y/n: ");

			while (!sc.hasNextLine()) {
				sc.next();
			}

			String option = sc.nextLine().toLowerCase();

			if (option.equals("y")) {
				continue;
			} else if (option.equals("n")) {
				done = true;
			} else {
				System.out.println("Invalid option, please try again.");
			}
		}
	}

	/**
	 * Finds the specified EmailList for the given name.
	 *
	 * @return EmailList
	 */
	private EmailList findEmailList(String name) {
		return directory.findEmailList(name);
	}

	private Scanner openFile(String filename) {
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
