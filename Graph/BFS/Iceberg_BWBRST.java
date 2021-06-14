//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;
class IB4{
	int x,y;
	IB4(int x,int y){
		this.x = x;this.y = y;
	}
}
public class Iceberg_brbwst {
	public static int r,c;
	public static int[][] a,d;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void BFS(int x,int y,boolean[][] visited) {
		Queue<IB4> q = new LinkedList<IB4>();
		q.add(new IB4(x,y));
		visited[x][y] = true;
		while(!q.isEmpty()) {
			IB4 cur = q.remove();
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(nx<0 || nx>r-1 || ny<0 || ny>c-1)continue;
				if(!visited[nx][ny] && a[nx][ny] != 0) {
					visited[nx][ny] =  true;
					q.add(new IB4(nx,ny));
				}
			}
		}
	}
	public static int IB4Cnt() {//빙하 갯수 리턴!
		boolean[][] visited = new boolean[r][c];
		int cnt=0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(a[i][j]!=0 && !visited[i][j]) {//한 노드 방문할 때 IB4Cnt내에서 visited 방문 표시한다!
					BFS(i,j,visited);//탐색.
					cnt++;
				}
			}
		}
		return cnt;
	}
	public static void Melt() {
		Queue<IB4> q = new LinkedList<IB4>();
		boolean[][] fakeSea = new boolean[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(a[i][j] != 0) {
					q.add(new IB4(i,j));
					fakeSea[i][j] = true;
				}
			}
		}
		while(!q.isEmpty()) {
			IB4 cur = q.remove();
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
		d = new int[r][c];
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				d[i][j] = -1;
			}
		}
		int year =0;
		while(true) {
			Melt();year++;
			if(IB4Cnt()>=2) break;
			else if(IB4Cnt()==0){
				year = 0;
				break;
			}
		}
		bw.write(year+"\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
