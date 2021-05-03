package data_structures;
import java.util.*;
public class FactoZeroCnt {

	public static void main(String[] args) {
		//2의 소인수  갯수 < 5의 소인수 갯수 이기 때문에 
		//인수가 5인 갯수 세면 된다.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//1.N 입력받는다.
		int sum = 0;
		for(int i=5;i<=N;i*=5) {
			sum += N/i;
		}
		System.out.println(sum);
	}

}
