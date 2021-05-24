import java.util.*;
public class OneTwoThreePlus {
	public static int go(int num,int sum) {
		int cnt = 0;//경우의 수 카운팅.
		//불가능한 경우 
		if(sum > num) return 0;
		//정답인 경우
		if(sum == num) return 1;
		//다음 경우 호출 
		//else {
			for(int i=1;i<=3;i++) {
				cnt += go(num,sum+i);
			}
		//}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0) {
			int n = sc.nextInt();
			System.out.println(go(n,0));
		}
	}

}
