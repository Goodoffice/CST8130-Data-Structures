import java.util.Scanner;

public class LinkedListExample {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LList list = new LList();
		
		boolean dataOk = false;
		int count = 0;
		
		while (!dataOk) {
			System.out.println("Enter an expression: ");
			if (input.hasNext()) {
				String userInput = input.next();
				
				if (userInput.contains("(") || userInput.contains(")")) {
					dataOk = true;
					
					for (int i = 0; i < userInput.length(); i++) {
						if (userInput.charAt(i) == '(') {
							list.addAtHead(userInput.charAt(i));
							count++;
						}
						
						if (userInput.charAt(i) == ')') {
							if (!list.isEmpty()) {
								list.deleteAtHead();
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
			System.out.println("The expression is not balanced.");
		} else {
			System.out.println("The expression is balanced.");
		}

	}

}
