package data_structures;
import java.util.*;

public class GCDnLCM {
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
		Scanner  sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.println("GCD(A,B) :"+GCD(A,B));
		System.out.println("LCM(A,B) :"+LCM(A,B));
	}
	
}
