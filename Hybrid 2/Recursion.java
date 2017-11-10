
public class Recursion {

	public static int doIt(int num) {
		int total = 0;
		
		for (int i = 0 ; i< num; i++) {
			for (int j = 0; j < num - i - 1; j++)
				total++;
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		System.out.println(doIt(10));

	}

}
