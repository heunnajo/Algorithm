import java.util.*;
public class ConnectedComponent {
	public static void dfs(ArrayList<Integer>[] a,boolean[] c,int x) {
		if(c[x]) {return;}
		c[x] = true;
		for(int y:a[x]) {//인접리스트 다 돌면서 dfs에 다음 인접 노드 추가!
			if(c[y]==false) {
				dfs(a,c,y);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//정점 갯수.
		int m = sc.nextInt();//간선 갯수.
		ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];
		for(int i=1;i<=n;i++) {//정점 갯수만큼 ArrayList 생성해서 각 배열방에 넣는다.
			a[i] = new ArrayList<>();
		}
		for(int i=0;i<m;i++) {//간선의 갯수만큼 인접리스트에 저장!
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);//양방향으로 리스트에 노드 추가!
		}
		//dfs 돌린다.
		//dfs 돌릴 때마다 숫자 1씩 증가시켜서 연결요소 갯수 구한다.
		boolean[] c = new boolean[n+1];
		int ans = 0;
		for(int i=1;i<=n;i++) {//각 노드마다 방문하지 않은 노드를 방문하고, dfs 돌린다. dfs돌 때마다 1씩 증가.
			if(c[i]==false) {
				dfs(a,c,i);
				ans +=1;
			}
		}
		System.out.println(ans);
	}

}
