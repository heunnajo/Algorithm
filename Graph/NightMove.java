import java.util.*;
class Pnt4{
	int x;int y;
	Pnt4(){
		
	}
	Pnt4(int x,int y){
		this.x = x;this.y = y;
	}
}
public class NightMove {
	public static int[] dx = {-1,-2,-2,-1,1,2,2,1};
	public static int[] dy = {-2,-1,1,2,-2,-1,1,2};
	public static int[][] dist;
	public static void bfs(int n,int stx,int sty,int endx,int endy,int[][] dist) {
//		System.out.print("stx : "+stx+" ");
//		System.out.println("sty : "+sty);
//		System.out.print("endx : "+endx+" ");
//		System.out.println("endy : "+endy);
//		if(stx==endx && sty==endy) {return dist[endx][endy];}
		
		Queue<Pnt4> q = new LinkedList<Pnt4>();
		q.add(new Pnt4(stx,sty));
		dist[stx][sty] = 0;
		while(!q.isEmpty()) {
			Pnt4 cur = q.remove();
			for(int i=0;i<8;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(nx<0||nx>n-1||ny<0||ny>n-1)continue;//범위 체크.
				//check[nx][ny] = true;
				if(dist[nx][ny]==-1) {
					dist[nx][ny] = dist[cur.x][cur.y]+1;
					q.add(new Pnt4(nx,ny));
				} 
//				if(dist[nx][ny]>dist[cur.x][cur.y]+1) {//최솟값으로 갱신.
//					dist[nx][ny]=dist[cur.x][cur.y]+1;
//				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0) {
			int n = sc.nextInt();
			dist = new int[n][n];
			for(int i=0;i<n;i++) {
				Arrays.fill(dist[i], -1);
			}
			Pnt4 st = new Pnt4();
			Pnt4 end = new Pnt4();
			st.x = sc.nextInt();
			st.y = sc.nextInt();
			end.x = sc.nextInt();
			end.y = sc.nextInt();
			bfs(n,st.x,st.y,end.x,end.y,dist);//시작좌표 (x,y)에서 시작.
			System.out.println(dist[end.x][end.y]);
		}
	}

}
