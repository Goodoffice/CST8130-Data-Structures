import java.util.Scanner;

public class LinkedListExample {

	public static void main(String[] args) {
		LList list = new LList();
		Scanner sc = new Scanner(System.in);
		boolean dataOk = false;

		int count = 0;

		while (!dataOk) {

			System.out.println("Enter a string: ");
			if (sc.hasNext()) {
				String string = sc.next();
				int length = string.length();

				if (string == null || length == 0) {
					System.out.println("This is empty palindrome");

				} else {
					dataOk = true;

					for (int i = 0; i < length; i++) {

						list.addAtHead(string.charAt(i));
						count++;

						if (string.charAt(i) == string.charAt(length - i - 1)) {
							if (!list.isEmpty()) {
								list.deleteAtHead(string.charAt(i));
								count--;
							} else {
								count++;
							}

						}

					}
				}
			}

		}

		if (count != 0) {
			System.out.println("This is NOT palindrome");
		} else {
			System.out.println("This is palindrome");
		}

	}
}
