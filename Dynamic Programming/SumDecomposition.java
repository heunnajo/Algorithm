import java.util.*;
public class SumDecomposition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long mod = 1000000000L;
		int n = sc.nextInt();
		int k = sc.nextInt();//2
		long[][] d = new long[k+1][n+1];
		//d[k][n] : k개 정수로 합이 n이 되는 경우의 수
		d[0][0] = 1;//0개 정수로 합이 0이 되는 경우의 수
		for(int i= 1;i<=k;i++) {
			for(int j= 0;j<=n;j++) {
				for(int l=0;l<=j;l++) {//l<=j
					d[i][j] += d[i-1][j-l];
					d[i][j] %= mod;
				}
			}
		}
		System.out.println(d[k][n]);
	}

}
