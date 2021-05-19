import java.util.*;
public class NM_Sequence3 {
	static int[] a = new int[10];
	static StringBuilder go(int index,int n,int m) {
		if(index == m) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<m;i++) {
				sb.append(a[i]);
				if(i != m-1) sb.append(" ");
			}
			sb.append("\n");
			return  sb;
		}
		StringBuilder ans = new StringBuilder();
		for(int i=1;i<=n;i++) {
			a[index] = i;
			ans.append(go(index+1,n,m));
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.print(go(0,n,m));
	}

}