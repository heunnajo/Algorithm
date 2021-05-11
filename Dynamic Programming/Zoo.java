import java.util.*;
public class Zoo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] d = new int [n+1][3];
		int mod = 9901;
		for(int i=0;i<3;i++) {
			d[0][i] = 1;
		}
		for(int i=1;i<=n;i++) {
			d[i][0] = d[i-1][0] + d[i-1][1] + d[i-1][2];
			d[i][1] = d[i-1][0] + d[i-1][2];
			d[i][2] = d[i-1][0] + d[i-1][1];
				
		}
		int ans = 0;
		ans = (d[n][0] + d[n][1] + d[n][2])%mod;
		
		System.out.println(ans);
	}

}
