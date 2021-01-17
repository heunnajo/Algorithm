package graph;
import java.util.*;
public class Maze_BFS {
	//이 문제의 핵심은 무엇인가.
	//DFS 풀이법과 BFS 풀이법의 비교, 차이점.
	public static void main(String[] args) {
		int[][] maze ={
				  {0,0,1,0,0},
				  {0,0,0,0,0},
				  {0,0,0,1,0},
				  {1,1,0,1,1},
				  {0,0,0,0,0}
				};
		int[] start = {0,4};
		int[] dest = {4,4};
		int[] dest2 = {3,2};
		Maze_BFS a = new Maze_BFS();
		System.out.println(a.hasPath(maze,start,dest));
		
		System.out.println("Start(0,4) and Destination(4,4) : "+a.hasPath(maze,start,dest));
		System.out.println("Start(0,4) and Destination(3,2) : "+a.hasPath(maze,start,dest2));
	}
	int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};//상 하 좌 우 
	int m,n;
	public boolean hasPath(int[][] maze, int[] start, int[] dest) {//hasPath 없어도 될 것 같은데 뭔가 visited 가 걸린다.
		//에러 제외 
		if(maze == null || maze.length == 0) return false;
		//0.담을 그릇 생성 
		m = maze.length;
		n = maze[0].length;
		boolean[][] visited = new boolean[m][n];//중복을 체크하는 배열. set으로 하거나 원래 좌표를 distintive한 다른 숫자값으로 처리하면 추가 저장공간 불필요.
		System.out.println("===================================");
		return bfs(maze,start,dest,visited);
	}
	public boolean bfs(int[][] maze, int[] start, int[] dest, boolean[][] visited) {
		//아닌 경우를 조건으로하여 예외처리.
		if(start[0] < 0 || start[0] >= m || start[1] < 0 || start[1] >= n || visited[start[0]][start[1]])
			return false;
		
		//1.담을 그릇 생성 
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);
		visited[start[0]][start[1]] = true;
		
		//탐색을 시작한다. (queue recursive loop)
		while(!queue.isEmpty()) {
			//큐에서 노드하나 뽑는다.
			int curr[] = queue.poll();
			//사방으로 돌린다.
			for(int[] dir:dirs) {
				int nx = curr[0];//queue에서 꺼낸 좌표는 for문 안에 들어와야한다. 
				int ny = curr[1];
				if(nx == dest[0] && ny == dest[1]) return true;//queue에서 나온 것이 목적지인지 확인!(처음엔 그럴리 없지만!)
				while(nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] != 1) {//조건이 참일 동안 KEEP ROLLING! 이 문제의 핵심!
					nx += dir[0];
					ny += dir[1];
				}
				nx -= dir[0];
				ny -= dir[1];
				if(visited[nx][ny]) continue;//방문했던 노드라면 아래 동작 제외. 
				queue.offer(new int[] {nx,ny});//큐에 새로운 좌표를 넣고 recursively proceed.
				visited[nx][ny] = true;
			}
		}
		return false;
	}
	

}
