import java.util.Scanner;

class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	String s = scanner.nextLine();
    	StringBuffer result = new StringBuffer("");
    	
    	StringBuffer buffer = new StringBuffer("");
    	for(int i=0; i<s.length(); i++) {
    		char current = s.charAt(i);
			if (isBreakSymbol(current)) {
				String reversedword = reverse(buffer.toString());
				result.append(reversedword).append(current);
				buffer = new StringBuffer("");
			}else buffer.append(current);
    	}
    	System.out.println(result);
	}

    public static String reverse(String s) {
    	StringBuffer buffer = new StringBuffer("");
    	for (int i=s.length()-1; i>=0; i--) buffer.append(s.charAt(i));
    	return buffer.toString();
    }
    
    public static boolean isBreakSymbol(char c) {
    	if (c == '\'') return false;
    	if (Character.isLetter(c)) return false;
    	return true;
    }
}
