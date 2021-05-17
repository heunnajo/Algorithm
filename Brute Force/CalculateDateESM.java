import java.util.*;
public class CalculatedateESM_2nd {//그냥 다 해보기 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		int e = 1,s = 1,m = 1;//각각 1부터 시작.
		for(int i=1;;i++) {//년은 어떻게 찾을 것인가.
			if(e == E && s == S && m == M) {
				System.out.println(i);
				break;
			}
			e += 1;s += 1;m += 1;
			if(e == 16) {e = 1;}
			if(s == 29) {s = 1;}
			if(m == 20) {m = 1;}
		}
	}

}
