package data_structures;
import java.util.*;
public class Editor2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();//초기 문자열 
		int n = sc.nextInt();//명령어 갯수
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		StringBuilder sb = new StringBuilder();//정답 담을 그릇.
		for(char c : s.toCharArray()) {//왼쪽 스택에 초기 문자열 캐릭터 다 넣는다.
			left.push(c);
		}
		
		while(n-- >0) {
			//명령어 입력 받는다.
			// String line = sc.nextLine();
			// String[] str = line.split(" ");
			// String cmd = str[0];
            String[] line = sc.nextLine().split(" ");
            char cmd = line[0].charAt(0);//글자 하나만 필요하니까! 불필요하게 String에 담을 필요 없다!

			if(cmd == 'L') {
                if(!left.empty()) {
				    right.push(left.pop());
                }
			} else if(cmd == 'R') {
                if(!right.empty()) {
				    left.push(right.pop());
                }
			} else if(cmd == 'B') {
                if(!left.empty()) {
				    left.pop();
                }
			} else if(cmd == 'P') {
                char c = line[1].charAt(0);
                left.push(c);
				// String newstr = sc.nextLine();
				// String[] newstrarr = newstr.split(" ");
				// String newc = newstrarr[0];
				// char newchar = newc.charAt(0);
				// left.push(newchar);
			}
		}
		while(!left.empty()) {
			right.push(left.pop());
		}
		while(!right.empty()) {
			sb.append(right.pop());
		}
		System.out.print(sb);
		
	}

}
