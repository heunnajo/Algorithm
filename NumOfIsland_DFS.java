package graph;

public class NumOfIsland_DFS {
	
	public static void main(String[] args) {
		//1. 문제를 정확하게 이해해야한다. 
		char[][] grid = {
				{'1','1','1','0','1'},
				{'1','1','0','0','1'},
				{'1','1','0','0','0'},
				{'0','0','0','0','1'}
				};
		NumOfIsland_DFS a = new NumOfIsland_DFS();
		System.out.println(a.solve(grid));
	}
	int m,n;
	public int solve(char[][] grid) {
		if(grid == null || grid.length==0 || grid[0].length==0) return 0;
		m = grid.length;
		n = grid[0].length;
		
		//print(grid);
		int count = 0;
		//[0,0]부터 1인 위치를 찾는다~! 
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j]=='1') {
					count++;
					System.out.println("count starting point :");
					System.out.println("i: "+i+"j: "+j);
					dfs(grid,i,j);//not simply grid itself but also its location(i,j)
				}
			}
		}
		return count;
	}
	public void dfs(char[][] grid, int i, int j) {
		if(i<0 || i>=m||j<0||j>=n||grid[i][j] != '1') return;
		//System.out.println("i:"+i+"j:"+j);
		grid[i][j] = 'x';//dfs가 방문한 곳은 x로 표시  
		
		//4방으로 탐색한다.
		dfs(grid,i-1,j);//위 
		dfs(grid,i+1,j);//아래 
		dfs(grid,i,j-1);//왼쪽 
		dfs(grid,i,j+1 );//오른쪽 
	}
	public void print(char[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				System.out.print("grid["+i+"]["+j+"]:" + grid[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
