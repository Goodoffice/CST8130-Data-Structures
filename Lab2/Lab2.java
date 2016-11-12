import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab2 {
	public static void main(String[] args) {

		Numbers numbers = new Numbers();
		Scanner sc = new Scanner(System.in);

		boolean done = false;

		while (!done) {
			try {

				System.out
						.println("Enter 1 to create array of new size,\n" + "2 to generate random numbers into array,\n"
								+ "3 to count a value, 4 to display array,\n" + "5 to sort, 0 to quit:");

				int option = 0;

				while (!sc.hasNextLine())
					sc.next();

				option = sc.nextInt();
				sc.nextLine();

				switch (option) {
				case 1:
					numbers.arrayNewSize();
					break;

				case 2:
					numbers.generateNumbers();
					break;

				case 3:
					numbers.count();
					break;

				case 4:
					numbers.toString();
					break;

				case 5:
					numbers.insertionSort();
					break;

				case 0:
					done = true;
					System.out.println("quit");
					break;

				default:
					System.out.println("unrecognized command");

				}
				System.out.println();

			} catch (InputMismatchException e) {
				System.err.println("Please enter integer numbers for menu selection");
				sc.nextLine();
			}

		}

	}

}
