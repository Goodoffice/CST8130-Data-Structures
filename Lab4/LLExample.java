import java.util.InputMismatchException;
import java.util.Scanner;

public class LLExample {

	public static void main(String[] args) {
		LList ls = new LList();
		Scanner sc = new Scanner(System.in);

		boolean done = false;
		String option = null;

		while (!done) {
			try {
				System.out.println("Enter a to add to head,\n" + "enter d to delete from the head,\n"
						+ "enter l to display a linked list\n" + "enter r to delete a particular element\n"
						+ "enter q to quit:");

				option = sc.nextLine();

				if (option.charAt(0) == 'a') {
					System.out.println("Enter a string to add to the list");
					String newData = sc.nextLine();
					ls.addAtHead(newData);
				} else if (option.charAt(0) == 'd') {
					LLNode remove = ls.deleteAtHead();
					System.out.println("The removed one is " + remove);
				} else if (option.charAt(0) == 'l') {
					ls.display();
				} else if (option.charAt(0) == 'r') {
					System.out.println("Enter a string to delete from the list");
					String data = sc.nextLine();
					ls.delete(data);
				} else if (option.charAt(0) == 'q') {
					System.out.println("Quit");
					done = true;
				} else {
					System.out.println("Invalid option, please try again");
				}

				System.out.println();

			} catch (InputMismatchException e) {
				System.err.println("Please enter characters for menu selection");
				sc.nextLine();
			}
		}

	}

}
