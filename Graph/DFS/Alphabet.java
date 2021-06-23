import java.util.*;
import java.io.*;
public class Alphabet {
	static int r,c,ans = 0;
	static int max = 0;
	static char[][] map;
	static boolean[] alpha = new boolean[26];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static void go(int x,int y,int d) {
		alpha[map[x][y]-'A'] = true;
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i]; int ny = y+dy[i];
			if(nx<0 || ny<0 || nx>=r || ny>=c) continue;
			
			if(!alpha[map[nx][ny]-'A']) {
				go(nx,ny,d+1);
			}
		}
		alpha[map[x][y]-'A'] = false;
		ans = Math.max(ans, d);//최댓값으로 갱신!!!
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for(int i=0;i<r;i++) {
			String input = br.readLine();
			for(int j=0;j<c;j++) {
				map[i][j] = input.charAt(j);
			}
		}
		go(0,0,1);
		System.out.println(ans);
	}

}
