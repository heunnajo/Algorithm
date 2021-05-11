import java.util.Scanner;
public class Sticker {
	static int n;
	static int[][] a;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0) {
			n = sc.nextInt();
			a = new int[3][n+1];
			for(int i=1;i<=2;i++) {//i는 1,2 
				for(int j=1;j<=n;j++) {//j는 1부터 n까지 
					a[i][j] = sc.nextInt();
				}
			}
			int[][] d = new int[3][n+1];
			d[0][0] = 0;
			for(int i=1;i<=n;i++) {
				if(i-1>=0) {
					d[0][i] = Math.max(Math.max(d[0][i-1], d[1][i-1]),d[2][i-1])+a[0][i];
					d[1][i] = Math.max(d[0][i-1], d[2][i-1])+a[1][i];
					d[2][i] = Math.max(d[0][i-1], d[1][i-1])+a[2][i];
				}
			}
			System.out.println(Math.max(Math.max(d[0][n], d[1][n]), d[2][n]));
		}
	}

}
