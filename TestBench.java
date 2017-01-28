import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

public class TestBench {

	public static void main(String[] args) {
		// read command arguements
		String output = "Hello " + (args.length == 0 ? "World" : args[0]) + "!";
		System.out.println(output);
		// read an Integer from keyboard
		int cnt = readInteger();
		// read a String from keyboard
		String str = readString();
		while (cnt-- > 0) {
			System.out.println(cnt + " : " + str);
		}
		// read a file
		if (args.length > 0) {
			String file = readFile(args[0]);
			System.out.println(file);
		}
	}

	public static String readFile(String fileName) {
		String s = "";
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
   			StringBuilder sb = new StringBuilder();
    			String line = br.readLine();

    			while (line != null) {
        			sb.append(line);
        			sb.append(System.lineSeparator());
        			line = br.readLine();
    			}
    			s = sb.toString();
		} finally {
			return s;
		}
	}	

	public static String readString() {
		System.out.println("Enter a string: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		try {
			s = br.readLine();
		} catch (IOException ex) {
			System.out.println("Cause IOException");
			return "";
		} finally {
			return s;
		}
	}

	public static int readInteger() {
		System.out.println("Enter a number: ");
		Scanner reader = new Scanner(System.in); // Reading from System.in
		int n = reader.nextInt(); 		 // Scans the next token of the input as an int.
		return n;
	}

}
