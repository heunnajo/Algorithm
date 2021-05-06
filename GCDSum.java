package data_structures;
import java.util.*;

public class GCDSum {

	static int GCD(int a,int b) {
		if(b == 0) return a;
		else {
			return GCD(b,a%b);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- >0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for(int i=0;i<n;i++) {
				nums[i] = sc.nextInt();
			}
			long sum = 0;//int가 아니라 long
            //int sum = 0;
			for(int i=0;i<n-1;i++) {
				for(int j=i+1;j<n;j++) {
					sum += GCD(nums[i],nums[j]);
				}
			}
			System.out.println(sum);
		}
	}

}
