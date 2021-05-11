import java.util.*;
public class ClimbingNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] d = new int[n+1][10];
		int mod = 10007;
		d[0][0] = 1;
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=9;j++) {
				for(int l=0;l<=j;l++) {
					d[i][j] += d[i-1][l];
				}
				d[i][j] %= mod;
			}
		}
		int ans = 0;
		for(int i=0;i<=9;i++) {
			ans += d[n][i];
		}
		System.out.println(ans%mod);
	}

}
