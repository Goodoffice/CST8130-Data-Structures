import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab2 {
	public static void main(String[] args) {

		Numbers num = new Numbers();
		Scanner sc = new Scanner(System.in);

		boolean done = false;
		int option = 0;

		try {
			while (!done) {
				System.out
						.println("Enter 1 to create array of new size,\n" + "2 to generate random numbers into array,\n"
								+ "3 to count a value, 4 to display array,\n" + "5 to sort, 0 to quit:");

				option = sc.nextInt();

				switch (option) {
				case 1:
					num.newSize();
					break;

				case 2:
					num.generateNum();
					break;

				case 3:
					num.count();
					break;

				case 4:
					num.display();
					break;

				case 5:
					num.insertionSort();
					break;

				case 0:
					System.out.println("Quit");
					done = true;
					break;

				default:
					System.out.println("Invalid option, please try again");
					break;
				}
				System.out.println();
			}

		} catch (InputMismatchException e) {
			System.out.println("ERROR!!");
		}

	}

}
