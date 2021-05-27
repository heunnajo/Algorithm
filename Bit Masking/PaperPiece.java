import java.util.*;
public class PaperPiece {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		//비트마스킹.
		int ans=0;
		for(int s=0;s<(1<<(n*m));s++) {
			int sum=0;//각각의 경우의 합.
			//1.가로수 구하기.
			for(int i=0;i<n;i++) {
				int cur=0;//현재 가로에 대해서 가로수를 구해야하기 때문에 n-for문 밑에 있어야함!
				for(int j=0;j<m;j++) {
					int k=i*m+j;
					if((s&(1<<k))==0) {cur = cur*10+a[i][j];}//가로일 때 합.
					else {sum+=cur;cur=0;}
				}
				sum += cur;//for문 나가기 전에, 세로 만나지 않았을 때 마지막에 현재까지의 cur 더해준다.
			}
			//2.세로수 구하기.
			for(int j=0;j<m;j++) {
				int cur=0;
				for(int i=0;i<n;i++) {
					int k=i*m+j;
					if((s&(1<<k))!=0) {cur = cur*10+a[i][j];}
					else {sum+=cur;cur=0;}
				}
				sum+=cur;//가로를 만나지 않았을 때 마지막에 현재까지의 cur 더해준다. 
			}
			//sum에는 가로합과 세로합이 다 더해져있다.
			ans = Math.max(ans, sum);
			//sum이 있는 for문을 나가기 전에 최댓값을 비교해서 ans에 저장해서 for문 스코프 밖으로 나간다.
		}
		System.out.println(ans);
	}

}
