import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int grid[][] = new int[n*n][n*n];
		for (int i=0; i<n*n; i++) for (int j=0; j<n*n; j++) grid[i][j] = scanner.nextInt();
		
		if (checkRow(n,grid) && checkCol(n,grid) && checkSub(n,grid)) System.out.println("yes");
		else System.out.println("no");
	}
	
	public static boolean isLegal(int n, int[] array) {
		int[] std = new int[n*n];
		for (int i=0; i<n*n; i++) std[i] = 0;
		for (int i : array) if (0<i && i<=n*n) std[i-1]++; else return false;
		for (int i=0; i<n*n; i++) if (std[i] != 1) return false;
		return true;
	}
	
	public static boolean checkCol(int n, int[][] grid) {
		int reformat[][] = new int[n*n][n*n];
		for (int i=0; i<n*n; i++) {
			for (int j=0; j<n*n; j++) reformat[i][j] = grid[j][i];
			if (!isLegal(n, reformat[i])) return false;
		}
		return true;
	}
	
	public static boolean checkRow(int n, int[][] grid) {
		for (int i=0; i<n*n; i++) if (!isLegal(n, grid[i])) return false;
		return true;
	}
	
	public static boolean checkSub(int n, int[][] grid) {
		int reformat[] = new int[n*n]; int cnt = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				for (int ii=0; ii<n; ii++) {
					for (int jj=0; jj<n; jj++) {
						reformat[cnt++] = grid[i*n+ii][j*n+jj];
					}
				}
				if (!isLegal(n, reformat)) return false;
				else cnt = 0;
			}
		}
		return true;
	}
}
