import java.util.*;
public class ContiguousMaxSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		int sum = a[0];
		int totalsum = a[0];
		for(int i=1;i<n;i++) {
			//System.out.println("max 처리전 sum:"+sum);
			sum = Math.max(sum + a[i],a[i]);
			totalsum = Math.max(totalsum,sum);
			//System.out.println("max 처리후 sum:"+sum);
		}
		System.out.println(totalsum);
	}
}
