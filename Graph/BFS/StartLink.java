import java.util.*;
public class Main {
	public static final int MAX =  10000000;
	public static void StartLink(String[] args) {
		Scanner sc = new Scanner(System.in);
		int f = sc.nextInt();
		int s = sc.nextInt();
		int g = sc.nextInt();
		int u = sc.nextInt();
		int d = sc.nextInt();
		int[] dist = new int[MAX];
		for(int i=0;i<MAX;i++) {
			dist[i] = -1;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		dist[s] = 0;
		while(!q.isEmpty()) {
			int cur =  q.remove();
			for(int next : new int[]  {cur-d,cur+u}) {
				if(1<=next && next<=f) {
					if(dist[next]==-1) {
						if(next == cur-d) {
							dist[next] = dist[cur]+1;
							q.add(next);
						} else {
							dist[next] = dist[cur]+1;
							q.add(next);
						}
					}
				}
			}
		}
		if(dist[g] != -1) {
			System.out.println(dist[g]);
		} else {
			System.out.println("use the stairs");
		}
	}

}