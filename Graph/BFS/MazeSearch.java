import java.util.*;
class Pnt3{
	int x;int y;
	Pnt3(int x,int y){
		this.x = x;this.y = y;
	}
}
public class MazeSearch {
	public static int n;
	public static int m;
	public static int[][] a;
	public static int[][] dist;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void bfs(int x,int y) {//(0,0)에서 시작,dist 배열을 완성시킨다!
		Queue<Pnt3> q = new LinkedList<Pnt3>();
		q.add(new Pnt3(x,y));
		dist[x][y] = 1;
		while(!q.isEmpty()) {
			Pnt3 curr = q.remove();
			for(int i=0;i<4;i++) {
				int nx = curr.x+dx[i];
				int ny = curr.y+dy[i];
				if(nx<0 || nx>n-1 || ny<0 || ny>m-1) continue;
				if(a[nx][ny]==1 && dist[nx][ny]==-1) {
					q.add(new Pnt3(nx,ny));
					dist[nx][ny] = dist[curr.x][curr.y]+1;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();//행!
		m = sc.nextInt();//열!
		sc.nextLine();
		a = new int[n][m];
		dist = new int[n][m];
		for(int i=0;i<n;i++) {
			String s = sc.nextLine();
			for(int j=0;j<m;j++) {
				a[i][j] = s.charAt(j)-'0';
				dist[i][j] = -1;
			}
		}
		bfs(0,0);
		System.out.println(dist[n-1][m-1]);
	}
	
}