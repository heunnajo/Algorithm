import java.util.*;
public class HideSeek4_Stack {
	public static final int MAX = 1000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		boolean[] c = new boolean[MAX];
		int[] dist = new int[MAX];
		int[] from = new int[MAX];
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		c[n]=true;
		dist[n] = 0;
		while(!q.isEmpty()) {
			int cur = q.remove();
			if(cur-1>=0) {
				if(!c[cur-1]) {
					q.add(cur-1);
					c[cur-1] = true;
					dist[cur-1] = dist[cur]+1;
					from[cur-1] = cur;
				}
			}
			if(cur+1<MAX) {
				if(!c[cur+1]) {
					q.add(cur+1);
					c[cur+1] = true;
					dist[cur+1] = dist[cur]+1;
					from[cur+1] = cur;
				}
			}
			if(2*cur<MAX) {
				if(!c[2*cur]) {
					q.add(2*cur);
					c[2*cur] = true;
					dist[2*cur] = dist[cur]+1;
					from[2*cur] = cur;
				}
			}
		}
		System.out.println(dist[k]);
		Stack<Integer> st = new Stack<Integer>();
		for(int i=k;i!=n;i=from[i]) {
			st.push(i);
		}
		st.push(n);
		while(!st.isEmpty()) {
			System.out.print(st.pop()+" ");
		}
		System.out.println();
	}

}