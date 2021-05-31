import java.util.*;
import java.io.*;
class Point2 {
    int x;
    int y;
    Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class NumberofIsland {
	static int[] dir_r = {-1,1,0,0,-1,-1,1,1};
	static int[] dir_c = {0,0,-1,1,-1,1,-1,1};
	public static void bfs(int[][] a, int[][] group, int x, int y, int cnt, int n,int m) {
        Queue<Point2> q = new LinkedList<Point2>();
        q.add(new Point2(x, y));
        group[x][y] = cnt;
        while (!q.isEmpty()) {
            Point2 p = q.remove();
            x = p.x;
            y = p.y;
            for (int k=0; k<8; k++) {
                int nx = x+dir_r[k];
                int ny = y+dir_c[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                        q.add(new Point2(nx, ny));
                        group[nx][ny] = cnt;
                    }
                }
            }
        }
    }
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true){
			int m = sc.nextInt();
			int n = sc.nextInt();
			if(m==0&&n==0)break;
			int[][] map = new int[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			//섬의 갯수 센다! 1bfs = 1island
			int cnt = 0;
			int[][] group = new int[n][m];
			for (int i=0; i<n; i++) {
				for (int j=0; j<m; j++) {
					if (map[i][j] == 1 && group[i][j] == 0) {
						bfs(map, group, i, j, ++cnt, n,m);
					}
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.print(sb);
	}
}
