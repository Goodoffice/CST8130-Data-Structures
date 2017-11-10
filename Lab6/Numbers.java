
public class Numbers<T> {
	
	public Numbers() {
		
	}
	
	public <T extends Comparable<T>> void insertionSort(T[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i; j < numbers.length; j++) {
				if (numbers[j].compareTo(numbers[i]) < 0) {
					T temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	}
	
	public void display(T[] inputArray) {
		System.out.println("The array is: ");
		
		for (T element: inputArray) {
			System.out.println(element);
		}
		
		System.out.println();
	}

}
 