import java.util.Scanner;

public class Palindromes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String: ");
		String s = sc.nextLine();
		
		if (testPalindrome(s)) {
			System.out.println("It is palindrome");
		} else {
			System.out.println("It is not palindrome");
		}
	}
	
	public static boolean testPalindrome(String s) {
		if (s.length() <= 1) {
			return true;
		}
		
		if (s.charAt(0) == s.charAt(s.length() -1))
			return testPalindrome(s.substring(1, s.length() - 1));
		
		return false;
	}

}
