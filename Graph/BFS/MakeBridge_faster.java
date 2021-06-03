import java.util.*;
class Pnt7{
	int x;int y;
	Pnt7(int x,int y){
		this.x = x;this.y = y;
	}
}
public class MakeBridge_faster {
	public static int n;
	public static int[][] a;
	public static int[][] g;
	public static int[][] d;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void bfs(int x,int y,int cnt) {
		Queue<Pnt7> q = new  LinkedList<>();
		q.add(new Pnt7(x,y));
		g[x][y] = cnt;
		while(!q.isEmpty()) {
			Pnt7 cur = q.remove();
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(nx<0 || nx>n-1 || ny<0 || ny>n-1) continue;
				if(a[nx][ny]==1 && g[nx][ny]==0) {
					g[nx][ny] = cnt;//cur와 인접한 노드도 cnt로 그룹번호 지정!
					q.add(new Pnt7(nx,ny));
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		n = sc.nextInt();
		a = new int[n][n];
		g = new int[n][n];
		d = new int[n][n];
		//a와 d값 셋팅 완료.
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j] = sc.nextInt();

			}
		}
		int cnt=0;//섬 갯수 카운팅하면서 그룹번호 1차 지정완료.
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(a[i][j]==1 && g[i][j]==0) {
					bfs(i,j,++cnt);
				}
			}
		}
		//2+3 합쳐본다.거리배열 완성하는 척하면서 그룹배열업데이트. 조건무관하도록.
		Queue<Pair4> q = new LinkedList<Pair4>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(a[i][j]==1) {//육지이고, 방문한적 없는 좌표를 큐에 넣는다!
					d[i][j] = 0;
					q.add(new Pair4(i,j));//
				} else {
					d[i][j]=-1;
				}
			}
		}
		while(!q.isEmpty()) {//큐에서 나오는 좌표들은 다 육지좌표기 때문에 
			Pair4 cur = q.remove();//cur 기준 상하좌우 바다도 g[nx][ny] = g[x][y]해준다!
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(nx<0 || nx>n-1 || ny<0 || ny>n-1) continue;
				if(d[nx][ny] == -1) {
					d[nx][ny] = d[cur.x][cur.y]+1;
					g[nx][ny] = g[cur.x][cur.y];
				}
			}
		}
		//최소거리 정답 도출
		int ans = -1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<4;k++) {
					int x = i+dx[k];
					int y = j+dy[k];
					if(x<0 || x>n-1 || y<0 || y>n-1) continue;
					if(g[i][j] != g[x][y]) {
						if(ans == -1|| ans>d[i][j]+d[x][y]) {
							ans = d[i][j]+d[x][y];
						}
					}
				}
			}
		}
		System.out.println(ans);

	}

}
