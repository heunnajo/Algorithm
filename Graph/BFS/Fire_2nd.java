import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
class position2{
	int x,y;
	position2(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Fire_2nd {
	public static int w,h;
	public static char[][] map;
	public static int[][] time;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static StringBuilder  sb;
	public static Queue<position2> fire;
	public static void spread() {
		//불인 좌표를 찾아서 인접 상하좌우 좌표 불로 만들어준다.
		//fire 큐에 있는좌표 하나씩 꺼내서 상하좌우 탐색, 상하좌우 인접노드 *로 바꿔준다!
		while(!fire.isEmpty()) {
			position2 cur = fire.remove();
			for(int i=0;i<4;i++) {//상근이의 다음 위치 next(nx,ny)
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(nx<0 || nx>h-1 || ny<0 || ny>w-1) continue;
				if(map[nx][ny]=='.'||map[nx][ny]=='@') {//이동할 수 있는 경우.불이 번질 수 있는 조건.
					map[nx][ny] = '*';
					fire.add(new position2(nx,ny));
				}
			}
		}
	}
	public static void bfs(int x,int y) {//@위치부터 시작해서 map 범위를 벗어날 때까지 걸리는 시간을 리턴.
		Queue<position2> q = new LinkedList<>();
		q.add(new position2(x,y));
		time[x][y] = 1;
		while(!q.isEmpty()) {//상근이의 다음이동을 담당하는 bfs순회 루프.      상근이는 map의 범위밖으로 가야한다!
			position2 cur = q.remove();
			spread();
			for(int i=0;i<4;i++) {//상근이의 다음 위치 next(nx,ny)
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(nx<0 || nx>h-1 || ny<0 || ny>w-1) {//정답이 되는 조건.  (탈출 : 다음 이동 좌표가 map의 범위밖)
					sb.append(time[cur.x][cur.y]+"\n");
					return;
				}
				if(map[nx][ny]=='.' && time[nx][ny]==0) {//이동할 수 있는 경우 : .이고, 방문하지 않은 노드일 때.
					q.add(new position2(nx,ny));
					time[nx][ny] = time[cur.x][cur.y]+1;
				}
			}
		}
		sb.append("IMPOSSIBLE"+"\n");
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int ans=0;
		sb = new StringBuilder();
		fire = new LinkedList<>();
		int t = Integer.parseInt(br.readLine());
		while(t-- >0) {
			String[] input = br.readLine().split(" ");
			w = Integer.parseInt(input[0]);//열.
			h = Integer.parseInt(input[1]);//행.
			map = new char[h][w];
			time = new int[h][w];
			int x = 0;int y = 0;
			for(int i=0;i<h;i++) {
				String s = br.readLine();
				for(int j=0;j<w;j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j]=='@') {
						x = i;y = j;
					} else if(map[i][j]=='*') {fire.add(new position2(i,j));}
				}
			}
			bfs(x,y);
		}
		System.out.println(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
