import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Emoji {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] d = new int[n+1][n+1];//(s,c) 방문체크.
		for(int i=0;i<=n;i++) {
			Arrays.fill(d[i], -1);
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(0);
		d[1][0] = 0;//방문체크.
		while(!q.isEmpty()) {
			int s = q.remove();
			int c = q.remove();
			//1.s=s,c=s
			if(d[s][s]==-1) {
				d[s][s] = d[s][c]+1;
				q.add(s);q.add(s);
			}
			//2.s=s+c,c=c
			if(s+c<=n && d[s+c][c]==-1) {
				d[s+c][c]=d[s][c]+1;
				q.add(s+c);q.add(c);
			}
			//3.s=s-1,c=c
			if(s-1>=0 && d[s-1][c]==-1) {
				d[s-1][c]=d[s][c]+1;
				q.add(s-1);q.add(c);
			}
		}
		int ans=-1;
		for(int i=0;i<=n;i++) {
			if(d[n][i] != -1) {
				if(ans==-1||ans>d[n][i]) {//(s,c)=>(n,i)라면 n이 되기까지 i의 최소값?!i는 c임.
					ans = d[n][i];
				}
			}
		}
		System.out.println(ans);
	}

}
