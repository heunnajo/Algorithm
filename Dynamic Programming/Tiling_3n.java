import java.util.*;
public class Tiling_3n {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n+1];
		d[0] = 1;
		for(int i=2;i<=n;i++) {
			d[i] = 3*d[i-2];
			for(int j=i-4;j>=0;j-=2) {
				d[i] += d[j]*2;
			}
		}
		System.out.println(d[n]);
	}

}
