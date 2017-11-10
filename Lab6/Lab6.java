import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean done = false;
		
		Float[] floatArray = {8.2f, 6.3f, 7.4f, 4.5f, 10.6f};
		Double[] doubleArray = {11.3, 6.2, 3.3, 1.4, 9.5};
		String[] stringArray = {"apple", "orange", "peach", "mongo","bnana"};
		
		Numbers<Float> num1 = new Numbers<Float>();
		Numbers<Double> num2 = new Numbers<Double>();
		Numbers<String> num3 = new Numbers<String>();
		
		while (!done) {
			try {
				System.out.println("\nEnter 1 to generate numbers into array,\n" + "enter 2 to sort array\n"
						+ "enter 3 to display the array\n" + "enter 0 to quit:");
				
				int option = 0;
				while (!sc.hasNextLine()) 
					sc.next();
				
				option = sc.nextInt();
				
				switch (option) {
				case 1: 
					System.out.println("Generated array ");					
					break;
					
				case 2:
					num3.insertionSort(stringArray);
					break;
					
				case 3:
					num3.display(stringArray);
					break;
					
				case 0:
					done = true;
					System.out.println("Quit");
					break;
					
				default:
					System.out.println("unrecognized command");
				}
				
			} catch(InputMismatchException e) {
				System.err.println("Please enter correct data type for menu selection");
				sc.nextLine();
			}
		}

	}

}
