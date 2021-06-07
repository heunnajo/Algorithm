import java.util.*;
public class Hide_Seek3_TwoQueue {
	public static final int MAX = 1000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();//도착할 목적지.
		int[] dist = new int[MAX];
		for(int i=0;i<MAX;i++) {
			dist[i] = -1;//초기값을 -1로 셋팅.
		}
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> nq = new LinkedList<Integer>();
		q.add(n);
		dist[n] = 0;
		while(!q.isEmpty()) {
			int cur = q.remove();
			for(int next : new int[] {cur*2,cur+1,cur-1}) {
				if(0<=next && next<MAX) {
					if(dist[next]  == -1) {//방문하지 않은 next만 방문한다!
						if(next==cur*2) {
							dist[next] = dist[cur];
							q.add(next);
						} else {
							dist[next] = dist[cur]+1;
							nq.add(next);
						}
					}
				}
			}
			if(q.isEmpty()) {
				q = nq;
				nq = new LinkedList<Integer>();
			}
		}
		System.out.println(dist[m]);
	}

}
