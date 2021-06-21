import java.util.*;
import java.io.*;
public class OneTwoThreePlus_3rd {
	public static int go(int sum,int goal) {
		//1.정답이 될 수 없는 경우.
		if(sum>goal) return 0;
		//2.정답을 찾은 경우!
		if(sum==goal) return 1;//경우의수 1가지!
		//3.다음 경우 재귀 함수 호출!
		int cnt=0;
		for(int i=1;i<=3;i++) {
			//sum+=i;
			cnt += go(sum+i,goal);
		}
		return cnt;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- >0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(go(0,n));//(sum,goal)
		}
	}

}
