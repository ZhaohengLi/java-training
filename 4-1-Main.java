import java.util.*;
import java.util.regex.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
		scan.close();
		String REGEX = "<[^>]*>|&[^;]*;";
		Pattern patt = Pattern.compile(REGEX);
		Matcher match =patt.matcher(text);
		text = match.replaceAll("");
		System.out.println(text);
	}
}
