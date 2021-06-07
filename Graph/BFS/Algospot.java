import java.util.*;
class Algo{
	int  x;int y;
	Algo(int x,int y){
		this.x = x;this.y = y;
	}
}
public class Algospot {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();//세로(행)
		sc.nextLine();
		int[][] a = new int[n][m];
		int[][] d = new int[n][m];
		//공백없이 입력받을 것이기 때문에 String으로 받은 다음 charAt(j)-'0' 해준다~
		for(int i=0;i<n;i++) {
			String s = sc.nextLine();
			for(int j=0;j<m;j++) {
				a[i][j] = s.charAt(j)-'0';
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				d[i][j] = -1;
			}
		}
		Deque<Algo> q = new LinkedList<Algo>();
		q.add(new Algo(0,0));
		d[0][0] = 0;
		while(!q.isEmpty()) {
			Algo cur = q.remove();
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(nx<0 || nx>n-1 || ny<0 || ny>m-1)continue;
				if(d[nx][ny]==-1) {
					if(a[nx][ny]==1) {//가중치 1.
						d[nx][ny] = d[cur.x][cur.y]+1;
						q.addLast(new Algo(nx,ny));
					} else {//가중치 0.
						d[nx][ny] = d[cur.x][cur.y];
						q.addFirst(new Algo(nx,ny));
					}
				}
			}
		}
		System.out.println(d[n-1][m-1]);
	}
}