import java.util.*;
public class Add_123 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- >0) {
			int n = sc.nextInt();
			int[] memo = new int[1001];
			memo[0] = 1;memo[1] = 1;memo[2] = 2;memo[3] = 4;
			for(int i=4;i<=n;i++) {
				memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
			}
			System.out.println(memo[n]);
		}
	}
}
