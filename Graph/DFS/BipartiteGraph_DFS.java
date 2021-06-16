import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class BipartiteGraph_DFS {
	public static int t,v,e;
	public static ArrayList<Integer>[] a;
	public static int[] g;
	public static StringBuilder sb;
	public static void dfs(int x,int group) {
		if(g[x]!=0) return;//이미 방문한 노드~!
		g[x] =  group;
		for(int y:a[x]) {
			if(g[y]==0) {
				dfs(y,3-group);//현재 노드의 그룹번호와 다른 번호를 다음 인접노드 그룹번호로 전달!
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		t = Integer.parseInt(br.readLine());
		while(t-- >0) {
			String[] input = br.readLine().split(" ");
			v = Integer.parseInt(input[0]);//3
			e = Integer.parseInt(input[1]);//2
			a = (ArrayList<Integer>[])new ArrayList[v];//정점 갯수만큼 인접리스트 생성.
			g = new int[v];//정점갯수만큼 그룹번호 저장할 배열 생성.
			for(int i=0;i<v;i++) {//인접리스트 각 인덱스별로 배열리스트 생성!
				a[i] = new ArrayList<Integer>();
			}
			for(int i=0;i<e;i++) {//간선 갯수 e만큼 간선 정보 입력받고 저장! 
				input = br.readLine().split(" ");
				int u = Integer.parseInt(input[0])-1;//1(0)
				int k = Integer.parseInt(input[1])-1;//3(0)
				a[u].add(k);//a[0].add(2)
				a[k].add(u);//a[2].add(0)
			}
			boolean flag = true;
			//dfs(0,1);//0번 노드, 그룹번호 1로 시작!=>0번 노드만 하는 게 아니라! v개 노드 다 해야지~!
			for(int i=0;i<v;i++) {
				if(g[i]==0) {//방문체크해주고!
					dfs(i,1);
				}
			}
			for(int i=0;i<v;i++) {
				for(int y:a[i]) {
					if(g[i]==g[y]) {flag = false;}
				}
			}
			if(flag) {sb.append("YES\n");}
			else {sb.append("NO\n");}
		}
		System.out.print(sb);
	}

}
