import java.util.*;
public class Resign {
	static int n;
	static int ans = 0;
	static int[] t;
	static int[] p;
	public static void go(int day,int sum) {//day = index의미. day의 범위:1부터 n까지.n=7인데 day+1
		//불가능한 경우
		if(day > n+1) return;
		//정답인 경우
		if(day == n+1) {
			if(ans < sum) ans = sum;
			return;
		}
		//다음 경우 호출
		//1.선택하는 경우
		go(day+t[day],sum+p[day]);
		//2.선택X 경우
		go(day+1,sum);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		t = new int[n+1];
		p = new int[n+1];
		for(int i=1;i<=n;i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		go(1,0);
		System.out.println(ans);
	}

}
