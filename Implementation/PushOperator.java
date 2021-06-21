import java.io.*;
import java.util.*;
public class PushOperator {
	static int n;
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	static int nums[];
	static int op[] = new int[4];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<4;i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		dfs(1,nums[0]);//index=1부터, num=nums[0]부터.
		System.out.println(MAX);
		System.out.println(MIN);
	}
	
	static void dfs(int index,int num) {
		if(index == n) {//이 부분 실행 안됨.
			MAX = Math.max(num, MAX);//MAX는 일부러 최솟값 저장.
			MIN = Math.min(num, MIN);//MIN은 일부러 최댓값 저장.
			return;
		}
		for(int i=0;i<4;i++) {
			if(op[i]>0) {
				op[i]--;//i번째연산자 선택!
				switch(i){
				case 0: dfs(index+1,num+nums[index]);//index는 1부터, num은 Num[0]부터 시작하니까 num+nums[index]로 하면 된다! 수식을 써보면 바로 알 것을!!
						break;
				case 1: dfs(index+1,num-nums[index]);
						break;
				case 2: dfs(index+1,num*nums[index]);
						break;
				case 3: dfs(index+1,num/nums[index]);
						break;
				}
				op[i]++;
			}
		}
		
	}
	

}
