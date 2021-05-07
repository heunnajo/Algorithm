package data_structures;
import java.util.*;
/* 알고리즘  = rootN & 에라토스테네스 체 이용!
 * 1. 2부터 루트N 까지 에라토스테네스 체 구한다.
 * 2. check[i]가 false이면 소수! true이면 소수X
 * check 배열 i번째 방은 숫자 i가 소수인지 아닌지를 저장하기 때문
 * check[i]가 true이면 i는 소수X, check[i]가 false이면 i는 소수이다!
 */
public class PrimeNumber_M_N {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		boolean[] check = new boolean[n+1];
		check[0] = true; check[1] = true;
		for(int i=2;i*i<=n;i++) {
			if(check[i] == true) continue;//check[i]가 true이면 아래 실행할 필요 없다!
			for(int j=i+i;j<=n;j+=i) {
				check[j] = true;
			}
		}
		for(int i=m;i<=n;i++) {
			if(check[i] == false) {
				System.out.println(i);
			}
		}
	}

}
