import java.util.List;
import java.util.LinkedList;

/**
 * File Name: EmailList.java
 * Student Name: Wenjing Wang
 * Course Name: Data Structure
 * Lab Section: 300
 * Date: 2016-11-06
 * Purpose: add, delete, display and return size of entry in the list, show 
 *          entries in the directory and compare with EmailList.
 *          
 * Description: This class contains two fields - a String name of the list, 
 *              and a LinkedList of EmailAddress objects.  
 */
public class EmailList {

	private String name = null;
	private List<EmailAddress> addresses = null;

	/**
	 * Parameterized constructor.
	 */
	public EmailList(String name) {
		this.name = name;
		this.addresses = new LinkedList<EmailAddress>();
	}

	/**
	 * Adds an entry to the list.
	 *
	 * @param EmailAddress
	 */
	public void addEntry(EmailAddress emailAddress) {
		addresses.add(emailAddress);
	}

	/**
	 * Removes the entry at the specified position in the list.
	 */
	public void deleteEntry(int index) {
		addresses.remove(index);
	}

	/**
	 * Displays all entries in the list.
	 */
	public void display() {
		System.out.print(name + ":[");

		for (int i = 0; i < addresses.size(); i++) {
			if (i > 0)
				System.out.println(",");
			System.out.print(addresses.get(i));
		}

		System.out.println("]");
	}

	/**
	 * Shows all entries in the directory for selection.
	 */
	public void show() {
		System.out.println(name);
		for (int i = 0; i < addresses.size(); i++) {
			System.out.println(i + " " + addresses.get(i));
		}
	}

	/**
	 * Compares the EmailList with name.
	 *
	 * @param name
	 * @return boolean
	 */
	public boolean isEqual(String name) {
		if (this.name.equals(name)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the number of entries in the list.
	 *
	 * @return the number of entries in the list
	 */
	public int size() {
		return addresses.size();
	}
}
