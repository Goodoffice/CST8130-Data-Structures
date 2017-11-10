import java.util.ArrayList;
import java.util.Scanner;

public class HashTableArrayListVersion2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> hashTable = new ArrayList<String>();

		for (int i = 0; i < 100; i++) {
			hashTable.add(i, null);
		}

		String choice = new String("1");

		while (choice.charAt(0) != '0') {
			System.out.println("Enter 1 to add, 2 to search, 3 to delete");
			choice = sc.nextLine();

			if (choice.charAt(0) == '1') {
				System.out.println("Enter string to add");
				String temp = sc.nextLine();

				int index = hash(temp);

				if (hashTable.get(index) == null) {

					hashTable.set(index, temp);
				} else {
					System.out.println("The string " + temp + " is added in the index" + index);
				}

			} else if (choice.charAt(0) == '2') {
				System.out.println("Enter string to search");
				String temp = sc.nextLine();

				int index = hash(temp);

				if (hashTable.get(index) == null) {
					System.out.println("String is not in the hashtable\n");
				} else {
					if (hashTable.get(index).equals(temp))
						System.out.println("String " + temp + " is in structure at index " + index);
					else
						System.out.println("String " + temp + " is not in structure at index " + index);
				}

			} else if (choice.charAt(0) == '3') {
				System.out.println("Enter string to delete");
				String temp = sc.nextLine();

				int index = hash(temp);

				if (hashTable.get(index) == null) {
					System.out.println("String is not in the hashTable, nothing to delete");
				} else {
					if (hashTable.get(index).equals(temp)) {
						hashTable.set(index, null);
					}
				}

			}
		}

		System.out.println("Quit");

	}

	public static int hash(String data) {
		int total = 0;
		for (int i = 0; i < data.length(); i++) {
			total += data.charAt(i);
		}

		return total % 100;
	}

}
