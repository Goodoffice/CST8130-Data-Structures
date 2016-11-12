import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Numbers {
	int[] numbers;
	Scanner sc = new Scanner(System.in);

	// default constructor
	public Numbers() {
		this.numbers = new int[100];
	}

	public void arrayNewSize() {
		int size;

		System.out.println("Enter new size: ");
		size = sc.nextInt();

		numbers = Arrays.copyOf(numbers, size);

		System.out.println("\nArray has been generated");

	}

	public void generateNumbers() {
		// Random rand = new Random();

		for (int i = 0; i < numbers.length; i++) {

			// 100 means numbers are in 1 - 99
			// numbers[i] = rand.nextInt(100);
			numbers[i] = (int) (Math.random() * 100);

		}

		System.out.println("\nNumbers have been generated");

	}

	public int count() {
		int searchKey = 0;
		int count = 0;

		System.out.println("Enter number to search for:");
		searchKey = sc.nextInt();

		for (int i = 0; i < numbers.length; i++) {
			if (searchKey == numbers[i]) {
				count++;
			}
		}
		System.out.println("There are " + count + " of the number " + searchKey);

		return count;
	}

    // Generic	
	/*public static int count(String[] array, String item) {
	    int count = 0;
	 
	    if (item == null) {
	        for (String s : array) {
	            if (s == null) count++;
	        }
	    } else {
	        for (String s : array) {
	            if (item.equals(s)) {
	                count++;
	            }
	        }
	    }
	 
	    return count;
	 
	}*/
	
	/*String[] helloWorld = {"h", "e", "l", "l", "o", "w", "o", "r", "l", "d"};
	int count = count(helloWorld, "l");
	System.out.println("#occurrences of l: " + count);*/
	
	public String toString() {
		System.out.println("The numbers are:");

		for (int a : numbers) {
			System.out.println(a);
		}

		return Arrays.toString(numbers);
	}

	public void insertionSort() {
		
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i; j < numbers.length; j++) {
				if (numbers[j] < numbers[i]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}

		/*int j;

		for (int i = 1; i < numbers.length; i++) {

			j = i - 1;
			int temp = numbers[i];

			while (j >= 0 && temp < numbers[j]) {

				numbers[j + 1] = numbers[j];
				j--;
			}
			numbers[j + 1] = temp;
		}*/

	}

}
