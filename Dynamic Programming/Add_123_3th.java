import java.util.*;
public class Add_123_3th {

	static final long mod = 1000000009L;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int limit = 1000000;
		long[] d = new long[limit+1];
		d[0] = 1;
		for(int i=1;i<=limit;i++) {
			for(int j=1;j<=3;j++) {
				if(i-j >= 0) {
					d[i] += d[i-j];
				}
			}
			d[i] %= mod;
		}
		int t = sc.nextInt();
		while(t-- >0) {
			int n = sc.nextInt();
			System.out.println(d[n]);
		}
	}

}
