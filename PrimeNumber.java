package data_structures;
import java.util.*;
public class PrimeNumber {
	
	/*에라토스테네스 체 알고리즘 이용한다!
	 * 1.2부터 N까지 숫자 중 지워지지 않은 수 중 가장 작은 수부터 시작.
	 * 2.그 수의 배수 다 지운다.
	 * 3.필요한 변수 : 지우는 연산을 저장하는 boolean 변수1
	 * */
	static boolean pn(int N) {
		boolean[] check = new boolean[N+1];
		check[1] = true;
		int[] prime = new int[N+1];
		int index = 0;
		for(int i=2;i<=N;i++) {
			for(int j=i*i; j<=N;j+=i) {
				check[j] = true;//소수가 아니다!
			}
			if(check[i] == false) {
				prime[index++] = i;
			}
		}
		return check[N];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//반복할 숫자 갯수.
		int cnt = 0;
		while(N-- >0) {//N:4
			int A = sc.nextInt();//1 3 5 7..N개 숫자 입력받는다.
			if(!pn(A)) cnt++;//입력한 수마다 pn 판별해서 맞으면 sb에 저장!
		}
		System.out.println(cnt);
	}

}
