import java.util.List;
import java.util.ArrayList;

/**
 * File Name: Directory.java
 * Student Name: Wenjing Wang
 * Course Name: Data Structure
 * Lab Section: 300
 * Date: 2016-11-06
 * Purpose: add, display and search EmailList in the directory.
 * Description: This class holds an ArrayList of EmailList objects.  
 */
public class Directory {

	private List<EmailList> list = null;

	/**
	 * Default constructor.
	 */
	public Directory() {
		this.list = new ArrayList<EmailList>();
	}

	/**
	 * Adds an EmailList to the directory.
	 *
	 * @param EmailList
	 */
	public void addEmailList(EmailList emailList) {
		list.add(emailList);
	}

	/**
	 * Displays all EmailLists in the directory.
	 */
	public void display() {
		System.out.println("The email lists are: ");
		for (EmailList emailList: list) {
			emailList.display();
		}
	}

	/**
	 * Finds the specified EmailList for the given name.
	 *
	 * @return EmailList
	 */
	public EmailList findEmailList(String name) {
		for (EmailList emailList: list) {
			if (emailList.isEqual(name)) {
				return emailList;
			}
		}
		return null;
	}
}
