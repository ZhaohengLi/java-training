
import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Integer count = scan.nextInt();
		Integer[] mem = new Integer[count];
		String command = scan.nextLine();
		
		while (scan.hasNextLine()) {
			command = scan.nextLine();
			String[] items = command.split(" ");
			
			try {
				if (items[0].equals("?")) {
					Integer a = Integer.parseInt(items[1]);
					if (mem[a]!=null) System.out.println(mem[a].toString());
					else System.out.println("null");
					continue;
				}
				
				Integer a = Integer.parseInt(items[1]);
				Integer b = Integer.parseInt(items[2]);
				Integer c = Integer.parseInt(items[3]);
				
				if (items[0].equals("=")) {
					for(int i=a; i<b; i++) mem[i] = c;
					continue;
				}
				
				Integer opA = mem[a];
				if (opA == null) throw new NullPointerException();
				Integer opB = mem[b];
				if (opB == null) throw new NullPointerException();
				
				switch(items[0]) {
				case("+"):
					mem[c] = opA + opB;
					break;
				case("-"):
					mem[c] = opA - opB;
					break;
				case("*"):
					mem[c] = opA * opB;
					break;
				case("/"):
					mem[c] = opA / opB;
					break;
				}
			}catch(NullPointerException err){
				System.out.println("Null Number");
			}catch(ArithmeticException err) {
				System.out.println("Divided By Zero");
			}catch(ArrayIndexOutOfBoundsException err) {
				System.out.println("Illegal Address");
			}
		}
		
		scan.close();
	}
}
