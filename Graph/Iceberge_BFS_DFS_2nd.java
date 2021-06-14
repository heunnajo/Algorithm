//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;
class IB5{
	int x,y;
	IB5(int x,int y){
		this.x = x;this.y = y;
	}
}
public class Iceberg_brbwst_BFS_DFS {
	public static int r,c;
	public static int[][] a,d;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void DFS(int x,int y,boolean[][] visited) {
		if(visited[x][y]) return;
		visited[x][y] =  true;//넘겨받은 visited[x][y]를 true로 처리.
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || nx>r-1 || ny<0 || ny>c-1)continue;
			if(!visited[nx][ny] && a[nx][ny] != 0) {
				DFS(nx,ny,visited);
			}
		}
	}
	public static int IB5Cnt() {//빙하 갯수 리턴!
		boolean[][] visited = new boolean[r][c];
		int cnt=0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(a[i][j]!=0 && !visited[i][j]) {//한 노드 방문할 때 IB5Cnt내에서 visited 방문 표시한다!
					DFS(i,j,visited);//탐색.
					cnt++;
				}
			}
		}
		return cnt;
	}
	public static void Melt() {
		Queue<IB5> q = new LinkedList<IB5>();
		boolean[][] fakeSea = new boolean[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(a[i][j] != 0) {
					q.add(new IB5(i,j));
					fakeSea[i][j] = true;
				}
			}
		}
		while(!q.isEmpty()) {
			IB5 cur = q.remove();
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
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		a = new int[r][c];
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int year =0; int cnt=0;
//		while(true) {
//			Melt();year++;
//			if(IB5Cnt()>=2) break;
//			else if(IB5Cnt()==0){
//				year = 0;
//				break;
//			}
//		}
//while문 리팩토링.속도&메모리 개선.
		while((cnt = IB5Cnt()) < 2) {
			if(cnt == 0) {
				year = 0;
				break;
			}
			Melt();
			year++;
		}
		bw.write(year+"\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
