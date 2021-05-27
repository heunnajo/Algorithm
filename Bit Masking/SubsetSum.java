import java.util.*;
public class SubsetSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int[] num = new int[n];
		for(int i=0;i<n;i++) {
			num[i] = sc.nextInt();
		}
		int ans = 0;
		for(int i=1;i<(1<<n);i++) {
			int sum = 0;
			for(int j=0;j<n;j++) {//n개의 수! 각각의 부분집합에 대해 검사 연산!
				if((i&(1<<j)) != 0) {
					sum+=num[j];
				}
			}
			//계산한 부분수열의 합이 s이면 경우의 수 1씩 증가!
			if(sum == s) {ans+=1;}
		}
		System.out.println(ans);
	}

}
