import java.util.*;
public class BuyCard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//3
		int[] a = new int[n+1];
		for(int i=1;i<=n;i++) {//카드 i개 든 카드팩값 입력받는다.
			a[i] = sc.nextInt();//카드팩값 3개 입력받는다.
		}
		int[] d = new int[n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				if(d[i] < d[i-j] + a[j]) d[i] = d[i-j] + a[j];
			}
		}
		System.out.println(d[n]);
	}

}
