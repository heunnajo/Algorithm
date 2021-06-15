import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
class position{
	int x,y;
	position(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Fire {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static StringBuilder  sb;
	public static void bfs(char[][] map,int[][] time) {//@위치부터 시작해서 map 범위를 벗어날 때까지 걸리는 시간을 리턴.
		int h = map.length;//높이,행.
		int w = map[0].length;//너비,열.
		Queue<position> q = new LinkedList<>();
		ArrayList<position> impossible = new ArrayList<position>();
		boolean flag = false;
		//상근위치,불위치,불붙을 위치 저장.
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(map[i][j] == '@') {//상근 위치 큐에 넣기.
					q.add(new position(i,j));//상근 위치 x좌표,y좌표,시간은 1에서 시작.
					time[i][j] = 1;//방문체크 겸 시간 기록.
				} else if(map[i][j] == '#') {//벽 좌표 impossible 객체에 좌표 저장!
					impossible.add(new position(i,j));//불,벽,불붙을칸의 time은 -1로 초기화. 갈수 없는 영역이기때문에 time값도 불가능한 음수 -1로.
				}
				if(map[i][j] == '*') {//불 좌표.
					impossible.add(new position(i,j));
					for(int f=0;f<4;f++) {//불의 상하좌우 인접좌표.
						int fx = i+dx[f];
						int fy = j+dy[f];
						if(fx<0 || fx>h-1 || fy<0 || fy>w-1) continue;
						if(map[fx][fy]=='.'||map[fx][fy]=='@') {//불이 옮겨붙을 수 있는 좌표.
							impossible.add(new position(fx,fy));
						}
					}
				}
			}
		}
		while(!q.isEmpty()) {//상근이의 다음이동을 담당하는 bfs순회 루프.      상근이는 map의 범위밖으로 가야한다!
			position cur = q.remove();
			for(int i=0;i<4;i++) {//상근이의 다음 위치 next(nx,ny)
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				position next = new position(nx,ny);
				if(nx<0 || nx>h-1 || ny<0 || ny>w-1) {//정답이 되는 조건.  (탈출 : 다음 이동 좌표가 map의 범위밖)
					sb.append(time[cur.x][cur.y]);
					return;
				}
				//이동할 수 없는 경우       : impossible 배열 객체 순회.
				for(position p:impossible) {
					if(next.x == p.x && next.y== p.y) {//다음좌표       nx,ny가 impossible에 있는 좌표라면 이동할 수 없으므로 큐에 넣지 않는다. 아래 부분을 실행하면 안된다.
						flag = true;
						break;
					}
				}
				if(flag) continue;
				if(map[nx][ny]=='.' && time[nx][ny]==0) {//이동할 수 있는 경우 : .이고, 방문하지 않은 노드일 때.
					q.add(next);
					time[nx][ny] = time[cur.x][cur.y]+1;
				}
			}
		}
		sb.append("IMPOSSIBLE");
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int ans=0;
		sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());//t를 입력받고,
		while(t-- >0) {//t갯수만큼 w,h,2차원 배열 입력받는다!
			String[] input = br.readLine().split(" ");
			int w = Integer.parseInt(input[0]);//열.
			int h = Integer.parseInt(input[1]);//행.
			char[][] map = new char[h][w];
			int[][] time = new int[h][w];
			for(int i=0;i<h;i++) {
				String s = br.readLine();
				for(int j=0;j<w;j++) {
					map[i][j] = s.charAt(j);
				}
			}
			bfs(map,time);//sb를 만드는 함수.
			System.out.println(sb.toString());
//			ans = bfs(map,time);
//			if(ans == -1) {
//				System.out.println("IMPOSSIBLE");
//			} else {System.out.println(bfs(map,time));}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
