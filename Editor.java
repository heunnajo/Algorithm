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
			String line = sc.nextLine();
			String[] str = line.split(" ");
			String cmd = str[0];
			if(cmd.equals("L")) {
				right.push(left.pop());
			} else if(cmd.equals("R")) {
				left.push(right.pop());
			} else if(cmd.equals("B")) {
				left.pop();
			} else if(cmd.equals("P")) {
				String newstr = sc.nextLine();
				String[] newstrarr = newstr.split(" ");
				String newc = newstrarr[0];
				char newchar = newc.charAt(0);
				left.push(newchar);
			}
		}
		while(!left.isEmpty()) {
			right.push(left.pop());
		}
		while(!right.isEmpty()) {
			sb.append(right.pop());
		}
		System.out.print(sb);
		
	}

}
