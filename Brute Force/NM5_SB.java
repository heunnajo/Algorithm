import java.util.Arrays;
import java.util.Scanner;
public class NM5_SB {
	static int[] a = new int[10];
	static boolean[] c = new boolean[10];//중복 체크
 	static StringBuilder go(int[] num,int index,int n,int m) {
 		if(index == m) {
 			StringBuilder sb = new StringBuilder();
			for(int i=0;i<m;i++) {
				sb.append(a[i]);
				if(i!=m-1)sb.append(' ');
			}
			sb.append('\n');
			return sb;
		}
 		StringBuilder ans = new StringBuilder();
		for(int i=0;i<n;i++) {
			if(c[i]) continue;
			c[i] = true;a[index] = num[i];
			ans.append(go(num,index+1,n,m));
			c[i] = false;
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] num = new int[n];
		for(int i=0;i<n;i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		System.out.print(go(num,0,n,m));
	}

}
