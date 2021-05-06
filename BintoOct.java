package data_structures;
import java.util.*;
public class BintoOct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = s.length();
		//charAt()을 이용하여 i번째 자릿수 값을 가져올 수 있음!
		if(n%3 == 1) {
			System.out.print(s.charAt(0));
		} else if(n%3 == 2) {
			System.out.print((s.charAt(0) -'0')*2 + (s.charAt(1) -'0')*1);
		}
		for(int i= n%3;i<n;i+=3) {//n이 3의 배수인지, 나머지가 1,2인지에 따라 3씩 잘라 계산하는 시작점이 달라진다!
			//n이 3의 배수이면 charAt(0)부터 시작!
			//n이 3으로 나눈 나머지 1이면 위의 if문 먼저 실행후, charAt(1)부터 계산하면 됨!
			//n이 3으로 나눈 나머지 2이면 위의 if문 먼저 실행후, charAt(2)부터 계산하면 됨!
			System.out.print((s.charAt(i) -'0')*4 + (s.charAt(i+1) -'0')*2 + (s.charAt(i+2) -'0'));
		}
		System.out.println();
	}

}
