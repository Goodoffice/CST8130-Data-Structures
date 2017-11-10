import java.util.InputMismatchException;
import java.util.Scanner;

public class HashTable {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] dataItem = new String[100];
		
		for (int i = 0; i < 100; i++) {
			dataItem[i] = null;
		}
		
		boolean done = false;
		while (!done) {
			try {
				System.out.println("Enter a - add a string to array\n" + "      s - search a string in the array\n"
						+ "      d - delete a string in the array\n" + "      q - quit");
				while (!sc.hasNextLine())
					sc.next();
				
				String option;
				option = sc.nextLine().toLowerCase();
				
				if (option.equals("a")) {
					System.out.println("Enter string to add: ");
					String temp = sc.nextLine();
					
					int index = hash(temp);
					
					if (dataItem[index] == null) {
						dataItem[index] = temp;
						System.out.printf("String placed into array at position %d\n", index);
					} else {
						boolean dataOk = false;
						for (int i = index + 1; i < 100; i++) {
							if (dataItem[i] == null) {
								dataOk = true;
								dataItem[i] = temp;
								System.out.printf("String placed into array at position %d\n", index);
								break;
							}
						}
					}
				} else if (option.equals("s")) {
					System.out.println("Enter a string to search for: ");
					String temp = sc.nextLine();
					
					int index = hash(temp);
					
					if (dataItem[index] == null) {
						System.out.println("String is not in the hashtable");
					} else {
						boolean dataOk = false;
						for (int i = index; i < 100; i++) {
							if (dataItem[i] == null) 
								break;
							if (dataItem.equals(temp)) {
								System.out.println("String " + temp + " is in the position " + i);
								dataOk = true;
								break;
							}
						}
						if (!dataOk) 
							System.out.println("String is not in the table");
					}
					
				} else if (option.equals("d")) {
					System.out.println("Enter a string to delete: ");
					String temp = sc.nextLine();

					int index = hash(temp);
					
					dataItem[index] = null;
				} else if (option.equals("q")) {
					done = true;
					System.out.println("quit");

				} else {
					System.out.println("Invalid option, please try again.");
				}

				System.out.println();
				
			}catch (InputMismatchException e) {
				System.err.println("Please enter correct data type for menu selection");
				sc.nextLine();
			}
		}

	}
	
	public static int hash(String temp) {
		int a = (int) (temp.charAt(0));
		int b = 0;
		
		if (temp.length() > 1) {
			b = (int) (temp.charAt(1));
		}
		return (a + b) % 100;
	}

}
