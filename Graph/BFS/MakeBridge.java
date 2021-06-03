import java.util.*;
class Pnt6{
	int x;int y;
	Pnt6(int x,int y){
		this.x = x;this.y = y;
	}
}
public class MakeBridge {
	public static int n;
	public static int[][] a;
	public static int[][] g;
	public static int[][] d;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	//g배열을 완성한다!
	public static void bfs(int x,int y,int cnt) {
		Queue<Pnt6> q = new  LinkedList<>();
		q.add(new Pnt6(x,y));
		g[x][y] = cnt;
		while(!q.isEmpty()) {
			Pnt6 cur = q.remove();
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(nx<0 || nx>n-1 || ny<0 || ny>n-1) continue;
				if(a[nx][ny]==1 && g[nx][ny]==0) {
					g[nx][ny] = cnt;//cur와 인접한 노드도 cnt로 그룹번호 지정!
					q.add(new Pnt6(nx,ny));
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
				d[i][j] = -1;
				if(a[i][j]==1) {
					d[i][j] = 0;
				}
			}
		}
		int cnt=0;//섬 갯수 카운팅.
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(a[i][j]==1 && g[i][j]==0) {
					bfs(i,j,++cnt);
				}
			}
		}
		//거리배열을 완성한다!기준점(dist[i][j]==0)으로부터 상하좌우 bfs돌리면서 거리 기록한다!
		Queue<Pnt6> q = new  LinkedList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(d[i][j]==0) {
					q.add(new Pnt6(i,j));
					while(!q.isEmpty()) {
						Pnt6 cur = q.remove();
						for(int k=0;k<4;i++) {
							int nx = cur.x+dx[k];
							int ny = cur.y+dy[k];
							if(nx<0 || nx>n-1 || ny<0 || ny>n-1) continue;
							if(d[nx][ny]==-1) {//유효성 체크.
								d[nx][ny] = d[cur.x][cur.y]+1;
								q.add(new Pnt6(nx,ny));
							}
						}
					}
				}
			}
		}
		int ans = -1;
		for(int l=1;l<=cnt;l++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(a[i][j]==1 && g[i][j]!=l) {
						if(ans == -1 || ans>d[i][j]-1) {
							ans = d[i][j]-1;
						}
					}
				}
			}
		}
		System.out.println(ans);
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(g[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				//System.out.printf("%3d",d[i][j]);
//				System.out.print(d[i][j]+" ");
//			}
//			System.out.println();
//		}
	}

}
