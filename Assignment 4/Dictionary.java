import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * File Name: Dictionary.java
 * Student Name: Wenjing Wang
 * Course Name: Data Structure
 * Lab Section: 300
 * Date: 2016-12-05
 * Purpose: This class is to build a tree dictionary of words.
 * Description: 
 * 			    The clearDictionary() method to reset the tree to empty.
 *              The addText() method to prompt user to add text from keyboard.
 *              The search() method to search for a word count.
 *              The displayNodes() method to display number of nodes in the file.
 *              The openFile() and readFile() method to add text from a file.
 */
public class Dictionary {
	private Scanner sc = new Scanner(System.in);
	private TreeMap<String, Integer> map = new TreeMap<String, Integer>();

	/**
	 * Clears the dictionary.
	 */
	public void clearDictionary() {
		map.clear();
		System.out.println("The dictionary has been reset to empty.");
	}

	/**
	 * Prompts user to enter text and adds words to the dictionary.
	 */
	public void addText() {
		String text = enterString("Enter text you want to add: ");
		int count = addWords(text);
		System.out.printf("Number of words added: %d\n", count);
	}

	/**
	 * Prompts user to enter a word and searches for the word count.
	 */
	public void search() {
		String word = enterString("Enter word to search for: ");
		word = word.replaceAll("[^A-Za-z]", "");
		Integer value = map.get(word.replaceAll("[^A-Za-z]", "").toLowerCase());

		if (value == null) {
			System.out.printf("%s not found\n", word);
		} else if (value == 1) {
			System.out.printf("%s occurs one time\n", word);
		} else {
			System.out.printf("%s occurs %d times\n", word, value);
		}
	}

	/**
	 * Displays number of nodes in the dictionary.
	 */
	public void displayNodes() {
		int size = map.size();

		if (size == 0) {
			System.out.printf("The dictionary is empty\n");
		} else if (size == 1) {
			System.out.printf("There is only one node\n");
		} else {
			System.out.printf("There are %d nodes\n", size);
		}
	}

	/**
	 * Reads in words from a file.
	 */
	public void readFile() {
		String file = null;

		System.out.print("Enter name of file to process: ");

		while (true) {
			while (!sc.hasNextLine()) {
				sc.next();
			}

			file = sc.nextLine().trim();

			if (!file.equals("")) {
				break;
			}
		}

		Scanner scan = openFile (file);

		if (scan != null) {
			while (scan.hasNextLine()) {
				String line = scan.nextLine().trim();

				if (!line.equals("")) {
					addWords(line);
				}
			}

			scan.close();
		} else {
			System.out.println(file + " not found");
		}
	}

	/**
	 * To open a file.
	 */
	public Scanner openFile (String filename) {
		File file = new File (filename);

		if (file.exists()) {
			try {
				Scanner scan = new Scanner(file);

				return scan;
			} catch (FileNotFoundException e) {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Prompts user to add words.
	 *
	 */
	private int addWords(String text) {
		String[] words = text.toLowerCase().split(" ");
		int count = 0;

		for (String word : words) {
			word = word.replaceAll("[^A-Za-z]", "");

			if (word.equals(""))
				continue;

			Integer value = map.get(word);

			if (value == null) {
				value = new Integer(1);
			} else {
				value = new Integer (value.intValue() + 1);
			}
			map.put(word, value);
			count++;

		}

		return count;
	}

	/**
	 * Prompts user to enter a string and returns it.
	 * @return String
	 */
	private String enterString(String value) {
		String sth = null;
		boolean done = false;

		while (!done ){
			System.out.println(value);

			while (!sc.hasNextLine())
				sc.next();

			sth = sc.nextLine().trim();

			if (!sth.equals("")) 
				done = true;
		}

		return sth;
	}
}
