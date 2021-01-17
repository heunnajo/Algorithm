
public class UniquePath {

	public static void main(String[] args) {
		//int m = 3, n=7;
		int m = 2, n=2;
		UniquePath a = new UniquePath();
		System.out.println("m :"+m+" n:"+n);
		System.out.println("The number of unique paths : "+a.ways(m,n));
	}
	public int ways(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) {
            dp[i][0] = 1;
        }
        for(int i=0;i<n;i++) {
            dp[0][i] = 1;
        } 
        
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

}
