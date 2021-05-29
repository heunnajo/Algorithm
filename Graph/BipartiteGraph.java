import java.util.*;
public class BipartiteGraph {
	public static void dfs(ArrayList<Integer>[] a,int[] color,int x,int c) {
		color[x] = c;
		for(int y:a[x]) {
			if(color[y]==0) {
				dfs(a,color,y,3-c);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			//노드 갯수만큼 인접리스트 생성.
			ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];
			for(int i=1;i<=n;i++) {
				a[i] = new ArrayList<Integer>();
			}
			//입력받은 간선 정보 인접리스트에 저장.
			for(int i=0;i<m;i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				a[u].add(v);a[v].add(u);
			}
			//dfs 탐색!
			int[] color = new int[n+1];
			boolean ok = true;
			for(int i=1;i<=n;i++) {
				if(color[i]==0) {//아직 방문 안한 노드면 방문한다!
					dfs(a,color,i,1);
				}
			}
			//dfs 탐색 후.color로 이분그래프인지 판단한다!
			for(int i=1;i<=n;i++) {
				for(int j:a[i]) {
					if(color[i] == color[j]) {//인접리스트 중에서 컬러 같은게 있으면 이분그래프 아님!
						ok = false;
					}
				}
			}
			if(ok) {System.out.println("YES");}
			else {System.out.println("NO");}
		}
	}

}
