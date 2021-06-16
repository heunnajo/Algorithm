import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class MoveCrashingWall_faster {
	static class MCW4{
		int x,y,dist,drill_cnt;
		MCW4(int x,int y,int dist,int drill_cnt){
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.drill_cnt = drill_cnt;
		}
	}
	
	static int n,m;
	static char[][] map;
	static boolean[][][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int bfs() {
		Queue<MCW4> q = new LinkedList<>();
		q.add(new MCW4(0,0,1,0));
		visit[0][0][0] = true;
		while(!q.isEmpty()) {
			MCW4 cur = q.remove();
			if(cur.x == n-1 && cur.y == m-1) {
				return cur.dist;
			}
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(check(nx,ny)) continue;
				
				if(cur.drill_cnt == 1) {
					if(visit[1][nx][ny] || map[nx][ny]=='1')continue;
					visit[1][nx][ny] = true;
					q.add(new MCW4(nx,ny,cur.dist+1,1));
				}
				else {
					if(visit[0][nx][ny]) continue;
					visit[map[nx][ny]-'0'][nx][ny] = true;
					q.add(new MCW4(nx,ny,cur.dist+1,map[nx][ny]-'0'));
				}
			}
		}
		return -1;
	}
	static boolean check(int x,int  y) {
		return x<0||y<0||x>n-1||y>m-1;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visit = new boolean[2][n][m];
		
		for(int i=0;i<n;i++) {
			map[i] = br.readLine().toCharArray();//공백 없는 숫자를 String으로 받아서 문자배열로 저장한다.정수로 변환하지 않는다는 것이 차이점.
		}
		System.out.println(bfs());
		br.close();
	}

}