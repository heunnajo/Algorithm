import java.util.*;
public class StairNumber {
	public static long mod = 1000000000L;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//n을 먼저 입력받고 
		long[][] d = new long[n+1][10];//n값에 따라 배열d 크기 결정
		for(int i=1;i<=9;i++) {//길이1인 수 먼저 셋팅
			d[1][i] = 1;
		}
		for(int i=2;i<=n;i++) {//n은 2부터 시작.
			for(int j=0;j<=9;j++) {// 0<=L(마지막 수)<=9
				d[i][j] = 0;
				if(j-1>=0) d[i][j] += d[i-1][j-1];//L이 1 작은 수 일때
				if(j+1<=9) d[i][j] += d[i-1][j+1];//L이 1 큰 수 일때
				d[i][j] %= mod;
			}
		}
		long ans = 0;
		for(int i=0;i<=9;i++) {
			ans += d[n][i];
		}
		ans %= mod;
		System.out.println(ans);
	}

}
