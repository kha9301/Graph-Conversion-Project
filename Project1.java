import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Project1 {
	static String inputFileName = "project1.txt";

	public static void main(String[] args) throws IOException {
		try {
			BufferedReader brTest = new BufferedReader(new FileReader(inputFileName));
			FileInputStream in = new FileInputStream(inputFileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			Conversion a = new Conversion(br);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
/*
 * The main method will open the file project1.txt and hand off the input to
 * another class or classes to perform the graph conversion process. Therefore,
 * the main method itself should be fairly short.
 */
