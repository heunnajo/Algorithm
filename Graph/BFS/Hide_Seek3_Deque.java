import java.util.*;
public class Hide_Seek3_Deque {
	public static final int MAX = 1000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] dist = new int[MAX];
		for(int i=0;i<MAX;i++) {
			dist[i] = -1;
		}
		Deque<Integer> dq = new LinkedList<Integer>();
		dq.addFirst(n);
		dist[n] = 0;
		while(!dq.isEmpty()) {
			int cur = dq.remove();
			for(int next : new int[] {cur*2,cur+1,cur-1}) {
				if(0<=next && next<MAX) {
					if(dist[next]  == -1) {
						if(next==cur*2) {
							dist[next] = dist[cur];
							dq.addFirst(next);
						} else {
							dist[next] = dist[cur]+1;
							dq.addLast(next);
						}
					}
				}
			}
		}
		System.out.println(dist[m]);
	}

}