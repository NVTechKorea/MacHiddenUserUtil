package CoreFramework;
import java.util.Scanner;
public class GetInput {
	Scanner input = null;
	public String nextLine() {
		input = new Scanner(System.in);
		String s = input.nextLine();
		return s;
	}
}
