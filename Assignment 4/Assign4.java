import java.util.Scanner;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * File Name: Assign4.java
 * Student Name: Wenjing Wang
 * Course Name: Data Structure
 * Lab Section: 300
 * Date: 2016-12-05
 * Purpose: This class is to display a menu of a tree dictionary of words.
 * Description: This class contains the main method and displays the menu. 
 * 			    
 */

public class Assign4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Dictionary dic = new Dictionary();

		boolean done = false;

		while (!done) {
			System.out.println("Enter 1 to clear dictionary,");
			System.out.println("2 to add text from keyboard,");
			System.out.println("3 to add text from a file,");
			System.out.println("4 to search for a word count,");
			System.out.println("5 to display number of nodes,");
			System.out.println("6 to quit");

			String option = null;

			while (!sc.hasNextLine()) {
				sc.next();
			}

			option = sc.nextLine().toLowerCase();

			if (option.equals("1")) {
				dic.clearDictionary();
			} else if (option.equals("2")) {
				dic.addText();
			} else if (option.equals("3")) {
				dic.readFile();
			} else if (option.equals("4")) {
				dic.search();
			} else if (option.equals("5")) {
				dic.displayNodes();
			} else if (option.equals("6")) {
				System.out.println("Quit");
				done = true;
			} else {
				System.out.println("Invalid option, please try again.");
			}

			System.out.println();
		}
	}


}
