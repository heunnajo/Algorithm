import java.util.*;
public class NM10 {
	static int[] num = new int[10];
	static int[] cnt = new int[10];
	static int[] a = new int[10];
	static StringBuilder go(int index,int start,int n,int m) {
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
		for(int i=start;i<n;i++) {
			if(cnt[i]>0) {
				cnt[i]--;
				a[index] = i;
				ans.append(go(index+1,i,n,m));
				cnt[i]++;
			}
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
			else {//갯수가 하나 
				num[k] = x;//num[0] = temp[0], num[1] = temp[1]
				cnt[k] = c;
				k++;
				x = temp[i];//다음 비교할 대상 저장!
				c=1;
			}
		}
		num[k] = x; cnt[k] = c;n = k+1;
		//System.out.print(go(0,n,m));
		System.out.print(go(0,0,n,m));
	}

}
