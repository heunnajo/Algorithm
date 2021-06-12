import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class TI2{
	int x, y;
	TI2(int x,int y){
		this.x = x;this.y = y;
	}
}
public class TreasureIsland {
	public static int r;
	public static int c;
	public static char[][] a;
	public static int[][] d;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int bfs(int x,int y) {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				d[i][j] = -1;
			}
		}
		int ans = -1;
		Queue<TI2> q = new LinkedList<TI2>();
		q.add(new TI2(x,y));
		d[x][y] = 0;
		while(!q.isEmpty()) {
			TI2 cur = q.remove();
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(nx<0 || nx>r-1 || ny<0 || ny>c-1) continue;
				if(a[nx][ny] == 'L'  && d[nx][ny]==-1) {
					q.add(new TI2(nx,ny));
					d[nx][ny] = d[cur.x][cur.y]+1;
				}
			}
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(ans == -1||ans<d[i][j]) {ans = d[i][j];}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();//행 
		c = sc.nextInt();//열 
		a = new char[r][c];
		d = new int[r][c];
		sc.nextLine();
		for(int i=0;i<r;i++) {
			String s = sc.nextLine();
			for(int j=0;j<c;j++) {
				a[i][j] = s.charAt(j);
			}
		}
		int res = -1;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(a[i][j]=='L') {
					if(res == -1 || res<bfs(i,j)) {
						res = bfs(i,j);
					}
				}
			}
		}
		System.out.println(res);
	}

}
