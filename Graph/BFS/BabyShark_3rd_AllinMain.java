import java.io.*;
import java.util.*;
public class BabyShark_3rd_AllinMain {
	static int n,time,Sx,Sy,Scnt,Ssize;
	static int[][] map;
	static ArrayList<Fish> fishes;
	static int[] dx = {-1,1,0,0};//상,좌,하,우 순서.
	static int[] dy = {0,0,-1,1};
	
	static class Fish {
		int x,y,d;
		Fish(int x,int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	static boolean check(int x,int y) {
		return x<0 || y<0 || x>=n || y>=n;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		Ssize = 2;
		
		for(int i=0;i<n;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if(map[i][j]==9) {
					Sx = i;Sy = j;
					map[i][j] = 0;//거리 0으로 만들어준다.
				}
			}
		}
		
		while(true) {
			//0.물고기 사냥 BFS에 필요한 변수,객체 생성. 
			fishes = new ArrayList<Fish>();
			Queue<Fish> q = new LinkedList<Fish>();
			boolean[][] visited = new boolean[n][n];
			q.add(new Fish(Sx,Sy,0));//초기 상어위치 거리값은 0. 상어를 큐에 넣어준다!
			visited[Sx][Sy] = true;
			
			//1.물고기 찾아서 리스트에 저장!
			while(!q.isEmpty()) {
				Fish shark = q.remove();
				
				for(int d=0;d<4;d++) {
					int nx = shark.x+dx[d];
					int ny = shark.y+dy[d];
					
					if(nx<0||ny<0||nx>n-1||ny>n-1) continue;
					if(visited[nx][ny])continue;
					
					//못지나가는 경우 : 상어크기보다 물고기가 크거나 이미 방문한 노드일 때.
					//if(Ssize < map[nx][ny]) continue;구현 안하면 됨.
					
					//물고기<상어:먹을 수 있다. 0이면 먹으나마나이기때문에 0보다 크도록 범위 걸어준다!
					if(1<=map[nx][ny] && map[nx][ny]<Ssize) {
						q.add(new Fish(nx,ny,shark.d+1));
						visited[nx][ny] = true;
						fishes.add(new Fish(nx,ny,shark.d+1));
					}
					//물고기==상어:지나갈 수 있다.
					else if(map[nx][ny]==Ssize || map[nx][ny]==0) {
						q.add(new Fish(nx,ny,shark.d+1));
						visited[nx][ny] = true;
					}
				}
			}
			//종료조건!!!!!!
			if(fishes.size()==0) {
				System.out.println(time);
				return;
			}
			
			//2.먹을 물고기 선택!-우선순위에 따라 구현!
			Fish eFish = fishes.get(0);
			for(int i=1;i<fishes.size();i++) {
				Fish tmp = fishes.get(i);
				if(eFish.d >tmp.d ) {eFish = tmp;}
				if(eFish.d == tmp.d) {
					if(eFish.x >tmp.x) {
						eFish = tmp;
					}
//					if(eFish.x == tmp.x) {
//						if(eFish.y >tmp.y) {eFish = tmp;}
//					}
				}
			}
			
			//3.먹을 수 있는 물고기 있는 경우
			time += eFish.d;
			Scnt++;
			map[eFish.x][eFish.y] = 0;//먹었으니 0으로.
			
			if(Scnt == Ssize) {
				Ssize++;
				Scnt = 0;
			}
			Sx = eFish.x; Sy = eFish.y;//상어 다음 위치.
			//q.add(new Fish(Sx,Sy,0));//위에 것 삭제? 아니면 이거랑 위에랑  새로운 상어위치 2번 들어갈 것 같은데..
			//위에서 Sx,Sy 큐에 넣는 부분 있으니까 상어위치(Sx,Sy)만 갱신해준다!
		}
	}

}
