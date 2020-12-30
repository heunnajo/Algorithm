package graph;

public class MaxAreaIsland {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
//		                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//		                {0,1,1,0,1,0,0,0,0,0,0,0,0},
//		                {0,1,0,0,1,1,0,0,1,0,1,0,0},
//		                {0,1,0,0,1,1,0,0,1,1,1,0,0},
//		                {0,0,0,0,0,0,0,0,0,0,1,0,0},
//		                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//		                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
//		int[][] grid = {{1,1,0,1,1},
//						{0,1,1,0,0},
//						{0,0,0,0,0},
//						{1,1,0,1,1},
//						{1,0,1,1,1},
//						{1,0,1,1,1}};
		
		int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		MaxAreaIsland a = new MaxAreaIsland();
		
		//System.out.println("Maximum Area of Island : ");
		System.out.println(a.maxArea(grid));

	}
	int m,n;
	int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	public int maxArea(int[][] grid) {
		//System.out.print("maxArea함수 들어옴  ");

        if(grid == null || grid.length == 0) return 0;
        //담을 그릇 생성
        m = grid.length;
        n = grid[0].length;
        
        int max = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) {
                	int area = dfs(grid,i,j,0);
                	System.out.println("area:"+area);
                	max = Math.max(max, area);
                    
                }
            }
        }
        
        return max;
        
    }
	int dfs(int[][] grid, int i, int j,int area) {
		//1. 탈출 조건 설정 - 또는(||) 
        if(i<0||i>=m||j<0||j>=n||grid[i][j] != 1) return area;
        //1인 육지에 해당하는 것들 실행. 
        //int area = 0; 
        
        grid[i][j] = 0;
        area++;//area = 0->1->2.
        for(int[] dir:dirs) {
        	area = dfs(grid,i+dir[0],j+dir[1],area);
        }
        
//        dfs(grid,i-1,j,area);//N/A
//        System.out.print("i:"+i);
//        System.out.print("j:"+j);
//        System.out.println("area:"+area);
//        //System.out.print("i: %d j:%d area:%d",i,j,area);
//        dfs(grid,i+1,j,area);//N/A
//        System.out.print("i:"+i);
//        System.out.print("j:"+j);
//        System.out.println("area:"+area);
//        dfs(grid,i,j-1,area);//N/A
//        System.out.print("i:"+i);
//        System.out.print("j:"+j);
//        System.out.println("area:"+area);
//        dfs(grid,i,j+1,area);//2
//        System.out.print("i:"+i);
//        System.out.print("j:"+j);
//        System.out.println("area:"+area);
        
        return area;
    }
	
}
