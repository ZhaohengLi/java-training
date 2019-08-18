import java.util.*;
import java.util.regex.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
		scan.close();
		String REGEX = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
		Pattern patt = Pattern.compile(REGEX);
		Matcher match =patt.matcher(text);
		Integer start = 0;
		Integer cnt = 0;
		while (match.find(start)) {
			start = match.start()+1;
			if (isLeagel(match.group())) {
				cnt++;
				System.out.println(match.group());
			}
		}
		if (cnt==0) System.out.println("NotMatch");
		
	}
	public static Boolean isLeagel(String s) {
		String[] items = s.split("-");
		Integer y = Integer.parseInt(items[0]);
		Integer m = Integer.parseInt(items[1]);
		Integer d = Integer.parseInt(items[2]);
		Boolean year = 1990<=y && y<2018;
		Boolean month = 1<=m && m<=12;
		Boolean day;
		switch (m) {
		case(1):
		case(3):
		case(5):
		case(7):
		case(8):
		case(10):
		case(12):
			day = 1<=d && d<=31;
			break;
		case(2):
			day = 1<=d && d<=28;
			break;
		default:
			day = 1<=d && d<=30;
			break;
		}
		if (year && month && day) return true;
		else return false;
	}
}

