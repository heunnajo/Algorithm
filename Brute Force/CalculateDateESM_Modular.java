import java.util.*;
public class CalculateDateESM_Modular {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt()-1;
		int S = sc.nextInt()-1;
		int M = sc.nextInt()-1;
		//나머지가 0이 되면 안 되는데 0이 되는 경우를 방지하기 위해
		//ESM을 각각 1씩 빼기 때문에 i도 1이 아닌 0부터 시작한다.
		for(int i=0;;i++) {
			if(i%15 == E && i%28 == S && i%19 == M) {
				System.out.println(i+1);
				break;
			}
		}
	}

}
