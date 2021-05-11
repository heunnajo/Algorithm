import java.util.Scanner;
public class SamplingWine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
		}
		int[] d = new int[n+1];
		d[1] = a[1];
		if(n>=2) d[2] = a[1]+a[2];
		for(int i=3;i<=n;i++) {//3가지 경우의 수에 대한 d[i]를 각각 구하고 차례로 최댓값 비교 해서 큰값을 저장한다!
			d[i] = d[i-1];//i번째 포도주 선택 안하는 경우 
			d[i] = Math.max(d[i], d[i-2]+a[i]);//i번째 포도주 1번째 선택하는 경우 
			d[i] = Math.max(d[i], d[i-3]+a[i-1]+a[i]);//i번째 포도주 2번째 선택하는 경우 
		}
		int ans = d[1];
		for(int i=2;i<=n;i++) {
			ans = Math.max(ans, d[i]);//d[n]은 배열d에서 가장 큰값.
		}
		System.out.println(ans);
	}

}
