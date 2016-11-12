import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Lab01 {

	public static void main(String[] args) {

		String fname;
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the file name: ");
		fname = scan.nextLine();

		String line = null;

		try {

			FileReader fr = new FileReader(fname);
			BufferedReader br = new BufferedReader(fr);

			while ((line = br.readLine()) != null) {
			
				String[] segments = line.split("\t");
				
				for (String part : segments) {
				
					System.out.println(part);	
				
				}
			}

			br.close();

		} catch (IOException e) {
			System.out.println("Error to read the file.");
		}

	}
}
