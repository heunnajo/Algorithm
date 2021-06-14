import java.util.*;
class IB{
	int x,y;
	IB(int x,int y){
		this.x = x;this.y = y;
	}
}
public class Iceberg_BFS {
	public static int r,c;
	public static int[][] a,d;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void BFS(int x,int y,boolean[][] visited) {
		Queue<IB> q = new LinkedList<IB>();
		q.add(new IB(x,y));
		visited[x][y] = true;
		while(!q.isEmpty()) {
			IB cur = q.remove();
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(nx<0 || nx>r-1 || ny<0 || ny>c-1)continue;
				if(!visited[nx][ny] && a[nx][ny] != 0) {
					visited[nx][ny] =  true;
					q.add(new IB(nx,ny));
				}
			}
		}
	}
	public static int IBCnt() {
		boolean[][] visited = new boolean[r][c];
		int cnt=0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(a[i][j]!=0 && !visited[i][j]) {
					BFS(i,j,visited);
					cnt++;
				}
			}
		}
		return cnt;
	}
	public static void Melt() {
		Queue<IB> q = new LinkedList<IB>();
		boolean[][] fakeSea = new boolean[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(a[i][j] != 0) {
					q.add(new IB(i,j));
					fakeSea[i][j] = true;
				}
			}
		}
		while(!q.isEmpty()) {
			IB cur = q.remove();
			int zero_cnt = 0;
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(nx<0 || nx>r-1 || ny<0 || ny>c-1)continue;
				if(a[nx][ny]==0 && !fakeSea[nx][ny]) {
					zero_cnt++;
				}
			}
			if(a[cur.x][cur.y]-zero_cnt <0) {
				a[cur.x][cur.y] = 0;
			}
			else {
				a[cur.x][cur.y]-=zero_cnt;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		a = new int[r][c];
		d = new int[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				a[i][j] = sc.nextInt();
				d[i][j] = -1;
			}
		}
		int year =0;
		while(true) {
			Melt();year++;
			if(IBCnt()>=2) break;
			else if(IBCnt()==0){
				year = 0;
				break;
			}
		}
		System.out.println(year);
	}

}