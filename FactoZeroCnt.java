package data_structures;
import java.util.*;
public class FactoZeroCnt {

	public static void main(String[] args) {
		//2의 소인수  갯수 < 5의 소인수 갯수 이기 때문에 
		//인수가 5인 갯수 세면 된다.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//1.N 입력받는다.
		int sum = 0;
		for(int i=0;i<N;i++) {
			int num = N/(5^i);//num : 100/5^0, 100/5^1, 100/5^2,..
			while(num > 0) {
				sum += num;
			}
		}
		System.out.println(sum);
	}

}
