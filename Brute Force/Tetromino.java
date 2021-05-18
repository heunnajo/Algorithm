import java.util.*;
public class Tetromino {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//세로  
		int m = sc.nextInt();//가로 
		int[][] a = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		//19가지 도형에 대해서 어디 위치에 놓았을 때 최댓값을 갖는지 다 구해보면 된다!
		int ans = 0;
		for(int i=0;i<n;i++) {//가
			for(int j=0;j<m;j++) {//세로
				//1.막대 2가지 
				if(j+3<m) {
					int temp = a[i][j] + a[i][j+1] + a[i][j+2] + a[i][j+3];
					if(ans<temp) ans = temp;//4
				}
				if(i+3<n) {
					int temp = a[i][j] + a[i+1][j] + a[i+2][j] + a[i+3][j];
					if(ans<temp) ans = temp;//5 :ans =4->5.
				}
				//2. 네모 1가지 
				if(i+1 < n && j+1<m) {
					int temp = a[i][j] + a[i][j+1] + a[i+1][j] + a[i+1][j+1];
					if(ans<temp) ans = temp;//ans = 9
				}
				//3.꽈배기 4가지 
				if(i-1>=0 && j+2<m) {
					int temp =  a[i][j] + a[i][j+1] + a[i-1][j+1] + a[i-1][j+2];
					if(ans<temp) ans = temp;//ans = 13
				}
				if(i+2<n && j+1<m) {
					int temp =  a[i][j] + a[i+1][j] + a[i+1][j+1] + a[i+2][j+1];
					if(ans<temp) ans = temp;//ans = 13, 여기서 만든 temp합은 15라면 ans는 temp가 된다!
				}
				if(i+1<n && j+2<m) {
					int temp = a[i][j] + a[i][j+1] + a[i+1][j+1] + a[i+1][j+2];
					if(ans<temp) ans = temp;
				}
				if(i+2 < n && j-1>=0) {
					int temp = a[i][j] + a[i+1][j-1] + a[i+1][j] + a[i+2][j-1];
					if(ans<temp) ans = temp;
				}
				//4.산모양 4가지 
				if (j+2 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i][j+2];
                    if (i-1 >= 0) {
                        int temp2 = temp + a[i-1][j+1];
                        if (ans < temp2) ans = temp2;
                    }
                    if (i+1 < n) {
                        int temp2 = temp + a[i+1][j+1];
                        if (ans < temp2) ans = temp2;
                    }
                }
                if (i+2 < n) {
                    int temp = a[i][j] + a[i+1][j] + a[i+2][j];
                    if (j+1 < m) {
                        int temp2 = temp + a[i+1][j+1];
                        if (ans < temp2) ans = temp2;
                    }
                    if (j-1 >= 0) {
                        int temp2 = temp + a[i+1][j-1];
                        if (ans < temp2) ans = temp2;
                    }
                }
				//5.ㄱ모양 8가지
				if(i+1<n && j+2<m) {//O
					int temp = a[i][j] + a[i+1][j] + a[i+1][j+1] + a[i+1][j+2];
					if(ans<temp) ans = temp;
				}
				if(i+2<n && j+1<m) {//O
					int temp = a[i][j] + a[i][j+1] + a[i+1][j] + a[i+2][j];
					if(ans<temp) ans = temp;
				}
				if(i+1<n && j+2<m) {//O
					int temp = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+2];
					if(ans<temp) ans = temp;
				}
				if(i+2<n && j-1>=0) {//O
					int temp = a[i][j] + a[i+1][j] + a[i+2][j] + a[i+2][j-1];
					if(ans<temp) ans = temp;
				}
				if(i-1>=0 && j+2<m) {//O
					int temp = a[i][j] + a[i][j+1] + a[i][j+2] + a[i-1][j+2];
					if(ans<temp) ans = temp;
				}
				if(i+2<n && j+1<m) {//O
					int temp = a[i][j] + a[i+1][j] + a[i+2][j] + a[i+2][j+1];
					if(ans<temp) ans = temp;
				}
				if(i+1<n && j+2<m) {//O
					int temp = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j];
					if(ans<temp) ans = temp;
				}
				if(i+2<n && j+1<m) {//O
					int temp = a[i][j] + a[i][j+1] + a[i+1][j+1] + a[i+2][j+1];
					if(ans<temp) ans = temp;
				}
			}
		}
		System.out.println(ans);
	}

}
