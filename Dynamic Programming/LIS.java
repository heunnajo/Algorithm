import java.util.*;
public class LIS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] A =  new int[t];
		int[] d =  new int[t];
		for(int i=0;i<t;i++) {
			A[i] = sc.nextInt();
		}
		for(int i=0;i<t;i++) {
			d[i] = 1;
			for(int j=0;j<i;j++) {
				if(A[j] < A[i] && d[j]+1 > d[i]) {//d배열에서 현재 i번째 값보다 앞에 d[j]+1이 더 크다면 값 체인지!
					//d[i] += 1;d[i] 증가식 둘다 맞지만 아래식을 쓰는 것이 더 적합하다!
					d[i] = d[j] + 1;//d[i] 값 바꾸는 조건 : d[j]+1과 d[i] 비교.d[j]+1 > d[i] 이면 바꾼다!
				}
			}
		}
		int ans = 0;
		for(int i=0;i<t;i++) {
			ans = Math.max(ans, d[i]);
		}
		System.out.println(ans);
	}

}
