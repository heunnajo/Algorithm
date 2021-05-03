import java.util.*;
public class Factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int ans = 1;
		for(int i=2;i<=num;i++) {
			ans *= i;
		}
		System.out.println(ans);
		
	}

}