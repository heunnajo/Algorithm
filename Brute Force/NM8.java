import java.util.Arrays;
import java.util.Scanner;
public class NM8 {
	static int[] a = new int[10];
	static int[] num = new int[10];
	static StringBuilder go(int index,int start, int n,int m) {//입력할 수열 index=0, num[start=0]에서 시작.
		if(index == m) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<m;i++) {
				sb.append(a[i]);
				if(i!=m-1) {sb.append(" ");}
			}
			sb.append("\n");
			return sb;
		}
		StringBuilder ans = new StringBuilder();
		for(int i=start;i<n;i++) {
			a[index] = num[i];
			ans.append(go(index+1,i,n,m));//넣은 숫자가 i번째라면 그 다음 숫자는 num의 i번째숫자가 start가 된다!
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		num = new int[n];
		for(int i=0;i<n;i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		System.out.print(go(0,0,n,m));
	}

}
