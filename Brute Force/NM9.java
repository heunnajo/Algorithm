import java.util.Arrays;
import java.util.Scanner;
public class NM9 {
	static int[] num = new int[10];
	static int[] cnt = new int[10];
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
			if(cnt[i]>0) {
				cnt[i]--;
				a[index] = i;
				ans.append(go(index+1,n,m));
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
		//중복 제거 배열 생성 
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
		//마지막에 배열 원소값 두개가 같으면 else문을 실행하지 않고 종료되기 때문에 이전 i값의 else문에서 저장된 변수값들을 이용하여
		//num 배열을 채워준다!
		num[k] = x; cnt[k] = c;n = k+1;
		System.out.print(go(0,n,m));//중복을 제거한 배열의 갯수는?
	}

}
