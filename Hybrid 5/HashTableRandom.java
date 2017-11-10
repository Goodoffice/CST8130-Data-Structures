import java.util.Scanner;

public class HashTableRandom {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[100];

		for (int i = 0; i < 100; i++) {
			numbers[i] = 0;
		}

		int num = 0;
		int lastTwo = 0;
		int middleTwo = 0;
		int lastSum = 0;

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = num;
			num = (int) (Math.random() * 890000 + 100000);

			lastTwo = last(num);
			middleTwo = middle(num);
			lastSum = sum(num);

			if (numbers[lastTwo] == 0) {
				numbers[lastTwo] = num;
				System.out.println("Number was placed at index " + lastTwo);
			} else {
				boolean done = false;

				for (int j = lastTwo + 1; j < 100; j++) {
					if (numbers[j] == 0) {
						done = true;
						numbers[j] = num;
						System.out.println("Number was placed at sequential position at index \n" + j);
						break;
					}
				}
				if (!done) {
					System.out.println("Number cannot be placed!");
				}
			}

			System.out.println("Number  last two digits  middle two digits  last digits of sum");

			System.out.printf("%6d %8d %16d %20d \n", num, lastTwo, middleTwo, lastSum);
			System.out.println("");
		}

	}

	public static int last(int value) {
		return value % 100;
	}

	public static int middle(int value) {
		int middleTwo = 0;
		middleTwo = value % 10000 / 100;
		return middleTwo;
	}

	public static int sum(int total) {
		int sum = 0;
		while (total != 0) {
			sum += total % 10;
			total /= 10;
		}
		return sum;
	}

}
