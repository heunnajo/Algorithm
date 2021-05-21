import java.util.Arrays;
import java.util.Scanner;
public class NM11 {
	static int[] num = new int[10];
	static boolean[] c = new boolean[10];
	static int[] a = new int[10];
 	static StringBuilder go(int index,int n,int m) {
 		if(index == m) {
 			StringBuilder sb = new StringBuilder();
			for(int i=0;i<m;i++) {
				sb.append(num[a[i]]);
				if(i!=m-1)sb.append(' ');
			}
			sb.append('\n');
			return sb;
		}
 		StringBuilder ans = new StringBuilder();
 		for(int i=0;i<n;i++) {
 			a[index] = i;
			ans.append(go(index+1,n,m));
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] temp = new int[n];
		for(int i=0;i<n;i++) {
			temp[i] = sc.nextInt();
		}
		Arrays.sort(temp);
		int k=0;int x=temp[0];int c=1;
		for(int i=1;i<n;i++) {
			if(x==temp[i]) {c++;}
			else {
				num[k] = x;
				k++;
				x = temp[i];
				c=1;
			}
		}
		num[k] = x; 
		n = k+1;
		System.out.print(go(0,n,m));
	}

}