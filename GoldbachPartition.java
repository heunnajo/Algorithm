package data_structures;
import java.util.*;
public class GoldbachPartition {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> primes = new ArrayList<>();//prime number들을 저장하기 위한 배열!
		boolean[] check = new boolean[1000001];//에라토스테네스의 체!
		for(int i=2;i<1000000;i++) {
			if(check[i] == false) {
				primes.add(i);
				for(int j = i+i;j<=1000000;j+=i) {
					check[j] = true;
				}
			}
		}
		int T = sc.nextInt();
		while(T-- >0) {
			int n = sc.nextInt();int index=0;
			int ans = 0;
			for(int p:primes) {
				if(n-p >= 2 && p <= n-p) {
					if(check[n-p] == false) {//prime이란 의미!
						ans += 1;
					}
				} else {
					break;
				}
			}
			System.out.println(ans);
		}
	}

}
