import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer n = scan.nextInt();
		Set set = new Set(n);
		for (int i=0; i<n-1; i++) {
			Integer a = scan.nextInt();
			Integer b = scan.nextInt();
			set.join(a, b);
		}
		scan.close();
		if (set.check()) System.out.println("YES");
		else System.out.println("NO");
	}
}

class Set {
	private Integer[] pre;
	public Set(Integer n){
		pre = new Integer[n+1];
		for (int i=0; i<pre.length; i++) pre[i] = i;
	}
	public void join(Integer a, Integer b) {
		int fa = find(a);
		int fb = find(b);
		if (fa!=fb) pre[fa]=fb;
	}
	
	public Integer find(Integer a) {
		if (this.pre[a]!=a) this.pre[a]=find(this.pre[a]);
		return pre[a];
	}
	public Boolean check() {
		Integer cnt = 0;
		for (int i=1; i<pre.length; i++) if (pre[i]==i) cnt++;
		if (cnt==1) return true;
		else return false;
	}
}
