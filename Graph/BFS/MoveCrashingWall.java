import java.util.Queue;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class MCW {
	int x,y,dist,drill;
	MCW(int x,int y,int dist,int drill){
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.drill = drill;
	}
}
public class MoveCrashingWall {
	public static final int max = Integer.MAX_VALUE;
	public static int n,m,ans;
	public static int[][] map,visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void bfs(int x,int y) {//(0,0)에서 시작, (n-1,m-1)까지 d배열 완성.
		Queue<MCW>  q = new LinkedList<MCW>();
		q.add(new MCW(x,y,1,0));//x,y,dist,drill
		visit[x][y] = 0;//드릴 횟수 0.
		while(!q.isEmpty()) {
			MCW cur = q.remove();
			if(cur.x == n-1 && cur.y == m-1) {
				ans = cur.dist;
				break;
			}
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];//지금 필요한 건 nx와 ny인데, 
				int ny = cur.y+dy[i];
				if(nx<0 || nx>n-1 || ny<0 || ny>m-1)continue;
				//if(visit[nx][ny]<=visit[cur.x][cur.y])continue;
				if(visit[nx][ny]<=cur.drill)continue;
				if(map[nx][ny]==0) {//벽이 아닌 경우.
					visit[nx][ny] = cur.drill;//현재의 드릴 횟수 저장.
					q.add(new MCW(nx,ny,cur.dist+1,cur.drill));
				}
				else {//벽인 경우.
					if(cur.drill == 0) {
						visit[nx][ny] = cur.drill+1;
						q.add(new MCW(nx,ny,cur.dist+1,cur.drill+1));
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
	    map = new int[n][m];
		visit = new int[n][m];
		
	    for (int i=0; i<n; i++) {
	    	input = br.readLine().split("");
	        for (int j=0; j<m; j++) {
	            map[i][j] = Integer.parseInt(input[j]);
	            visit[i][j] = max;
	        }
	    }
	    ans = max;
		bfs(0,0);
		if(ans == max) System.out.println(-1);
		else System.out.println(ans);
	}

}
