import java.util.*;
import java.io.*;
public class MoveCrashingWall2 {
	static class mcw{
		int x,y,dCnt,dist;
		mcw(int x,int y,int dCnt,int dist){
			this.x = x;
			this.y = y;
			this.dCnt = dCnt;
			this.dist = dist;
		}
	}
	static int n,m,k;
	static boolean[][][] visited;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean check(int x,int y) {
		return x<0 || y<0 || x>=n || y>=m;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		//System.out.print(k);
		map = new char[n][m];
		visited = new boolean[n][m][k+1];
		for(int i=0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
		}
		System.out.print(bfs());
		br.close();
	}
	static int bfs() {
		Queue<mcw> q = new LinkedList<>();
		q.add(new mcw(0,0,0,1));//x:0,y:0,dCnt:0,dist:1에서 시작.
		visited[0][0][0] = true;
		while(!q.isEmpty()) {
			mcw cur = q.remove();
			if(cur.x == n-1 && cur.y == m-1) {
				return cur.dist;
			}
			for(int d = 0;d<4;d++) {
				int nx = cur.x+dx[d];
				int ny = cur.y+dy[d];
				if(check2(nx,ny)) continue;
				
				if(map[nx][ny] == '1') {//벽인 경우.
					if(cur.dCnt < k && !visited[nx][ny][cur.dCnt+1]) {//다음이동좌표는 드릴 쓸것이기 때문에 중복검사하는 visited의마지막차원은 1에 대해서 검사.
						q.add(new mcw(nx,ny,cur.dCnt+1,cur.dist+1));
						visited[nx][ny][cur.dCnt+1] = true;
					}
				}else {//빈칸인 경우:현재까지 벽 부순 횟수를 그대로 다음으로 넘긴다.
					if(!visited[nx][ny][cur.dCnt]) {
						q.add(new mcw(nx,ny,cur.dCnt,cur.dist+1));
						visited[nx][ny][cur.dCnt] = true;
					}
				}
			}
		}
		return -1;
	}
	static boolean check2(int x,int y) {
		return x<0 || y<0 || x>=n || y>=m;
	}
}
