import java.util.Scanner;
class Main {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
		
        String nstr = scanner.nextLine();
        Integer n = Integer.parseInt(nstr);
        
        String str = scanner.nextLine();
        String[] numstr = str.split(" ");
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(numstr[i]);
        }
        
        Integer maxsum, maxhere;
        maxsum = maxhere = nums[0];
        for(int i=1; i<n; i++) {
        	if (maxhere <= 0) maxhere = nums[i];
        	else maxhere += nums[i];
        	if (maxhere > maxsum) maxsum = maxhere;
        }
        
        System.out.println(maxsum);
	}
}
