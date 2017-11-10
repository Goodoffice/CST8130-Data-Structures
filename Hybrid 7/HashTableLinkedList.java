import java.util.*;

public class HashTableLinkedList {
	public static void main(String[] args) {
		ArrayList<LinkedList<String>> hashTable = new ArrayList<LinkedList<String>>(100);

		for (int i = 0; i < 100; i++)
			hashTable.add(i, new LinkedList<String>());

		String choice = new String("1");
		Scanner in = new Scanner(System.in);

		while (choice.charAt(0) != '0') {
			System.out.println("Enter 1 to add String, 2 to find a String, 0 to quit: ");
			choice = in.next();

			if (choice.charAt(0) == '1') {
				System.out.println("Enter String to insert: ");
				String temp = in.next();
				int index = hash(temp);
				if (!search(hashTable, temp, index))
					hashTable.get(index).add(temp);
				else
					System.out.println("String " + temp + "is already in structure at index " + index);
			} else if (choice.charAt(0) == '2') {
				System.out.println("Enter String to search for: ");
				String temp = in.next();
				int index = hash(temp);
				if (search(hashTable, temp, index))
					System.out.println("String " + temp + " is in structure at index " + index);
				else
					System.out.println("String " + temp + " is not in structure at index " + index);
			}
		}

	}

	public static boolean search(ArrayList<LinkedList<String>> hashTable, String temp, int index) {
		if (hashTable.get(index).contains(temp))
			return true;
		else
			return false;
	}

	public static int hash(String temp) {
		int total = 0;
		for (int i = 0; i < temp.length(); i++)
			total += temp.charAt(i);
		return total % 100;
	}
}
