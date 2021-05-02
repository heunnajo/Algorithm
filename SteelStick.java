package data_structures;
import java.util.*;
public class SteelStick {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1.문자열 입력받는다.
		String s = sc.nextLine().trim();
		//String s = sc.next();
		//2.연산 처리할 스택 생성  
		Stack<Integer> st = new Stack<>();
		//3.정답 담을 그릇 생성 
		int ans = 0;
		int n = s.length();
		//반복문 돌린다. 문자열 각각 하나씩 가져와서 스택 연산 처리한다.
		for(int i=0;i<n;i++) {
			char c = s.charAt(i);
			if(c == '(') {
				st.push(i);
			} else {//c==')', 인덱스 차이 판별해야함!
				if(st.peek()+1 == i) {//레이져 
					st.pop();
					ans += st.size();
				} else {//쇠막대기 
					st.pop();
					ans += 1;
				}
			}
			
		}
		System.out.println(ans);
		
	}

}
