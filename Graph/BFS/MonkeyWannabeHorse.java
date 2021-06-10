import java.util.*;
import java.io.*;
class mwh3 {
	int x;
	int y;
	int jump;
	int cnt;
	mwh3(int x,int y,int jump,int cnt){
		this.x = x;this.y = y;this.jump = jump;this.cnt = cnt;
	}
}
public class MonkeyWannabeHorse {
	public static int k;
	public static int w;
	public static int h;
	public static int[][] a;
	public static boolean[][][] visited;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int[] kdx = {-1,-2,-2,-1,1,2,2,1};
	public static int[] kdy = {-2,-1,1,2,-2,-1,1,2};
	public static void bfs() {
		Queue<mwh3> q = new LinkedList<mwh3>();
		q.add(new mwh3(0,0,0,0));
		while(!q.isEmpty()) {
			mwh3 cur = q.remove();
			if(cur.x == h-1 && cur.y ==w-1) {
				System.out.println(cur.cnt);
				return;
			}
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(nx<0 || nx>h-1 || ny<0 || ny>w-1) continue;
				if(a[nx][ny]==0 && !visited[nx][ny][cur.jump]) {
					q.add(new mwh3(nx,ny,cur.jump,cur.cnt+1));
					visited[nx][ny][cur.jump] = true;
				}
			}
			if(cur.jump+1<=k) {
				for(int j=0;j<8;j++) {
					int kx = cur.x+kdx[j];
					int ky = cur.y+kdy[j];
					if(kx<0 || kx>h-1 || ky<0 || ky>w-1) continue;
					if(a[kx][ky]==0 && !visited[kx][ky][cur.jump+1]) {
						q.add(new mwh3(kx,ky,cur.jump+1,cur.cnt+1));
						visited[kx][ky][cur.jump+1] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		String[] t = br.readLine().split(" ");
		w = Integer.parseInt(t[0]);
		h = Integer.parseInt(t[1]);
		
		a = new int[h][w];
		visited = new boolean[h][w][k+1];
		for(int i=0;i<h;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<w;j++) {
				a[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		bfs();
	}

}