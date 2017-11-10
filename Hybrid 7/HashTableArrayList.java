import java.util.ArrayList;
import java.util.Scanner;

public class HashTableArrayList {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		ArrayList<String> dataItem = new ArrayList<String>();

		for (int i = 0; i < 100; i++) {
			dataItem.add(i, null);
		}

		String choice = "1";

		while (choice.charAt(0) != '0') {
			System.out.println("Enter 1 to add String, 2 to find a String,\n3 to delete, 0 to quit: ");
			choice = in.next();

			// add a string to array
			if (choice.charAt(0) == '1') {
				System.out.println("Enter String to add: ");
				String temp = in.next();

				// use hash algorithm to calculate the index
				int index = hash(temp);

				if (dataItem.get(index) == null) {
					dataItem.set(index, temp);
					System.out.println("String was placed at index " + index + "\n");
				} else {
					boolean done = false;

					for (int i = index + 1; i < 100; i++) {
						if (dataItem.get(i) == null) {
							done = true;
							dataItem.set(i, temp);
							System.out.println("String was placed at sequential position at index \n" + i + "\n");
							break;
						}
					}
					if (!done) {
						System.out.println("String cannot be placed!");
					}
				}

			} else if (choice.charAt(0) == '2') { // search for a string in the
													// array

				System.out.println("Enter String to search for: ");
				String temp = in.next();

				int index = hash(temp);

				if (dataItem.get(index) == null) {
					System.out.println("String is not in the hashtable\n");
				} else {
					boolean done = false;
					for (int i = index; i < 100; i++) {
						if (dataItem.get(i) == null)
							break;
						if (dataItem.get(i).equals(temp)) {
							System.out.println("String " + temp + " is in array at index " + i + "\n");
							done = true;
							break;
						}
					}
					if (!done) {
						System.out.println("String not found");
					}
				}
			} else if (choice.charAt(0) == '3') { // delete a string in the
													// array

				System.out.println("Enter string to delete: ");
				String temp = in.next();

				int index = hash(temp);

				if (dataItem.get(index) == null) {
					System.out.println("The array is empty, nothing to delete.\n");
				} else {
					boolean done = false;
					for (int i = index; i < 100; i++) {
						if (dataItem.get(i) == null)
							break;
						if (dataItem.get(i).equals(temp)) {
							dataItem.set(index, null);
							System.out.println("string " + temp + " in the index " + i + " is already deleated.\n");
							done = true;
							break;
						}
					}
					if (!done) {
						System.out.println("String not exist in the array");
					}
				}

			}
		}

		System.out.println("quit");

	}

	public static int hash(String temp) {
		// // first letter of the string converted to an int.
		int a = (int) (temp.charAt(0));
		int b = 0;

		// second letter of the string if there is one
		if (temp.length() > 1)
			b = (int) (temp.charAt(1));

		// first letter add second letter modulus 100
		return (a + b) % 100;
	}
}
