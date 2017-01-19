import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Numbers {
	private int[] numbers = null;
	private Scanner sc = new Scanner(System.in);

	public Numbers() {
		this.numbers = new int[100]; // important!!! To initialize the array'
										// size.
	}

	public void newSize() {
		int size = 0;
		System.out.println("Enter the size of numbers");
		size = sc.nextInt();

		numbers = Arrays.copyOf(numbers, size);

		System.out.println("Array has been generated");
	}

	public void generateNum() {
		Random random = new Random();

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(100);

		}

		System.out.println("Array has been generated successfully");

	}

	public void count() {
		if (numbers.length == 0) {
			System.out.println("There are nothing to count");
		} else {
			int count = 0;
			int number = 0;

			System.out.println("Enter the number you want to search");
			number = sc.nextInt();

			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] == number) {
					count++;
				}
			}

			System.out.println("There are " + count + " of the number " + number);
		}

	}

	public void insertionSort() {
		int temp = 0;

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i; j < numbers.length; j++) {
				if (numbers[j] < numbers[i]) {
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}

		System.out.println("Array has been sorted");
	}

	public void display() {
		for (int nums : numbers) {
			System.out.println(nums);
		}

	}

}
