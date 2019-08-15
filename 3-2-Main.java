
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String match = scan.nextLine().toLowerCase();
		scan.close();
		
		String dirName = "input/test/case";
		File dir = new File(dirName);
		String[] files = dir.list();
		
		Vector<String> result = new Vector<String>();
        for (int i = 0; i < files.length; i++) {
        	File subFile = new File(dirName+"/"+files[i]);
        	if (subFile.isFile()) {
        		String fileName = files[i].toLowerCase();
        		if (fileName.contains(match)) result.add(files[i]);
        	}
        }
        
        Collections.sort(result);
        for (String i : result) System.out.println(i);
	}
}
