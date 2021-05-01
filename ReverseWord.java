package data_structures;
import java.util.*;
public class ReverseWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Stack<Character> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c == '<') {
				while(c != '>') {
					sb.append(c);
				}
				sb.append(c);
			}
			else if(c == '\n' || c == ' ') {//공백 문자거나 줄바꿈 문자이면 
				while(!s.isEmpty()) {//스택이 빌 때까지 
					System.out.println(st.pop());
				}
			}else {//공백 문자/ 줄바꿈 문자 아니면 
				st.push(c);//스택에 push.
			}
			st.push(c);
			System.out.println("stack push :" +c);//h,e,u,n
			sb.append(st.pop());//n u e h 가 되야하는데!!!!!
		
			System.out.print(sb);
		}
	}

}
