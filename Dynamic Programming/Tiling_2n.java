import java.util.*;
public class Tiling_2n {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] memo = new int[1001];
		//Top-down(재귀)방식 풀이 
		memo[0] = 1;memo[1] = 1;
		for(int i=2;i<=n;i++) {
			memo[i] = memo[i-1] + memo[i-2];
			memo[i] %= 10007;
		}
		System.out.println(memo[n]);
	}
}
