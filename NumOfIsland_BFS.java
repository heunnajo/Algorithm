package graph;
import java.util.*;

public class NumOfIsland_BFS {
	int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};//4방으로 돌리기전 4개의 좌표값이 필요하다. 
	int m,n;
	public static void main(String[] args) {
		char[][] grid= {
				{'1','1','0','0','1'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'},
				{'1','0','0','1','1'}
		};
		NumOfIsland_BFS a = new NumOfIsland_BFS();
		//print(grid);
		System.out.println(a.solve(grid));
	}
	
	public int solve(char[][] grid) {
		//error
		if(grid == null || grid.length == 0) return 0;
		int count = 0;
		m = grid.length;
		n = grid[0].length;
		//for loop
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j]=='1') {//1이면 본격적으로 4방으로 탐색 들어간다! 
					count++;
					bfs(grid,i,j);
				}
			}
		}
		return count;
	}
	
	public void bfs(char[][] grid, int x, int y) {//i,j를 (x,y)로 큐에 넣는다~! 
		//헷갈린다면 바베큐를 기억! BFS = Queue.
		//왜냐하면계속 담아두는 게 아니라 FIFO으로 나갈 것이기 때문에! 
		grid[x][y] = '0';
		Queue<int[]> queue = new LinkedList<>();//좌표값이 들어간다? 
		queue.offer(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			//int size = queue.size();//밑에 poll()로 빼서 쓰면 되기 때문에 size 불필요하다고 함.
			int[] point = queue.poll();//큐에서 좌표값 뽑아낸다.   
			//for(int i=0;i<size;i++) {//큐 사이즈만큼 돌린다.
				for(int[] dir:dirs) {//위에 선언한 4방향으로 돌린다.?  
					int x1 = point[0] + dir[0];
					int y1 = point[1] + dir[1];
					if(x1>=0 && y1>=0 && x1< m && y1<n && grid[x][y]=='1') {//들어오는 조건으로 만들어줌!
						grid[x1][y1] = '0';//X로 해야되는 거 아닌가. 원래 데이터와 혼동 ? 
						queue.offer(new int[] {x1,y1});
					}
				}
			//}
		}
	}
	
	public static void print(char[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				System.out.print(i);
				System.out.print(j+" ");
			}
			System.out.println("");
		}
	}
}
