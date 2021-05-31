import java.util.*;
class Pnt2{
	int x;int y;
	Pnt2(int x,int y){
		this.x = x; this.y = y;
	}
}
public class Tomato {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//열.
		int m = sc.nextInt();//행.
		int[][] a = new int[m][n];
		int[][] dist = new int[m][n];
		Queue<Pnt2> q = new LinkedList<Pnt2>();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				a[i][j] = sc.nextInt();
				dist[i][j] = -1;
				if(a[i][j] == 1) {//익은 토마토!
					q.add(new Pnt2(i,j));
					dist[i][j] = 0;
				}
			}
		}
		while(!q.isEmpty()) {
			Pnt2 cur = q.remove();
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(0<=nx && nx<m && 0<=ny && ny<n) {
					if(a[nx][ny]==0 && dist[nx][ny]==-1) {
						q.add(new Pnt2(nx,ny));
						dist[nx][ny] = dist[cur.x][cur.y]+1;
					}
				}
			}
		}
		int ans = 0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				ans = Math.max(ans, dist[i][j]);
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(a[i][j]==0 && dist[i][j]==-1) ans = -1;
			}
		}
		System.out.println(ans);
	}

}
