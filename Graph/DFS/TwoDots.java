import java.util.*;
public class TwoDots{
	public static boolean[][] c;
	public static char[][] a;
	public static int n;
	public static int m;
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,-1,1};
	public static boolean  dfs(int x,int y,int px,int py,char color) {
		if(c[x][y]) return true;//방문한 적이 있다면 true! 자세한 처리는 아래에서!
		c[x][y] = true;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i],ny = y+dy[i];
			if(nx<0 || nx>n-1 || ny<0 || ny>m-1) continue;
			if(!(nx==px && ny==py)) {
				if(a[nx][ny]==color) {//이미 방문한 노드라도 방문해도 괜찮음. 싸이클 생성하는지 확인하는 것이 목표이니까!
					if(dfs(nx,ny,x,y,color)) return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();//행.
		m = sc.nextInt();//열.
		sc.nextLine();
		a = new char[n][m];
		c = new boolean[n][m];
		for(int i=0;i<n;i++) {
			String s = sc.nextLine();
			for(int j=0;j<m;j++) {
				a[i][j] = s.charAt(j);
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(c[i][j]) continue;
				boolean ok = dfs(i,j,0,0,a[i][j]);
				if(ok) {
					System.out.println("Yes");
					System.exit(0);
				}
			}
		}
		System.out.println("No");
	}

}
