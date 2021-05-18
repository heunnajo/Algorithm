import java.util.*;
public class CainCalendar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			boolean flag = false;
			//x-1 = m, m단위로 건너 뛰면서 비교해보자!
			//경우의 수는 N*M가지 
			for(int i=x;i<(m*n);i+=m) {
				if(i%n == y) {
					flag = true;
					System.out.println(i+1);
					break;
				}
			}
			if(!flag) {
				System.out.println(-1);
			}
		}
	}

}
