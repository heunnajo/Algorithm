import java.util.*;
public class ContinuousMaxSum2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		int[] d = new int[n];
		int[] d2 = new int[n];
		for(int i=0;i<n;i++) {//앞에서부터 LIS 구한다.
			d[i] = a[i];
			if(i > 0 && d[i] < d[i-1] + a[i]) {
				d[i] = d[i-1] + a[i];
			}
		}
		for(int i=n-1;i>=0;i--) {//뒤에서부터 LIS 구한다.
			d2[i] = a[i];
			if(i < n-1 && d2[i] < d2[i+1] + a[i]) {
				d2[i] = d2[i+1] + a[i];
			}
		}
		int ans = d[0];
		for(int i=1;i<n;i++) {
			if(ans < d[i]) ans = d[i];
		}
		for(int i=1;i<n-1;i++) {
			if(ans < d[i-1] + d2[i+1]) ans = d[i-1] + d2[i+1];
		}
		System.out.println(ans);
	}

}
