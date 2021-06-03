import java.util.*;
public class BFS_SpecialJudge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer>[] a = new ArrayList[n];
		int[] parent = new  int[n];//n만큼 생성하는 게 맞나?
		boolean[] c = new boolean[n];
		int[] order = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = new ArrayList<>();
		}
		for(int i=0;i<n-1;i++) {//간선정보 저장~
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			a[u].add(v);a[v].add(u);
		}
		for(int i=0;i<n;i++) {
			order[i] = sc.nextInt()-1;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);c[0] = true;
		int m=1;
		for(int i=0;i<n;i++) {//i는 0부터 정점 갯수만큼 반복한다. order[0]부터 order[n-1]까지.
			//Round1.큐에서 꺼낸 x(0)와 order[0] 비교.
			//Round2.x(0)의 인접노드를 큐에 넣었기 때문에
			//		x(0)의 인접노드와 order[1]과 비교. - x의 인접노드 : 1,2 이고 order:0 1 2 3 또는 0 2 1 3일 때
			//parent[1] = 0, parent[2] = 0 1,2 둘다 parent 값이 x이므로(인접노드가 x) 만족~!
			//이러한 n개의 정점에 대해 order의 각 값과 비교 연산을 n개 만큼반복하기 때문에 for(i=0~n)돌려준다!
			if(q.isEmpty()) {//큐가 비면? bfs 다 돌았다는 뜻.근데 왜 0출력하고 종료하나?
				System.out.println(0);
				System.exit(0);
			}
			int x = q.remove();
			if(x != order[i]) {
                System.out.println(0);
				System.exit(0);
			}
            //인접노드를 돌면서 인접노드 관계를 나타내는 parent배열을 생성하고, 현재 정점 x의 인접노드 갯수를 세준다!
			int cnt=0;
			for(int y:a[x]) {
				if(c[y]==false) {
					parent[y] = x;cnt++;//인접 노드 갯수 센다!
				}
			}
			for(int j=0;j<cnt;j++) {
				if(m+j>=n || parent[order[m+j]] != x) {
					System.out.println(0);
					System.exit(0);
				}
				q.add(order[m+j]);
				c[order[m+j]]=true;
			}
			m+=cnt;
		}
		System.out.println(1);
	}

}
