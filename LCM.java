package data_structures;
import java.util.*;
public class LCM {
	static int GCD(int A, int B) {//A:24 B:16
		int tmp = 0;
		while(B != 0) {//A <- B,B <- A % B
			tmp = A;
			A = B;
			B = tmp % B;
		}
		return  A;
	}
	static int LCM(int A, int B) {
		int LCM = 0;
		LCM = A*B / GCD(A,B);
		return LCM;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			System.out.println(LCM(A,B));
		}
	}

}
