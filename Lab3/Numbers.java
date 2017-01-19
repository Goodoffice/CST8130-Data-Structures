import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Numbers {
	private int[] numbers = null;
	private Scanner sc = new Scanner(System.in);
	private int[] helper;

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

	public void mergeSort() {
		mergesort(numbers);
	}

	private static void mergesort(int[] numbers) {
		if (numbers.length == 1)
			return;

		int middle = numbers.length / 2;
		int[] a1 = new int[middle];
		int[] a2 = new int[numbers.length - middle];

		for (int i = 0; i < numbers.length; i++) {
			if (i < middle)
				a1[i] = numbers[i];
			else
				a2[i - middle] = numbers[i];
		}

		// sort two parts
		mergesort(a1);
		mergesort(a2);

		// merge two parts together
		merge(a1, a2, numbers);
	}

	/**
	 * To merge two parts sorted array together and sort this two parts.
	 */
	private static void merge(int[] a1, int[] a2, int[] values) {
		int index1 = 0;
		int index2 = 0;

		for (int j = 0; j < values.length; j++) {
			if (index1 == a1.length) {
				values[j] = a2[index2];
				index2++;
			} else if (index2 == a2.length) {
				values[j] = a1[index1];
				index1++;
			} else if (a1[index1] < a2[index2]) {
				values[j] = a1[index1];
				index1++;
			} else {
				values[j] = a2[index2];
				index2++;
			}
		}

	}
}
