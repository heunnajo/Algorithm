import java.util.*;
public class SubwayLine2 {
	static int n;
	static ArrayList<Integer>[] a;
	static int[] c;
	static int[] dist;
	public static int dfs(int x,int p) {
		if(c[x]==1) return x;
		c[x] = 1;
		for(int y:a[x]) {
			if(y==p) continue;
			int res = dfs(y,x);
			//리턴된 res 값에 따라 리턴하는 값이 다르다! 
			if(res == -2) return -2;
			if(res>0) {
				c[x] = 2;
				if(res == x) return -2;
				else return res;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = (ArrayList<Integer>[]) new  ArrayList[n+1];
		c = new int[n+1];
		dist = new int[n+1];
		for(int i=1;i<=n;i++) {
			a[i] = new ArrayList<Integer>();
		}
		for(int i=1;i<=n;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v); a[v].add(u);
		}
		dfs(1,-1);//시작 위치와 이전위치로 dfs 시작.
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=n;i++) {
			if(c[i]==2) {
				q.add(i);
				dist[i]=0;
			}else {dist[i]=-1;}
		}
		while(!q.isEmpty()) {
			int x = q.remove();
			for(int y:a[x]) {
				if(dist[y]==-1) {
					q.add(y);
					dist[y] = dist[x]+1;
				}
			}
		}
		for(int i=1;i<=n;i++) {
			System.out.print(dist[i]+" ");
		}
		System.out.println();
	}
}