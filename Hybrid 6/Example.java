import java.util.Scanner;
import java.util.InputMismatchException;

public class Example {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DLList list = new DLList();

		boolean done = false;

		while (!done) {
			try {
				System.out.println("Enter a to add elements to list\n" + "enter s to search and delete,\n"
						+ "enter w to delete at head,\n" + "enter h to display from the head,\n"
						+ "enter t to display from tail\n" + "enter p to add from tail\n" + "enter q to quit:");

				String option = null;

				while (!sc.hasNextLine())
					sc.next();

				option = sc.nextLine().toLowerCase();

				if (option.equals("a")) {
					System.out.println("Enter string to add into list");
					String name = sc.nextLine();
					list.addAtHead(name);

				} else if (option.equals("p")) {
					System.out.println("Enter string to add from tail to list ");
					String name = sc.nextLine();
					list.addAtTail(name);

				} else if (option.equals("h")) {
					System.out.println("The list is ");
					list.displayFromHead();

				} else if (option.equals("t")) {
					System.out.println("The list is ");
					list.displayFromTail();

				} else if (option.equals("s")) {
					System.out.println("Enter the name you want to delete:");
					String delete = sc.nextLine();
					list.searchDelete(delete);

				} else if (option.equals("w")) {
					DLLNode removedOne = list.deleteAtHead();
					System.out.println("The one deleted is..." + removedOne);

				} else if (option.equals("q")) {
					done = true;
					System.out.println("quit");

				} else {
					System.out.println("Invalid option, please try again.");
				}

				System.out.println();

			} catch (InputMismatchException e) {
				System.err.println("Please enter characters for menu selection");
				sc.nextLine();

			}
		}

	}

}
